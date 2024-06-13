package com.neusoft.nepm.service.impl;

import com.neusoft.nepm.mbg.mapper.AqiMapper;
import com.neusoft.nepm.mbg.model.Aqi;
import com.neusoft.nepm.service.AqiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AqiServiceImpl implements AqiService {

    @Autowired
    private AqiMapper aqiMapper;
    @Override
    public List<Aqi> selectByAll() {
        return aqiMapper.selectByAll();
    }
}
