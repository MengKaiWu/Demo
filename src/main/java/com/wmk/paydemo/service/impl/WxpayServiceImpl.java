package com.wmk.paydemo.service.impl;

import com.google.zxing.WriterException;
import com.wmk.paydemo.Vo.RequestPay;
import com.wmk.paydemo.Vo.WeChatParams;
import com.wmk.paydemo.dao.SystemOrderMapper;
import com.wmk.paydemo.entity.SystemOrder;
import com.wmk.paydemo.entity.SystemPayConfig;
import com.wmk.paydemo.service.WxpayService;
import com.wmk.paydemo.util.BuilderOrderNum;
import com.wmk.paydemo.util.QRCodeFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class WxpayServiceImpl implements WxpayService {
    @Autowired
    private SystemOrderMapper systemOrderMapper;
    @Override
    public void nativePay(RequestPay requestPay, SystemPayConfig payConfig, HttpServletResponse response) throws Exception{
        String order_num=null;
        //根据系统号与请求支付的流水号查找该笔订单是否支付过
        SystemOrder systemOrder = systemOrderMapper.selectBySystemIdAndCashflowSn(payConfig.getSystemId(), requestPay.getCashflowSn());
        if(systemOrder!=null){
            order_num = systemOrder.getOrderId();
        }else{
            //生成唯一 随机单号
            order_num = BuilderOrderNum.crete().substring(0,31);
            //记录此次订单信息
            SystemOrder systemOrder1 = new SystemOrder();
            systemOrder1.setOrderId(order_num);  //系统唯一订单号
            systemOrder1.setPayAmount(Double.valueOf(requestPay.getTotalAmount()));    //该笔支付的金额
            systemOrder1.setPayMent("微信网页端支付");  //该笔支付的类型
            systemOrder1.setCashflowSn(requestPay.getCashflowSn());  //该笔订单所属系统的流水号
            systemOrder1.setSystemId(payConfig.getSystemId());  //该笔订单所属的系统
            systemOrderMapper.insertSelective(systemOrder1);
        }
        //调用微信支付
        String content= com.wmk.paydemo.test.WeixinPay.getCodeUrl(requestPay,payConfig,order_num);
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().write(content);
        response.getWriter().flush();
        response.getWriter().close();
        com.wmk.paydemo.test.WeixinPay.encodeQrcode(content,response);

    }

    @Override
    public void nativePay(WeChatParams ps, HttpServletResponse response) throws Exception {
        ps.setBody("测试商品3");   //商品描述
        ps.setTotalFee("1");       //总金额
        ps.setOutTradeNo("hw5409550792199879");  //商户内部订单号
        ps.setAttach("xiner");                   //附加数据
        ps.setMemberid("888");
        //生成图片
        //String content= com.wmk.paydemo.test.WeixinPay.getCodeUrl(ps);
        //com.wmk.paydemo.test.WeixinPay.encodeQrcode(content,response);
        //PrintWriter pw = null;
        //pw.println("");
    }
}
