package com.wmk.paydemo.service;

import com.wmk.paydemo.Vo.RequestPay;
import com.wmk.paydemo.entity.SystemPayConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AlipayService {
    /**
     * pc端支付
     * @param systemPayConfig
     * @param httpRequest
     * @param httpResponse
     * @throws ServletException
     * @throws IOException
     */
    void payByPC(RequestPay requestPay, SystemPayConfig systemPayConfig, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException;

    /**
     * 手机移动 端支付
     * @param systemPayConfig
     * @param httpRequest
     * @param httpResponse
     * @throws ServletException
     * @throws IOException
     */
    void payByPhoneWeb(SystemPayConfig systemPayConfig, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException;

    /**
     * 手机APP支付
     */

}
