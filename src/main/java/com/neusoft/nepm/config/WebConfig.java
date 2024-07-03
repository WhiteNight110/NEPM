package com.neusoft.nepm.config;

import com.neusoft.nepm.interceptors.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**/**") // 拦截所有请求
                .excludePathPatterns("/admins/getAdminsByCode",
                        "/admins/adminsRegister",
                        "/captcha/getCaptcha",
                        "/captcha/checkCaptcha",
                        "/gridMember/gridMemberRegister",
                        "/gridMember/getGridMemberByCodeByPass",
                        "/nepm/mq/send",
                        "/mq/send"); // 排除不需要验证的路径
    }
}
