package com.jk.examples.java;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class MyApplication {

    public static void main(String[] args) {
        log.info("Starting Spring Boot App...");
        SpringApplication.run(MyApplication.class, args);
        log.info("Successfully started Spring Boot App.");
    }

}
