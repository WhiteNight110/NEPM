package com.neusoft.nepm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement//异常
//@MapperScan("com.neusoft.nepm.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
})

//@SpringBootApplication
public class NepmApplication {
    public static void main(String[] args) {
        SpringApplication.run(NepmApplication.class, args);
    }

}
