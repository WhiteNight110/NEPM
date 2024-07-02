package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.po.Admins;
import com.neusoft.nepm.po.GridMember;
import com.neusoft.nepm.mapper.GridMemberMapper;
import com.neusoft.nepm.service.GridMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 * 空气质量监测网格员表 服务实现类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@Service
public class GridMemberServiceImpl extends ServiceImpl<GridMemberMapper, GridMember> implements GridMemberService {

    @Autowired
    private GridMemberMapper gridMemberMapper;

    @Override
    public String gridMemberLogin(GridMember gridMember) {
        GridMember gridMember1 = gridMemberMapper.selectOne(new QueryWrapper<GridMember>().eq("gm_code", gridMember.getGmCode()));

        if(gridMember1 == null){
            return "FAILED";
        }

        // 判断密码是否正确
        String encodedPassword = gridMember1.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 参数：(明文，密文)
        boolean result = passwordEncoder.matches(gridMember.getPassword(), encodedPassword);
        if(result){
            // 生成令牌
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("userId", gridMember1.getGmCode());
            String token = JwtUtil.generateToken(map);

            return token;
        }
        return "FAILED";
    }

    @Override
    public Integer getGridMemberId(GridMember gridMember) {
        GridMember gridMember1 = gridMemberMapper.selectOne(new QueryWrapper<GridMember>().eq("gm_code", gridMember.getGmCode()));

        return gridMember1.getGmId();
    }

    @Override
    public String gmRegister(GridMember gridMember) {
        GridMember gm = gridMemberMapper.selectOne(new QueryWrapper<GridMember>().eq("gm_code", gridMember.getGmCode()));
        if(gm == null){
            // 密码加密
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(gridMember.getPassword());
            gridMember.setPassword(encodedPassword);

            gridMemberMapper.insert(gridMember);
            return "SUCCESS";
        }
        else {
            return "FAILED";
        }
    }


}
