package com.wmk.paydemo.service;

import com.wmk.paydemo.entity.Refundmsg;
import com.wmk.paydemo.entity.SystemPayConfig;

public interface WxrefudeService {
    String refundByPC(SystemPayConfig systemPayConfig, String orderId);
}
