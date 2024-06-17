package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.nepm.po.Supervisor;
import com.neusoft.nepm.mapper.SupervisorMapper;
import com.neusoft.nepm.service.SupervisorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Supervisor supervisor1 = supervisorMapper.selectOne(new QueryWrapper<Supervisor>().eq("tel_id", supervisor.getTelId()).eq("password", supervisor.getPassword()));

        if(supervisor1 == null){
            return "FAILED";
        }
        return "SUCCESS";
    }
}
