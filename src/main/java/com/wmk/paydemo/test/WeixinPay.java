package com.wmk.paydemo.test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.wmk.paydemo.Vo.RequestPay;
import com.wmk.paydemo.config.WeChatConfig;
import com.wmk.paydemo.entity.SystemPayConfig;
import com.wmk.paydemo.util.HttpUtil;
import com.wmk.paydemo.util.PayForUtil;
import com.wmk.paydemo.util.XMLUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Slf4j
public class WeixinPay {

    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xFFFFFFFF;

    /**
     * 获取微信支付的二维码地址
     * @return
     * @author chenp
     * @throws Exception
     */
    public static String getCodeUrl(RequestPay requestPay, SystemPayConfig payConfig, String tradeNo) throws Exception {
        /**
         * 账号信息
         */
        /*String appid = WeChatConfig.APPID;//微信服务号的appid
        String mch_id = WeChatConfig.MCHID; //微信支付商户号
        String key = WeChatConfig.APIKEY; // 微信支付的API密钥
        String notify_url = WeChatConfig.WECHAT_NOTIFY_URL_PC;//回调地址【注意，这里必须要使用外网的地址】
        String ufdoder_url=WeChatConfig.UFDODER_URL;//微信下单API地址
        String trade_type = "NATIVE"; //类型【网页扫码支付】*/
        /**
         * 时间字符串
         */
        String currTime = PayForUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = PayForUtil.buildRandom(4) + "";
        String nonce_str = strTime + strRandom;

        /**
         * 参数封装
         */
        SortedMap<Object,Object> packageParams = new TreeMap<Object,Object>();
        packageParams.put("appid", payConfig.getAppId());
        packageParams.put("mch_id", payConfig.getMchId());
        packageParams.put("nonce_str", nonce_str);//随机字符串
        packageParams.put("body", requestPay.getSubject());//支付的商品名称
        //packageParams.put("out_trade_no", ps.getOutTradeNo()+nonce_str);//商户订单号【备注：每次发起请求都需要随机的字符串，否则失败。】
        packageParams.put("out_trade_no",tradeNo);
        System.out.println("===================tradeNo"+tradeNo);
        System.out.println("===================out_trade_no: "+"hw5409550792199879"+nonce_str);
        packageParams.put("total_fee", requestPay.getTotalAmount());//支付金额
        packageParams.put("spbill_create_ip", PayForUtil.localIp());//客户端主机
        packageParams.put("notify_url", payConfig.getNotifyUrl());
        packageParams.put("trade_type", payConfig.getSignType());
        packageParams.put("attach", requestPay.getAttach());//额外的参数【业务类型+会员ID+支付类型】


        String sign = PayForUtil.createSign("UTF-8", packageParams,payConfig.getRsaPrivateKey());  //获取签名
        packageParams.put("sign", sign);

        String requestXML = PayForUtil.getRequestXml(packageParams);//将请求参数转换成String类型
        log.info("微信支付请求参数的报文"+requestXML);
        String resXml = HttpUtil.postData(payConfig.getMethod(),requestXML);  //解析请求之后的xml参数并且转换成String类型
        Map map = XMLUtil.doXMLParse(resXml);
        log.info("微信支付响应参数的报文"+resXml);
        String urlCode = (String) map.get("code_url");

        return urlCode;
    }

    /**
     * 将路径生成二维码图片
     * @author chenp
     * @param content
     * @param response
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void encodeQrcode(String content, HttpServletResponse response){

        if(StringUtils.isBlank(content))
            return;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Map hints = new HashMap();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 250, 250,hints);
            BufferedImage image = toBufferedImage(bitMatrix);
            //输出二维码图片流
            try {
                ImageIO.write(image, "png", response.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (WriterException e1) {
            e1.printStackTrace();
        }
    }
    /**
     * 类型转换
     * @author chenp
     * @param matrix
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
            }
        }
        return image;
    }
    // 特殊字符处理
    public static String UrlEncode(String src)  throws UnsupportedEncodingException {
        return URLEncoder.encode(src, "UTF-8").replace("+", "%20");
    }
}
