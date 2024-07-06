package com.neusoft.nepm.service.impl;

import com.neusoft.nepm.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class SmsServiceImpl  implements SmsService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RabbitMessagingTemplate amqpTemplate;

    // 验证码前缀，这个是注册，的以后可能还会有订单
    static final String KEY_PREFIX = "user:code:phone:";

    static final Logger logger = LoggerFactory.getLogger(SmsService.class);



    public Boolean sendVerifyCode(String phone) {
        int codeLength = 6;
        StringBuilder bf = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < codeLength; i++) {
            bf.append(random.nextInt(10));
        }
        String code = bf.toString();


        try {
            HashMap<String, String> msg = new HashMap<>();
            msg.put("phone",phone);
            msg.put("code",code);
            this.amqpTemplate.convertAndSend("LEYOU.SMS.EXCHANGE","sms.verify.code",msg);
            // 将code存入redis 5分钟失效
            this.stringRedisTemplate.opsForValue().set(KEY_PREFIX+phone,code,5, TimeUnit.MINUTES);
            return true;
        } catch (AmqpException e) {
            logger.error("发送短信失败。phone:{}，code:{}",phone,code);
            return false;
        }
    }

}
