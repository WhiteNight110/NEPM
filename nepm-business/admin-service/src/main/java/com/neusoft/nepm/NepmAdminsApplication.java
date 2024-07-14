package com.neusoft.nepm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.neusoft.nepm.feign")
public class NepmAdminsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NepmAdminsApplication.class, args);
    }

}
