package com.neusoft.nepm.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {
    private Integer width;
    private Integer height;
    private Session session; //使用自定义的Session类

    @Data
    public static class Session {
        private String key;
        private String date;
    }
}