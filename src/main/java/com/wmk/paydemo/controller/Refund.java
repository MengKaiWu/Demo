package com.wmk.paydemo.controller;

import com.wmk.paydemo.dao.SystemPayConfigMapper;
import com.wmk.paydemo.entity.Refundmsg;
import com.wmk.paydemo.entity.SystemPayConfig;
import com.wmk.paydemo.service.AlirefundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@Api(tags = {"退款接口"})
public class Refund {

    @Autowired
    private AlirefundService alirefundService;
    @Autowired
    private SystemPayConfigMapper systemPayConfigMapper;

    /**
     * @param reqType   退款类型，支付宝退款或微信退款
     * @param system_id 退款系统编号
     * @param order_id  退款的订单号
     */
    @GetMapping(value = "/torefund")
    @ApiOperation(value = "请求退款")
    public String unifyRefund(Refundmsg refundmsg,String reqType, String system_id, String order_id) {
        String result = null;
        SystemPayConfig systemPayConfig = systemPayConfigMapper.selectByPrimaryKey(system_id);
        if (systemPayConfig != null) {
            if (reqType.equals("AliRefund")) {
                result = alirefundService.refundByPC(refundmsg, systemPayConfig, order_id);
            } else if (reqType.equals("WxRefund")) {
            }
        } else {
            //处理异常
        }
        return result;
    }
}
