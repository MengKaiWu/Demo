package com.wmk.paydemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wmk.paydemo.dao")
public class PaydemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaydemoApplication.class, args);
    }
}
