package com.jiaying;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jiaying.repository")
@SpringBootApplication
public class MenuApp {
    public static void main(String[] args) {
        SpringApplication.run(MenuApp.class);
    }
}
