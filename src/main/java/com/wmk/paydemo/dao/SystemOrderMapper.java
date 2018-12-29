package com.wmk.paydemo.dao;

import com.wmk.paydemo.entity.SystemOrder;
import com.wmk.paydemo.entity.SystemOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemOrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(SystemOrder record);

    int insertSelective(SystemOrder record);

    List<SystemOrder> selectByExample(SystemOrderExample example);

    SystemOrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(SystemOrder record);

    int updateByPrimaryKey(SystemOrder record);

    SystemOrder selectBySystemIdAndCashflowSn(@Param("systemid") String systemid,@Param("cashflowsn") String cashflowsn);
}