package com.wmk.paydemo.dao;

import com.wmk.paydemo.entity.SystemPayConfig;
import com.wmk.paydemo.entity.SystemPayConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemPayConfigMapper {
    int deleteByPrimaryKey(String systemId);

    int insert(SystemPayConfig record);

    int insertSelective(SystemPayConfig record);

    List<SystemPayConfig> selectByExample(SystemPayConfigExample example);

    SystemPayConfig selectByPrimaryKey(String systemId);

    int updateByPrimaryKeySelective(SystemPayConfig record);

    int updateByPrimaryKey(SystemPayConfig record);

    //根据APPID查找指定的配置信息
    SystemPayConfig selectByAppId(@Param("appid") String appid);
}