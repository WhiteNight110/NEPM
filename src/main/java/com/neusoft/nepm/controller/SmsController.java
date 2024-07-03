package com.neusoft.nepm.controller;

import com.neusoft.nepm.common.api.CommonResult;
import com.neusoft.nepm.service.SendMessageService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Controller
@Api(tags = "SmsController", description = "短信验证码")
@RequestMapping("/sms")
public class SmsController {


    @Autowired
    private SendMessageService sendMessageService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/send")
    @ResponseBody
    public CommonResult<String> Send(@RequestParam String phone) {
        //调用方法（真实业务）
        String code = redisTemplate.opsForValue().get("user:sms:" + phone);//获取取得的手机号
        //如果code不为空则说明将code放入了缓存，而且没有过期
        if (!StringUtils.isEmpty(code)) {
            return CommonResult.successWithString(phone + ":" + code + "未过期");
        }
        //生成4个字的验证码存储在redis中
        code = RandomStringUtils.random(5, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'});

        //String code=random.next(10000);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);

        //测试时不发短信
//        boolean sms = sendMessageService.send(phone, "SMS_468645353", map);
        boolean sms = true;
        if (sms) {
//            System.out.println("=======sms=========");
//            System.out.println(code);
            redisTemplate.opsForValue().set("user:sms:" + phone, code, 1, TimeUnit.MINUTES);
            return CommonResult.successWithString(phone + ":" + code + ":发送成功");
        } else
            return CommonResult.successWithString(phone + ":" + code + ":发送失败");
    }


}
