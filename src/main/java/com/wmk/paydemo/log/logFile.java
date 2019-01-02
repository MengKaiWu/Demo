package com.wmk.paydemo.log;

import com.wmk.paydemo.config.AlipayConfig;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 日志类
 */
public class logFile {
    /*public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(AlipayConfig.log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}
