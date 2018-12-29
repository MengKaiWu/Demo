package com.wmk.paydemo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 用于生成系统唯一的订单号
 */
public class BuilderOrderNum {
    public static String crete() {
        //生成当前系统时间戳
        Date date = new Date();
        String res = String.valueOf((long) date.getTime());
        //生成UUID
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return res + uuid;
    }
}
