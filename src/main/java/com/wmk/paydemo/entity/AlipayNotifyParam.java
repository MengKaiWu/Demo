package com.wmk.paydemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AlipayNotifyParam implements Serializable {
    @Getter
    @Setter
    private String appId;
    @Getter
    @Setter
    private String tradeNo; // 支付宝交易凭证号
    @Getter
    @Setter
    private String outTradeNo; // 原支付请求的商户订单号
    @Getter
    @Setter
    private String outBizNo; // 商户业务ID，主要是退款通知中返回退款申请的流水号
    @Getter
    @Setter
    private String buyerId; // 买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字
    @Getter
    @Setter
    private String buyerLogonId; // 买家支付宝账号
    @Getter
    @Setter
    private String sellerId; // 卖家支付宝用户号
    @Getter
    @Setter
    private String sellerEmail; // 卖家支付宝账号
    @Getter
    @Setter
    private String tradeStatus; // 交易目前所处的状态，见交易状态说明
    @Getter
    @Setter
    private BigDecimal totalAmount; // 本次交易支付的订单金额
    @Getter
    @Setter
    private BigDecimal receiptAmount; // 商家在交易中实际收到的款项
    @Getter
    @Setter
    private BigDecimal buyerPayAmount; // 用户在交易中支付的金额
    @Getter
    @Setter
    private BigDecimal refundFee; // 退款通知中，返回总退款金额，单位为元，支持两位小数
    @Getter
    @Setter
    private String subject; // 商品的标题/交易标题/订单标题/订单关键字等
    @Getter
    @Setter
    private String body; // 该订单的备注、描述、明细等。对应请求时的body参数，原样通知回来
    @Getter
    @Setter
    private Date gmtCreate; // 该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss
    @Getter
    @Setter
    private Date gmtPayment; // 该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss
    @Getter
    @Setter
    private Date gmtRefund; // 该笔交易的退款时间。格式为yyyy-MM-dd HH:mm:ss.S
    @Getter
    @Setter
    private Date gmtClose; // 该笔交易结束时间。格式为yyyy-MM-dd HH:mm:ss
    @Getter
    @Setter
    private String fundBillList; // 支付成功的各个渠道金额信息,array
    @Getter
    @Setter
    private String passbackParams; // 公共回传参数，如果请求时传递了该参数，则返回给商户时会在异步通知时将该参数原样返回。
}
