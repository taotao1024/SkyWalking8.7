package com.taotao.application.mock.a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppLsyApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppLsyApplication.class, args);
    }
}
