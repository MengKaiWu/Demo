package com.wmk.paydemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.wmk.paydemo.dao.SystemOrderMapper;
import com.wmk.paydemo.dao.SystemRefundMapper;
import com.wmk.paydemo.entity.Refundmsg;
import com.wmk.paydemo.entity.SystemOrder;
import com.wmk.paydemo.entity.SystemPayConfig;
import com.wmk.paydemo.entity.SystemRefund;
import com.wmk.paydemo.service.WxrefudeService;
import com.wmk.paydemo.util.HttpUtil;
import com.wmk.paydemo.util.PayForUtil;
import com.wmk.paydemo.util.XMLUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jdom2.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.URISyntaxException;
import java.security.KeyStore;
import java.util.*;

@Slf4j
@Service
@Transactional
public class WxrefudeServiceImpl  implements WxrefudeService {
    @Autowired
    private SystemRefundMapper systemRefundMapper;
    @Autowired
    private SystemOrderMapper systemOrderMapper;

    private byte[] certData;
    @Override
    public String refundByPC(SystemPayConfig systemPayConfig, String orderId) {
        //根据订单ID查询退款信息
        SystemOrder systemOrder = systemOrderMapper.selectByPrimaryKey(orderId);
        if(systemOrder==null){
            return "订单号不存在！";
        }
        String currTime = PayForUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = PayForUtil.buildRandom(4) + "";
        String nonce_str = strTime + strRandom;

        SortedMap<Object,Object> map = new TreeMap<>();
        map.put("appid", systemPayConfig.getAppId());
        map.put("mch_id", systemPayConfig.getMchId());
        map.put("nonce_str", nonce_str);
        map.put("transaction_id", systemOrder.getTradeNo());
        map.put("out_refund_no", "hw5409550792199879"+nonce_str);
        map.put("total_fee", Integer.valueOf(systemOrder.getPayAmount().intValue()).toString());
        map.put("refund_fee", Integer.valueOf(systemOrder.getPayAmount().intValue()).toString());
        String sign = PayForUtil.createSign("UTF-8", map,systemPayConfig.getRsaPrivateKey());  //获取签名
        map.put("sign", sign);
        String requestXML = PayForUtil.getRequestXml(map);//将请求参数转换成String类型
        log.info("微信支付请求参数的报文"+requestXML);
        //String resXml = HttpUtil.postData("https://api.mch.weixin.qq.com/secapi/pay/refund",requestXML);  //解析请求之后的xml参数并且转换成String类型
        String result = null;
        //String url= "\\usr\\java\\apiclient_cert.p12";
        InputStream certStream = getCertStream();
        try {
            result = executeBySslPost("https://api.mch.weixin.qq.com/secapi/pay/refund", requestXML, certStream, systemPayConfig.getMchId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map maps = null;
        try {
            maps = XMLUtil.doXMLParse(result);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String return_code = (String) maps.get("return_code");
        System.out.println("=================================================================");
        System.out.println(result);
        SystemRefund systemRefund = new SystemRefund();
        systemRefund.setOutTradeNo(maps.get("out_trade_no").toString());
        systemRefund.setTradeNo(maps.get("transaction_id").toString());
        systemRefund.setBuyerLogonId(maps.get("refund_id").toString());
        systemRefund.setFundChange(maps.get("refund_channel").toString());
        systemRefund.setGmtRefundPay(new Date());
        systemRefund.setRefundFee(Double.valueOf(maps.get("refund_fee").toString()));
        systemRefundMapper.insert(systemRefund);
        System.out.println("=================================================================");
        return return_code;
    }

    /*public static void main(String[] args) {
        String currTime = PayForUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = PayForUtil.buildRandom(4) + "";
        String nonce_str = strTime + strRandom;

        SortedMap<Object,Object> map = new TreeMap<>();
        map.put("appid", "wxd1a8595966a4c9be");
        map.put("mch_id", "1237981102");
        map.put("nonce_str", nonce_str);
        map.put("transaction_id", "4200000242201901147217735800");
        map.put("out_refund_no", "hw5409550792199879"+nonce_str);
        map.put("total_fee", "1");
        map.put("refund_fee", "1");
        String sign = PayForUtil.createSign("UTF-8", map,"xingzoukeji20181127wumengkai6666");  //获取签名
        map.put("sign", sign);
        String requestXML = PayForUtil.getRequestXml(map);//将请求参数转换成String类型
        log.info("微信支付请求参数的报文"+requestXML);
        //String resXml = HttpUtil.postData("https://api.mch.weixin.qq.com/secapi/pay/refund",requestXML);  //解析请求之后的xml参数并且转换成String类型
        String result = null;
        String url= "C:\\Users\\LENG\\Downloads\\apiclient_cert.p12";
        try {
            result = executeBySslPost("https://api.mch.weixin.qq.com/secapi/pay/refund", requestXML, url, "1237981102");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("=================================================================");
        System.out.println(result);
        System.out.println("=================================================================");
    }*/
    public static String executeBySslPost(String url, String body,InputStream certificatePath,String password) throws Exception {
        String result = "";
        //商户id
        //指定读取证书格式为PKCS12
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        //读取本机存放的PKCS12证书文件
        //FileInputStream instream = new FileInputStream(new File(certificatePath));

        try {
            //指定PKCS12的密码(商户ID)
            keyStore.load(certificatePath, password.toCharArray());
        } finally {
            //instream.close();
        }
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, password.toCharArray()).build();
        //指定TLS版本
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        //设置httpclient的SSLSocketFactory
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {
            HttpPost httppost = new HttpPost(url);
            StringEntity reqEntity = new StringEntity(body, "UTF-8");
            httppost.setEntity(reqEntity);

            System.out.println("Executing request: " + httppost.getRequestLine());
            CloseableHttpResponse response = null;
            try {
                response = httpclient.execute(httppost);
                result = EntityUtils.toString(response.getEntity(),"UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
                log.error("请求失败", e);
                throw new RuntimeException(e);
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("请求失败", e);
            throw new RuntimeException(e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public InputStream getCertStream() {
        try {
            InputStream certStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/apiclient_cert.p12");
            this.certData = IOUtils.toByteArray(certStream);
            certStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

}
