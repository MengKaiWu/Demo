package com.wmk.paydemo.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.wmk.paydemo.Vo.RequestPay;
import com.wmk.paydemo.dao.SystemOrderMapper;
import com.wmk.paydemo.entity.SystemOrder;
import com.wmk.paydemo.entity.SystemPayConfig;
import com.wmk.paydemo.service.AlipayService;
import com.wmk.paydemo.util.BuilderOrderNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;

@Service
public class AlipayServiceImpl implements AlipayService {
    @Autowired
    private SystemOrderMapper systemOrderMapper;
    @Override
    public void payByPC(RequestPay requestPay, SystemPayConfig payConfig, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        String order_num=null;
        //根据系统号与请求支付的流水号查找该笔订单是否支付过
        SystemOrder systemOrder = systemOrderMapper.selectBySystemIdAndCashflowSn(payConfig.getSystemId(), requestPay.getCashflowSn());
        if(systemOrder!=null){
            order_num = systemOrder.getOrderId();
        }else{
            //生成唯一 随机单号
            order_num = BuilderOrderNum.crete();
            //记录此次订单信息
            SystemOrder systemOrder1 = new SystemOrder();
            systemOrder1.setOrderId(order_num);  //系统唯一订单号
            systemOrder1.setPayAmount(Double.valueOf(requestPay.getTotalAmount()));    //该笔支付的金额
            systemOrder1.setPayMent("支付宝网页端支付");  //该笔支付的类型
            systemOrder1.setCashflowSn(requestPay.getCashflowSn());  //该笔订单所属系统的流水号
            systemOrder1.setSystemId(payConfig.getSystemId());  //该笔订单所属的系统
            systemOrderMapper.insertSelective(systemOrder1);
        }
        //调用支付宝服务
        AlipayClient alipayClient = new DefaultAlipayClient(payConfig.getMethod(), payConfig.getAppId(), payConfig.getRsaPrivateKey(), payConfig.getFormat(), payConfig.getCharset(), payConfig.getAlipayPublicKey(), payConfig.getSignType()); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(payConfig.getReturnUrl()); //付款成功返回跳转页面
        alipayRequest.setNotifyUrl(payConfig.getNotifyUrl()); //支付宝服务器主动通知商户服务器里指定的页面http/https路径
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"" + order_num + "\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":\"" + requestPay.getTotalAmount() + "\"," +
                "    \"subject\":\"" + URLEncoder.encode(requestPay.getSubject(),"utf-8") + "\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }" +
                "  }");//填充业务参数
        String form = "";
        AlipayTradePagePayResponse response = null;
        try {
            response = alipayClient.pageExecute(alipayRequest);
            form = response.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + payConfig.getCharset());
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @Override
    public void payByPhoneWeb(SystemPayConfig payConfig, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        String order_num = BuilderOrderNum.crete();
        AlipayClient alipayClient = new DefaultAlipayClient(payConfig.getMethod(), payConfig.getAppId(), payConfig.getRsaPrivateKey(), payConfig.getFormat(), payConfig.getCharset(), payConfig.getAlipayPublicKey(), payConfig.getSignType()); //获得初始化的AlipayClient
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(payConfig.getReturnUrl()); //支付成功后返回的页面
        alipayRequest.setNotifyUrl(payConfig.getNotifyUrl()); //在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                " \"out_trade_no\":\"" + order_num + "\"," +
                " \"total_amount\":\"88.88\"," +
                " \"subject\":\"Iphone6 16G\"," +
                " \"product_code\":\"QUICK_WAP_PAY\"" +
                " }");//填充业务参数
        String form = "";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + payConfig.getCharset());
        httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
}
