package com.neusoft.nepm.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.nepm.common.api.ValidateCodeVo;
import com.neusoft.nepm.mapper.CaptchaMapper;
import com.neusoft.nepm.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class CaptchaServiceImpl extends ServiceImpl<CaptchaMapper, ValidateCodeVo> implements CaptchaService {

    @Autowired
    private CaptchaMapper captchaMapper;

    @Autowired
    private RedisTemplate<String , String> redisTemplate;

    @Override
    public ValidateCodeVo generateValidateCode() {
        // 定义图形验证码的长和宽，并设置默认值
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 48, 4, 20);

        // 获取验证码的值和Base64编码的图像
        String codeValue = lineCaptcha.getCode();
        String imageBase64 = lineCaptcha.getImageBase64();
        // 生成唯一的验证码键
        String codeKey = UUID.randomUUID().toString().replace("-", "");

        // 将验证码存储到Redis中，键格式为"user:login:validatecode:{codeKey}"，过期时间为5分钟
        redisTemplate.opsForValue().set("user:login:validatecode:" + codeKey , codeValue , 5 , TimeUnit.MINUTES);

        // 构建响应结果数据
        ValidateCodeVo validateCodeVo = new ValidateCodeVo();
        validateCodeVo.setCodeKey(codeKey); // 设置验证码键
        validateCodeVo.setCodeValue("data:image/png;base64," + imageBase64); // 设置Base64编码的图像
        // 返回数据
        return validateCodeVo;
    }

    @Override
    public Boolean verifyValidateCode(String captcha, String codeKey) {
        // 确保传递的参数是合法的（非空）
        if (StringUtils.hasLength(captcha)) {
            // 从Redis中获取存储的验证码值
            String key = redisTemplate.opsForValue().get(codeKey);
            assert key != null; // 确保key不为空

            // 比较传递的验证码和Redis中存储的验证码（忽略大小写）
            if(key.equalsIgnoreCase(captcha)){
                // 验证成功，删除Redis中的验证码
                redisTemplate.delete(codeKey);
                return true;
            }
        }
        // 验证失败
        return false;
    }

}
