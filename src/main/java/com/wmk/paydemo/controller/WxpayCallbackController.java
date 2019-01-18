package com.wmk.paydemo.controller;

import com.wmk.paydemo.config.WeChatConfig;
import com.wmk.paydemo.dao.SystemOrderMapper;
import com.wmk.paydemo.dao.SystemPayConfigMapper;
import com.wmk.paydemo.entity.SystemOrder;
import com.wmk.paydemo.util.PayForUtil;
import com.wmk.paydemo.util.XMLUtil;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;
@Slf4j
@Controller
public class WxpayCallbackController {
    @Autowired
    private SystemOrderMapper systemOrderMapper;
    @Autowired
    private SystemPayConfigMapper systemPayConfigMapper;
    /**
     * pc端微信支付之后的回调方法
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="wechat_notify_url_pc")
    public void wechat_notify_url_pc(HttpServletRequest request, HttpServletResponse response) throws Exception{

        //读取参数
        InputStream inputStream ;
        StringBuffer sb = new StringBuffer();
        inputStream = request.getInputStream();
        String s ;
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while ((s = in.readLine()) != null){
            sb.append(s);
        }
        in.close();
        inputStream.close();

        //解析xml成map
        Map<String, String> m = new HashMap<String, String>();
        m = XMLUtil.doXMLParse(sb.toString());

        //过滤空 设置 TreeMap
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        Iterator<String> it = m.keySet().iterator();
        while (it.hasNext()) {
            String parameter = it.next();
            String parameterValue = m.get(parameter);

            String v = "";
            if(null != parameterValue) {
                v = parameterValue.trim();
            }
            packageParams.put(parameter, v);
        }
        // 微信支付的API密钥
        String key = WeChatConfig.APIKEY; // key

        log.info("微信支付返回回来的参数："+packageParams);
        //判断签名是否正确
        if(PayForUtil.isTenpaySign("UTF-8", packageParams,key)) {
            //------------------------------
            //处理业务开始
            //------------------------------
            String resXml = "";
            if("SUCCESS".equals((String)packageParams.get("result_code"))){
                // 这里是支付成功
                //执行自己的业务逻辑开始
                String app_id = (String)packageParams.get("appid");
                String mch_id = (String)packageParams.get("mch_id");
                String openid = (String)packageParams.get("openid");
                String is_subscribe = (String)packageParams.get("is_subscribe");//是否关注公众号

                //附加参数【商标申请_0bda32824db44d6f9611f1047829fa3b_15460】--【业务类型_会员ID_订单号】
                String attach = (String)packageParams.get("attach");
                //商户订单号
                String out_trade_no = (String)packageParams.get("out_trade_no");
                //付款金额【以分为单位】
                String total_fee = (String)packageParams.get("total_fee");
                //微信生成的交易订单号
                String transaction_id = (String)packageParams.get("transaction_id");//微信支付订单号
                //支付完成时间
                String time_end=(String)packageParams.get("time_end");

                log.info("app_id:"+app_id);
                log.info("mch_id:"+mch_id);
                log.info("openid:"+openid);
                log.info("is_subscribe:"+is_subscribe);
                log.info("out_trade_no:"+out_trade_no);
                log.info("total_fee:"+total_fee);
                log.info("额外参数_attach:"+attach);
                log.info("time_end:"+time_end);
                System.out.println("++++++++++++++++++++++处理业务逻辑+++++++++++++++++++++++");
                //更新数据库订单信息
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SystemOrder systemOrder = systemOrderMapper.selectByPrimaryKey(out_trade_no);
                if(systemOrder!=null){
                    systemOrder.setTradeNo(transaction_id);
                    systemOrder.setReceiptAmount(Double.valueOf(total_fee));
                    systemOrder.setBuyerPayAmount(Double.valueOf(total_fee));
                    //systemOrder.setGmtPayment(sdf.parse());
                    systemOrder.setTradeStatus(packageParams.get("result_code").toString());
                    systemOrder.setReturnJson(packageParams.toString());
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
                //执行自己的业务逻辑结束
                log.info("支付成功");
                //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";

            } else {
                log.info("支付失败,错误信息：" + packageParams.get("err_code"));
                resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                        + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
            }
            //------------------------------
            //处理业务完毕
            //------------------------------
            BufferedOutputStream out = new BufferedOutputStream(
                    response.getOutputStream());
            out.write(resXml.getBytes());
            out.flush();
            out.close();
        } else{
            log.info("通知签名验证失败");
        }
    }

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
