package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.nepm.common.po.GridMember;
import com.neusoft.nepm.common.utils.JwtUtil;
import com.neusoft.nepm.mapper.GridMemberMapper;
import com.neusoft.nepm.service.GridMemberService;
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
        // 根据gm_code查询网格成员
        GridMember gridMember1 = gridMemberMapper.selectOne(new QueryWrapper<GridMember>().eq("gm_code", gridMember.getGmCode()));

        // 如果查询结果为空，返回"FAILED"
        if (gridMember1 == null) {
            return "FAILED";
        }

        // 判断密码是否正确
        String encodedPassword = gridMember1.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 参数：(明文，密文)
        boolean result = passwordEncoder.matches(gridMember.getPassword(), encodedPassword);

        // 如果密码匹配，生成令牌并返回
        if (result) {
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("userId", gridMember1.getGmCode());
            String token = JwtUtil.generateToken(map);
            return token;
        }

        // 密码不匹配，返回"FAILED"
        return "FAILED";
    }

    @Override
    public Integer getGridMemberId(GridMember gridMember) {
        // 根据gm_code查询网格成员，并返回其ID
        GridMember gridMember1 = gridMemberMapper.selectOne(new QueryWrapper<GridMember>().eq("gm_code", gridMember.getGmCode()));
        return gridMember1.getGmId();
    }

    @Override
    public String gmRegister(GridMember gridMember) {
        // 根据gm_code查询是否已存在该网格成员
        GridMember gm = gridMemberMapper.selectOne(new QueryWrapper<GridMember>().eq("gm_code", gridMember.getGmCode()));

        // 如果不存在，进行注册
        if (gm == null) {
            // 密码加密
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(gridMember.getPassword());
            gridMember.setPassword(encodedPassword);

            // 插入新的网格成员
            gridMemberMapper.insert(gridMember);
            return "SUCCESS";
        } else {
            // 如果已存在，返回"FAILED"
            return "FAILED";
        }
    }


}
