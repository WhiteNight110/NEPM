package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.nepm.common.po.Aqi;
import com.neusoft.nepm.mapper.AqiMapper;
import com.neusoft.nepm.service.AqiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 空气质量指数级别表 服务实现类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@Service
public class AqiServiceImpl extends ServiceImpl<AqiMapper, Aqi> implements AqiService {

    @Autowired
    private AqiMapper aqiMapper;

    @Override
    public List<Aqi> AqiByAll() {
        List<Aqi> aqiList = aqiMapper.selectList(null);
        return aqiList;
    }
}
