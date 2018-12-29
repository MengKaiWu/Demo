package com.wmk.paydemo.Vo;

import lombok.Getter;
import lombok.Setter;

public class RequestPay {
    @Getter
    @Setter
    private String reqType; //支付类型
    @Getter
    @Setter
    private String systemId; //系统ID
    @Getter
    @Setter
    private String cashflowSn; //请求系统自己的流水单号
    @Getter
    @Setter
    private Integer productCode; //销售产品码,必填
    @Getter
    @Setter
    private String totalAmount; //商品总金额,必填
    @Getter
    @Setter
    private String subject;//商品标题,必填
    @Getter
    @Setter
    private String body;//订单描述,可选
    @Getter
    @Setter
    private String passbackParams;//公用回传参数,可选
    @Getter
    @Setter
    private String sysServiceProviderId;//系统商编号,该参数作为系统商返佣数据提取的依据,必填
}
