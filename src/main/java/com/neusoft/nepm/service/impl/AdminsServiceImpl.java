package com.neusoft.nepm.service.impl;

import com.neusoft.nepm.mbg.mapper.AdminsMapper;
import com.neusoft.nepm.mbg.model.Admins;
import com.neusoft.nepm.mbg.model.AdminsExample;
import com.neusoft.nepm.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminsServiceImpl implements AdminsService {

    @Autowired
    private AdminsMapper adminsMapper;

    @Override
    public String getAdminsByCode(Admins admins) {
        AdminsExample example = new AdminsExample();
        AdminsExample.Criteria criteria = example.createCriteria();
        criteria.andAdminCodeEqualTo(admins.getAdminCode());
        criteria.andPasswordEqualTo(admins.getPassword());
        criteria.andAdminCodeIsNotNull();
        List<Admins> adminsList = adminsMapper.selectByExample(example);
        if(adminsList.isEmpty()){
            return "FAILED";
        }
        return "SUCCESS";
    }
}
