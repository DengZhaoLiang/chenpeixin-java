package com.chenpeixin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@MapperScan(value = "com.chenpeixin.mapper")
@SpringBootApplication
public class ChenpeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChenpeixinApplication.class, args);
    }

}
