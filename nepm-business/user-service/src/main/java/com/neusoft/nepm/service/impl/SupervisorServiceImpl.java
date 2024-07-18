package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.nepm.common.po.Supervisor;
import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.mapper.SupervisorMapper;
import com.neusoft.nepm.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 * 公众监督员表 服务实现类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@Service
public class SupervisorServiceImpl extends ServiceImpl<SupervisorMapper, Supervisor> implements SupervisorService {

    @Autowired
    private SupervisorMapper supervisorMapper;

    @Override
    public String supervisorLogin(Supervisor supervisor) {
        Supervisor supervisor1 = supervisorMapper.selectOne(new QueryWrapper<Supervisor>().eq("tel_id", supervisor.getTelId()));
        //.eq("password", supervisor.getPassword())
        if(supervisor1 == null){
            return "FAILED";
        }

        // 判断密码是否正确
        String encodedPassword = supervisor1.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 参数：(明文，密文)
        boolean result = passwordEncoder.matches(supervisor.getPassword(), encodedPassword);
        if(result){
            // 生成令牌
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("userId", supervisor1.getTelId());
            String token = JwtUtil.generateToken(map);

            return token;
        }
        return "FAILED";
    }

    @Override
    public String supervisorRegister(Supervisor supervisor) {
        Supervisor supervisor1 = supervisorMapper.selectOne(new QueryWrapper<Supervisor>().eq("tel_id", supervisor.getTelId()));
        if (supervisor1 == null){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(supervisor.getPassword());
            supervisor.setPassword(encodedPassword);
            supervisorMapper.insert(supervisor);
            return "SUCCESS";
        }
        else{

            return "FAILED";
        }

    }


}
