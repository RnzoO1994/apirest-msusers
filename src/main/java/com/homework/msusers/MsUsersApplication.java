package com.homework.msusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.homework.msusers")

public class MsUsersApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsUsersApplication.class, args);
    }
}
