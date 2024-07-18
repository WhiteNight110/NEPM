package com.nepm.neusoft.nepm.mq.service.impl;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.nepm.neusoft.nepm.mq.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class SmsServiceImpl  implements SmsService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RabbitMessagingTemplate amqpTemplate;

    @Autowired
    private RedisTemplate<String , String> redisTemplate;

    // 验证码前缀
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
            this.stringRedisTemplate.opsForValue().set(KEY_PREFIX+phone,code,1000, TimeUnit.MINUTES);
            return true;
        } catch (AmqpException e) {
            logger.error("发送短信失败。phone:{}，code:{}",phone,code);
            return false;
        }
    }

    @Override
    public Boolean verifySms(String phone, String code) {
        String codeKey = "user:code:phone:" + phone;
        //保证传过来的参数是合法的
        if (StringUtils.hasLength(code)) {
            String key = redisTemplate.opsForValue().get(codeKey);
            assert key != null;
            if(key.equalsIgnoreCase(code)){
                //登录成功，删除Redis中的验证码
                redisTemplate.delete(codeKey);
                return true;
            };
        }
        return false;
    }
}
