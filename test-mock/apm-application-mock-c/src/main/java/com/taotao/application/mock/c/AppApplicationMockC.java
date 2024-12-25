package com.taotao.application.mock.c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppApplicationMockC {
    public static void main(String[] args) {
        SpringApplication.run(AppApplicationMockC.class, args);
    }
}
