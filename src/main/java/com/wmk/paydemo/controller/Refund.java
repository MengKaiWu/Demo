package com.wmk.paydemo.controller;

import com.wmk.paydemo.dao.SystemOrderMapper;
import com.wmk.paydemo.dao.SystemPayConfigMapper;
import com.wmk.paydemo.entity.Refundmsg;
import com.wmk.paydemo.entity.SystemOrder;
import com.wmk.paydemo.entity.SystemPayConfig;
import com.wmk.paydemo.service.AlirefundService;
import com.wmk.paydemo.service.WxrefudeService;
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
    private WxrefudeService wxrefudeService;
    @Autowired
    private SystemPayConfigMapper systemPayConfigMapper;
    @Autowired
    private SystemOrderMapper systemOrderMapper;

    /**
     * @param order_id  退款的订单号
     */
    @GetMapping(value = "/torefund")
    @ApiOperation(value = "请求退款")
    public String unifyRefund(String order_id) {
        String result = null;
        //从数据库查询该笔订单的信息
        SystemOrder systemOrder = systemOrderMapper.selectByPrimaryKey(order_id);
        if(systemOrder==null){
            return "未查到该笔订单，请检查参数";
        }
        SystemPayConfig systemPayConfig = systemPayConfigMapper.selectByPrimaryKey(systemOrder.getSystemId());
        if (systemPayConfig != null) {
            if (systemOrder.getSystemId().equals("1")) {
                result = alirefundService.refundByPC(systemPayConfig, order_id);
            } else if (systemOrder.getSystemId().equals("2")) {
                result = wxrefudeService.refundByPC(systemPayConfig, order_id);
            }
        } else {
            return "参数异常,请检查后重试";
        }
        return result;
    }
}
