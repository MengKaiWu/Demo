package com.wmk.paydemo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.wmk.paydemo.config.AlipayConfig.ALIPAY_PUBLIC_KEY;
import static com.wmk.paydemo.config.AlipayConfig.APPID;
import static com.wmk.paydemo.config.AlipayConfig.RSA_PRIVATE_KEY;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaydemoApplicationTests {

    @Test
    public void contextLoads() {
    }

}
