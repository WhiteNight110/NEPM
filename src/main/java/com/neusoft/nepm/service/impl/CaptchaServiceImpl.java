package com.neusoft.nepm.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.nepm.common.api.ValidateCodeVo;
import com.neusoft.nepm.mapper.AdminsMapper;
import com.neusoft.nepm.mapper.CaptchaMapper;
import com.neusoft.nepm.po.Admins;
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
        //定义图形验证码的长和宽(配置默认值)
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 48, 4, 20);

        String codeValue = lineCaptcha.getCode();
        String imageBase64 = lineCaptcha.getImageBase64();

        String codeKey = UUID.randomUUID().toString().replace("-", "");

        // 将验证码存储到Redis中
        redisTemplate.opsForValue().set("user:login:validatecode:" + codeKey , codeValue , 5 , TimeUnit.MINUTES);

        // 构建响应结果数据
        ValidateCodeVo validateCodeVo = new ValidateCodeVo() ;
        validateCodeVo.setCodeKey(codeKey);
        validateCodeVo.setCodeValue("data:image/png;base64," + imageBase64);
        // 返回数据
        return validateCodeVo;
    }

    @Override
    public boolean verifyValidateCode(String captcha, String codeKey) {
        //保证传过来的参数是合法的
        if (StringUtils.hasLength(captcha)) {

            String key = redisTemplate.opsForValue().get(codeKey);
//            System.out.println("==============");
//            System.out.println(key);

            assert key != null;

            if(key.equalsIgnoreCase(captcha)){
                // 登录成功，删除Redis中的验证码
                redisTemplate.delete(codeKey);
                return true;
            };
        }
        return false;
    }
}
