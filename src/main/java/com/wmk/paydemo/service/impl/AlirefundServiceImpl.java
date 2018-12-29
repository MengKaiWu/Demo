package com.wmk.paydemo.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.wmk.paydemo.dao.SystemOrderMapper;
import com.wmk.paydemo.dao.SystemRefundMapper;
import com.wmk.paydemo.entity.Refundmsg;
import com.wmk.paydemo.entity.SystemOrder;
import com.wmk.paydemo.entity.SystemPayConfig;
import com.wmk.paydemo.entity.SystemRefund;
import com.wmk.paydemo.service.AlirefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlirefundServiceImpl implements AlirefundService {
    @Autowired
    private SystemRefundMapper systemRefundMapper;
    @Autowired
    private SystemOrderMapper systemOrderMapper;
    @Override
    public String refundByPC(Refundmsg refundmsg, SystemPayConfig systemPayConfig, String orderId) {
        //根据订单ID查询退款信息
        SystemOrder systemOrder = systemOrderMapper.selectByPrimaryKey(orderId);
        if(systemOrder==null){
            return "订单号不存在！";
        }
        AlipayClient alipayClient = new DefaultAlipayClient(systemPayConfig.getMethod(), systemPayConfig.getAppId(), systemPayConfig.getRsaPrivateKey(), systemPayConfig.getFormat(), systemPayConfig.getCharset(), systemPayConfig.getAlipayPublicKey(), systemPayConfig.getSignType());
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":\"" + orderId + "\"," +    //需要退款的订单号,必填
                "    \"refund_amount\":\"" + systemOrder.getBuyerPayAmount() + "\"," +   //需要退款的金额，必填
                "    \"refund_reason\":\"正常退款\"," +          //退款的原因，可选
                "    \"out_request_no\":\"HZ01RF001\"," +        //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传。
                "    \"operator_id\":\"OP001\"," +               //商户的操作员编号,可选
                "    \"store_id\":\"NJ_S_001\"," +               //商户的门店编号,可选
                "    \"terminal_id\":\"NJ_T_001\"" +             //商户的终端编号,可选
                "  }");
        AlipayTradeRefundResponse response = null;
        try {
            response = alipayClient.execute(request);
            //实体接收退款结果
            SystemRefund systemRefund = new SystemRefund();
            systemRefund.setOutTradeNo(response.getOutTradeNo());
            systemRefund.setTradeNo(response.getTradeNo());
            systemRefund.setBuyerLogonId(response.getBuyerLogonId());
            systemRefund.setBuyerUserId(response.getBuyerUserId());
            systemRefund.setFundChange(response.getFundChange());
            systemRefund.setGmtRefundPay(response.getGmtRefundPay());
            systemRefund.setRefundFee(Double.valueOf(response.getRefundFee()));
            systemRefundMapper.insert(systemRefund);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if (response.isSuccess()) {
            return "Success";
        } else {
            return "Fail";
        }
    }
}
