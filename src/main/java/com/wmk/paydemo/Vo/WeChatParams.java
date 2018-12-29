package com.wmk.paydemo.Vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 微信支付需要的一些参数
 */
public class WeChatParams {
    @Getter
    @Setter
    private String totalFee;//订单金额【备注：以分为单位】
    @Getter
    @Setter
    public String body;//商品名称
    @Getter
    @Setter
    public String outTradeNo;//商户订单号
    @Getter
    @Setter
    public String attach;//附加参数
    @Getter
    @Setter
    public String memberid;//会员ID
}
