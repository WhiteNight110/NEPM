package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.po.Admins;
import com.neusoft.nepm.po.GridMember;
import com.neusoft.nepm.mapper.GridMemberMapper;
import com.neusoft.nepm.service.GridMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        GridMember gridMember1 = gridMemberMapper.selectOne(new QueryWrapper<GridMember>().eq("gm_code", gridMember.getGmCode()).eq("password", gridMember.getPassword()));

        if(gridMember1 == null){
            return "FAILED";
        }
        return "SUCCESS";
    }
}
