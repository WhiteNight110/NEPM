package com.neusoft.nepm.service;

import com.neusoft.nepm.mbg.model.Aqi;

import java.util.List;

public interface AqiService {
    /**
     * 查询所有AQI数据
     * @return
     */
    public List<Aqi> selectByAll();
}
