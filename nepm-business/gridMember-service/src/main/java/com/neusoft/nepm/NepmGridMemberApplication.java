package com.neusoft.nepm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NepmGridMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(NepmGridMemberApplication.class, args);
    }

}