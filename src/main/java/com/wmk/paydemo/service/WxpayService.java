package com.wmk.paydemo.service;

import com.wmk.paydemo.Vo.WeChatParams;

import javax.servlet.http.HttpServletResponse;

public interface WxpayService {
    void nativePay(WeChatParams ps, HttpServletResponse response)throws Exception;
}
