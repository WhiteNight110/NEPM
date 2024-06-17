package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.po.Admins;
import com.neusoft.nepm.mapper.AdminsMapper;
import com.neusoft.nepm.service.AdminsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Admins admin = adminsMapper.selectOne(new QueryWrapper<Admins>().eq("admin_code", admins.getAdminCode()).eq("password", admins.getPassword()));

        if(admin == null){
            return "FAILED";
        }
        return "SUCCESS";

    }

    @Override
    public String adminRegister(Admins admins) {
        Admins admin = adminsMapper.selectOne(new QueryWrapper<Admins>().eq("admin_code", admins.getAdminCode()));
        if(admin != null){
            adminsMapper.insert(admins);
            return "SUCCESS";
        }
        else return "FAILED";
    }

    @Override
    public int adminsInsert(Admins admins) {
        return adminsMapper.insert(admins);
    }
}
