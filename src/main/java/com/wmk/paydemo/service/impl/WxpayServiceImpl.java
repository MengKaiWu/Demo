package com.wmk.paydemo.service.impl;

import com.google.zxing.WriterException;
import com.wmk.paydemo.Vo.WeChatParams;
import com.wmk.paydemo.service.WxpayService;
import com.wmk.paydemo.util.QRCodeFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class WxpayServiceImpl implements WxpayService {
    @Override
    public void nativePay(WeChatParams ps, HttpServletResponse response) throws Exception{
        ps.setBody("测试商品3");
        ps.setTotalFee("1");
        ps.setOutTradeNo("hw5409550792199899");  //随机订单号
        ps.setAttach("xiner");
        ps.setMemberid("888");
        //生成图片
        String content= com.wmk.paydemo.test.WeixinPay.getCodeUrl(ps);
        com.wmk.paydemo.test.WeixinPay.encodeQrcode(content,response);
        //PrintWriter pw = null;
        //pw.println("");
    }
}
