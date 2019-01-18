package com.wmk.paydemo.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.wmk.paydemo.dao.SystemOrderMapper;
import com.wmk.paydemo.dao.SystemPayConfigMapper;
import com.wmk.paydemo.entity.AlipayNotifyParam;
import com.wmk.paydemo.entity.SystemOrder;
import com.wmk.paydemo.entity.SystemPayConfig;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wumk
 * @date 2018.12.26
 * 支付宝回调通知接口
 */
@Controller
public class AlipayCallbackController {

    @Autowired
    private SystemOrderMapper systemOrderMapper;
    @Autowired
    private SystemPayConfigMapper systemPayConfigMapper;

    private static Logger logger = LoggerFactory.getLogger(AlipayCallbackController.class);
    private ExecutorService executorService = Executors.newFixedThreadPool(20);

    /**
     * 处理支付宝回调通知
     * @param request
     * @return
     */
    @RequestMapping("/alipay_callback")
    @ResponseBody
    public String callback(HttpServletRequest request) {
        Map<String, String> params = convertRequestParamsToMap(request); // 将异步通知中收到的待验证所有参数都存放到map中
        String paramsJson = JSON.toJSONString(params);
        //orderService.modifyOrder(params.get("out_trade_no"),params.get("gmt_payment"),params.get("trade_status"),params.toString());
        logger.info("支付宝回调，{}", paramsJson);
        try {
            //根据返回的信息去查找支付配置
            SystemPayConfig systemPayConfig = systemPayConfigMapper.selectByAppId(params.get("app_id"));
            // 调用SDK验证签名
            boolean signVerified = AlipaySignature.rsaCheckV1(params, systemPayConfig.getAlipayPublicKey(), systemPayConfig.getCharset(), systemPayConfig.getSignType());
            if (signVerified) {
                logger.info("支付宝回调签名认证成功");
                // 按照支付结果异步通知中的描述，对支付结果中的业务内容进行1\2\3\4二次校验，校验成功后在response中返回success，校验失败返回failure
                this.check(params,systemPayConfig);
                // 另起线程处理业务
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        AlipayNotifyParam param = buildAlipayNotifyParam(params);
                        String trade_status = param.getTradeStatus();
                        // 支付成功
                        if (trade_status.equals("TRADE_SUCCESS") || trade_status.equals("TRADE_FINISHED")) {
                            // 处理支付成功逻辑
                            try {
                                System.out.println("++++++++++++++++++++++处理业务逻辑+++++++++++++++++++++++");
                                //更新数据库订单信息
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                SystemOrder systemOrder = systemOrderMapper.selectByPrimaryKey(params.get("out_trade_no"));
                                if(systemOrder!=null){
                                    systemOrder.setTradeNo(params.get("trade_no"));
                                    systemOrder.setBuyerId(params.get("buyer_id"));
                                    systemOrder.setSellerId(params.get("seller_id"));
                                    systemOrder.setReceiptAmount(Double.valueOf(params.get("receipt_amount")));
                                    systemOrder.setBuyerPayAmount(Double.valueOf(params.get("buyer_pay_amount")));
                                    systemOrder.setSubject(params.get("subject"));
                                    systemOrder.setGmtCreate(sdf.parse(params.get("gmt_create")));
                                    systemOrder.setGmtPayment(sdf.parse(params.get("gmt_payment")));
                                    systemOrder.setNotifyTime(sdf.parse(params.get("notify_time")));
                                    systemOrder.setTradeStatus(params.get("trade_status"));
                                    systemOrder.setReturnJson(params.toString());
                                }
                                systemOrderMapper.updateByPrimaryKeySelective(systemOrder);
                                //通知调用者支付成功(并返回订单号)
                                Map<String,String> map = new HashMap<>();
                                map.put("cashflow",systemOrder.getCashflowSn());
                                map.put("tradesn",systemOrder.getOrderId());
                                String maps = getMap("http://118.190.202.65:8081/order/callback", map);
                                //判段用户是否收到通知
                                if(!maps.equals("true")){
                                    System.out.println("====================传输异常！");
                                }
                            } catch (Exception e) {
                                logger.error("支付宝回调业务处理报错,params:" + paramsJson, e);
                            }
                        } else {
                            logger.error("没有处理支付宝回调业务，支付宝交易状态：{},params:{}",trade_status,paramsJson);
                        }
                    }
                });
                // 如果签名验证正确，立即返回success，后续业务另起线程单独处理
                // 业务处理失败，可查看日志进行补偿，跟支付宝已经没多大关系。
                return "success";
            } else {
                logger.info("支付宝回调签名认证失败，signVerified=false, paramsJson:{}", paramsJson);
                return "failure";
            }
        } catch (AlipayApiException e) {
            logger.error("支付宝回调签名认证失败,paramsJson:{},errorMsg:{}", paramsJson, e.getMessage());
            return "failure";
        }
    }

    /**
     * 将request中的参数转换成Map
     * @param request
     * @return
     */
    private static Map<String, String> convertRequestParamsToMap(HttpServletRequest request) {

        Map<String, String> retMap = new HashMap<String, String>();

        Set<Map.Entry<String, String[]>> entrySet = request.getParameterMap().entrySet();

        for (Map.Entry<String, String[]> entry : entrySet) {
            String name = entry.getKey();
            String[] values = entry.getValue();
            int valLen = values.length;

            if (valLen == 1) {
                retMap.put(name, values[0]);
            } else if (valLen > 1) {
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append(",").append(val);
                }
                retMap.put(name, sb.toString().substring(1));
            } else {
                retMap.put(name, "");
            }
        }

        return retMap;
    }

    private AlipayNotifyParam buildAlipayNotifyParam(Map<String, String> params) {
        String json = JSON.toJSONString(params);
        return JSON.parseObject(json, AlipayNotifyParam.class);
    }

    /**
     * 对支付宝返回的信息进行验证
     * @param params
     * @throws AlipayApiException
     */
    private void check(Map<String, String> params, SystemPayConfig payConfig) throws AlipayApiException {
        String outTradeNo = params.get("out_trade_no");
        // 验证通知数据中的out_trade_no是否为商户系统中创建的订单号，
        SystemOrder orderByOutTradeNo = getOrderByOutTradeNo(outTradeNo);
        if (orderByOutTradeNo == null) {
            throw new AlipayApiException("out_trade_no错误");
        }
        // 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        /*long total_amount = new BigDecimal(params.get("total_amount")).multiply(new BigDecimal(100)).longValue();
        if (total_amount != order.getPay_amount().longValue()) {
            throw new AlipayApiException("error total_amount");
        }*/
        String total_amount = params.get("total_amount");
        if(Double.parseDouble(total_amount) != orderByOutTradeNo.getPayAmount()){
            throw new AlipayApiException("total_amount不一致");
        }

        // 3、校验通知中的seller_id（或者seller_email)是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），

        // 4、验证app_id是否为该商户本身。
        if (!params.get("app_id").equals(payConfig.getAppId())) {
            throw new AlipayApiException("app_id不一致");
        }
    }

    private SystemOrder getOrderByOutTradeNo(String outTradeNo) {
        SystemOrder systemOrder = systemOrderMapper.selectByPrimaryKey(outTradeNo);
        return systemOrder;
    }
    /**
     * 发送Http请求通知订单支付结果
     * @param url
     * @param map
     * @return
     */
    public static String getMap(String url,Map<String,String> map)
      {
                 String result = null;
                 CloseableHttpClient httpClient = HttpClients.createDefault();
                 List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                 //封装请求参数
                 for(Map.Entry<String,String> entry : map.entrySet())
                     {
                         pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
                     }
                 //接受响应结果
                 CloseableHttpResponse response = null;
                 try {
                         //设置请求地址
                         URIBuilder builder = new URIBuilder(url);
                         builder.setParameters(pairs);
                         HttpGet get = new HttpGet(builder.build());
                         response = httpClient.execute(get);
                         if(response != null && response.getStatusLine().getStatusCode() == 200)
                             {
                                 HttpEntity entity = response.getEntity();
                                 result = EntityUtils.toString(entity);
                             }
                         return result;
                     } catch (URISyntaxException e) {
                         e.printStackTrace();
                     } catch (ClientProtocolException e) {
                         e.printStackTrace();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }finally {
                         try {
                                 httpClient.close();
                                 if(response != null)
                                     {
                                         response.close();
                                     }
                             } catch (IOException e) {
                                 e.printStackTrace();
                             }
                     }
                 return result;
            }

}
