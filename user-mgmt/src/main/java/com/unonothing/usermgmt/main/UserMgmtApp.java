package com.unonothing.usermgmt.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EnableEurekaClient
//@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.unonothing"})
@EntityScan("com.unonothing.usermgmt.model")
@EnableJpaRepositories("com.unonothing.usermgmt.repository")
public class UserMgmtApp {
    public static void main(String[] args) {
        SpringApplication.run(UserMgmtApp.class, args);
    }
}

