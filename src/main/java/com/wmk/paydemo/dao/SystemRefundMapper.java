package com.wmk.paydemo.dao;

import com.wmk.paydemo.entity.SystemRefund;
import com.wmk.paydemo.entity.SystemRefundExample;
import java.util.List;

public interface SystemRefundMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemRefund record);

    int insertSelective(SystemRefund record);

    List<SystemRefund> selectByExample(SystemRefundExample example);

    SystemRefund selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemRefund record);

    int updateByPrimaryKey(SystemRefund record);
}