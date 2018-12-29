package com.wmk.paydemo.service;

import com.wmk.paydemo.entity.Refundmsg;
import com.wmk.paydemo.entity.SystemPayConfig;

public interface AlirefundService {
    /**
     * 统一退款退款
     * @param systemPayConfig 商户支付信息配置
     * @param orderId 需要退款的订单号
     * @return
     */
    String refundByPC(Refundmsg refundmsg, SystemPayConfig systemPayConfig, String orderId);
}
