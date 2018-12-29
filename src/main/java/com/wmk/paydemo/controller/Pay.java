package com.wmk.paydemo.controller;

import com.wmk.paydemo.Vo.RequestPay;
import com.wmk.paydemo.dao.SystemPayConfigMapper;
import com.wmk.paydemo.entity.SystemPayConfig;
import com.wmk.paydemo.service.AlipayService;
import com.wmk.paydemo.Vo.WeChatParams;
import com.wmk.paydemo.service.WxpayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * wumk
 */
@Controller
@Api(tags = {"支付接口"})
public class Pay {
    @Autowired
    private AlipayService alipayService;
    @Autowired
    private WxpayService wxpayService;
    @Autowired
    private SystemPayConfigMapper systemPayConfigMapper;

    /**
     * 微信支付测试
     * @param ps
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/wxPay")
    @ApiOperation(value = "微信扫码支付")
    public void wxPay(WeChatParams ps,HttpServletResponse httpResponse) throws Exception {
        wxpayService.nativePay(ps,httpResponse);
    }
    /**
     * 统一支付请求接口
     */
    @PostMapping(value = "/topay")
    @ApiOperation(value = "请求支付")
    public void unifyPay(@RequestBody RequestPay requestPay,HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        SystemPayConfig systemPayConfig = systemPayConfigMapper.selectByPrimaryKey(requestPay.getSystemId());
        if (systemPayConfig != null) {
            if ("alipay_pc".equals(requestPay.getReqType())) {
                alipayService.payByPC(requestPay,systemPayConfig, httpRequest, httpResponse);
            } else if ("alipay_appweb".equals(requestPay.getReqType())) {
                alipayService.payByPhoneWeb(systemPayConfig, httpRequest, httpResponse);
            } else if ("alipay_app".equals(requestPay.getReqType())) {

            }
        } else {
            //处理系统账号不存在的情况
        }
    }
    @GetMapping(value = "/topaytest")
    @ApiOperation(value = "请求支付测试")
    public void unifyPaytest(String reqType,String systemId,HttpServletRequest httpRequest, HttpServletResponse httpResponse)throws ServletException, IOException{
        RequestPay requestPay = new RequestPay();
        SystemPayConfig systemPayConfig = systemPayConfigMapper.selectByPrimaryKey(systemId);
        if (systemPayConfig != null) {
            if ("alipay_pc".equals(reqType)) {
                alipayService.payByPC(requestPay,systemPayConfig, httpRequest, httpResponse);
            } else if ("alipay_appweb".equals(requestPay.getReqType())) {
                alipayService.payByPhoneWeb(systemPayConfig, httpRequest, httpResponse);
            } else if ("alipay_app".equals(requestPay.getReqType())) {

            }
        } else {
            //处理系统账号不存在的情况
        }
    }
}
