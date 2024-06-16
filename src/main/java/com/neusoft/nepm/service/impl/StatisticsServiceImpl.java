package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.dto.StatisticsPageRequestDto;
import com.neusoft.nepm.po.Statistics;
import com.neusoft.nepm.mapper.StatisticsMapper;
import com.neusoft.nepm.service.StatisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 空气质量监测数据统计表 服务实现类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@Service
public class StatisticsServiceImpl extends ServiceImpl<StatisticsMapper, Statistics> implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;

    @Override
    public CommonPage<Statistics> listStatistics(StatisticsPageRequestDto staPageRequestDto) {
//        QueryWrapper<Statistics> qw = new QueryWrapper<>();
//        if(staPageRequestDto.getAqiLevel() != 0){
//            qw.eq("aqi_level", staPageRequestDto.getAqiLevel());
//        }
//        if(staPageRequestDto.getProvince_id() != 0){
//            qw.eq("province_id", staPageRequestDto.getProvince_id());
//        }
//        if(staPageRequestDto.getSo2Level() != 0){
//            qw.eq("so2_level", staPageRequestDto.getSo2Level());
//        }
//        if(staPageRequestDto.getCoLevel() != 0){
//            qw.eq("co_level", staPageRequestDto.getCoLevel());
//        }
//        if(staPageRequestDto.getSpmLevel() != 0){
//            qw.eq("spm_level", staPageRequestDto.getSpmLevel());
//        }
//        if(staPageRequestDto.getAddress() != "" && staPageRequestDto.getAddress() != null){
//            qw.like("address", staPageRequestDto.getAddress());
//        }
//
//        Page<Statistics> statisticsPage = new Page<>(staPageRequestDto.getPage(), staPageRequestDto.getSize());
//        Page<Statistics> res = statisticsMapper.selectPage(statisticsPage, qw);
//
//        return CommonPage.restPage(res);
        return null;
    }
}
