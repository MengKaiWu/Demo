package com.wmk.paydemo.config;

/**
 * 微信支付配置文件
 */
public class WeChatConfig {
    /**
     * 微信服务号APPID
     */
    public static String APPID="wxd1a8595966a4c9be";
    /**
     * 微信支付的商户号
     */
    public static String MCHID="1237981102";
    /**
     * 微信支付的API密钥
     */
    public static String APIKEY="xingzoukeji20181127wumengkai6666";
    /**
     * 微信支付成功之后的回调地址【注意：当前回调地址必须是公网能够访问的地址】
     */
    public static String WECHAT_NOTIFY_URL_PC="http://58.87.127.24:8888/image/0.png";
    /**
     * 微信统一下单API地址
     */
    public static String UFDODER_URL="https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * true为使用真实金额支付，false为使用测试金额支付（1分）
     */
    public static String WXPAY="0.01";
}
