package com.wmk.paydemo.service;

import com.wmk.paydemo.Vo.RequestPay;
import com.wmk.paydemo.Vo.WeChatParams;
import com.wmk.paydemo.entity.SystemPayConfig;

import javax.servlet.http.HttpServletResponse;

public interface WxpayService {

    void nativePay(RequestPay requestPay, SystemPayConfig payConfig, HttpServletResponse response)throws Exception;

    void nativePay(WeChatParams ps,HttpServletResponse httpResponse) throws Exception;
}
