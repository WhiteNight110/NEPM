package com.neusoft.nepm.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.api.ValidateCodeVo;
import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.po.Admins;
import com.neusoft.nepm.mapper.AdminsMapper;
import com.neusoft.nepm.service.AdminsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 系统管理员表 服务实现类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@Service
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements AdminsService {

    @Autowired
    private AdminsMapper adminsMapper;

    @Autowired
    private RedisTemplate<String , String> redisTemplate;


    @Override
    public String adminsLogin(Admins admins) {

        Admins admin = adminsMapper.selectOne(new QueryWrapper<Admins>().eq("admin_code", admins.getAdminCode()));

//        System.out.println("===============================");

        if(admin == null){
            return "FAILED";
        }

        // 判断密码是否正确
        String encodedPassword = admin.getPassword();
//        System.out.println(encodedPassword);
//        System.out.println("===============================");
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 参数：(明文，密文)
        boolean result = passwordEncoder.matches(admins.getPassword(), encodedPassword);
        if(result){
            // 生成令牌
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("userId", admin.getAdminId());
            String token = JwtUtil.generateToken(map);

            return token;
        }
        return "FAILED";

    }

    @Override
    public String adminRegister(Admins admins) {
        Admins admin = adminsMapper.selectOne(new QueryWrapper<Admins>().eq("admin_code", admins.getAdminCode()));
        if(admin == null){
            // 密码加密
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(admins.getPassword());
            admins.setPassword(encodedPassword);

            adminsMapper.insert(admins);
            return "SUCCESS";
        }
        else {
            return "FAILED";
        }
    }

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

            String key = redisTemplate.opsForValue().get(codeKey).toString();
            System.out.println("==============");
            System.out.println(key);

            if(key.equalsIgnoreCase(captcha)){
                // 登录成功，删除Redis中的验证码
                redisTemplate.delete(codeKey);
                return true;
            };
        }
        return false;
    }

    @Override
    public int adminsInsert(Admins admins) {
        return adminsMapper.insert(admins);
    }
}
