package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.common.utils.Md5Util;
import com.neusoft.nepm.mapper.AdminsMapper;
import com.neusoft.nepm.common.po.Admins;
import com.neusoft.nepm.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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


    /**
     * 用户登陆验证
     * @param admins
     * @return
     */
    @Override
    public String adminsLogin(Admins admins) {
        Admins admin = adminsMapper.selectOne(new QueryWrapper<Admins>().eq("admin_code", admins.getAdminCode()));
        if(admin == null){
            return "FAILED";
        }

        boolean result = admin.getPassword().equals(Md5Util.getMD5String(admins.getPassword()));
        if(result){
            // 生成令牌
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("userId", admin.getAdminId());
            String token = JwtUtil.generateToken(map);
            String codeKey = UUID.randomUUID().toString().replace("-", "");
            redisTemplate.opsForValue().set("user:login:token:" + codeKey , token , 30 , TimeUnit.MINUTES);
            return token;
        }
        return "FAILED";
    }

    /**
     * 用户注册
     * @param admins
     * @return
     */
    @Override
    public String adminRegister(Admins admins) {
        Admins admin = adminsMapper.selectOne(new QueryWrapper<Admins>().eq("admin_code", admins.getAdminCode()));
        if(admin == null){
            // MD5加密
            admins.setPassword(Md5Util.getMD5String(admins.getPassword()));
            adminsMapper.insert(admins);
            return "SUCCESS";
        }
        else {
            return "FAILED";
        }
    }

}
