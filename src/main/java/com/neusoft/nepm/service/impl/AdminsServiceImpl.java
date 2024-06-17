package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.po.Admins;
import com.neusoft.nepm.mapper.AdminsMapper;
import com.neusoft.nepm.service.AdminsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

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
//            System.out.println("==============");
//            System.out.println(admin.getAdminId());
//            System.out.println("================");

            // 生成令牌
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("userId", admin.getAdminId());
            String token = JwtUtil.generateToken(map);

            return token;
//            return "SUCCESS";
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
    public int adminsInsert(Admins admins) {
        return adminsMapper.insert(admins);
    }
}
