package com.taotao.application.mock.b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppApplicationMockB {
    public static void main(String[] args) {
        SpringApplication.run(AppApplicationMockB.class, args);
    }
}
