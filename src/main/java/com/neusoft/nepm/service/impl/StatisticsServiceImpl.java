package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.dto.AfPageRequestDto;
import com.neusoft.nepm.dto.AfPageResponseDto;
import com.neusoft.nepm.dto.StatisticsPageRequestDto;
import com.neusoft.nepm.dto.StatisticsPageResponseDto;
import com.neusoft.nepm.po.*;
import com.neusoft.nepm.mapper.StatisticsMapper;
import com.neusoft.nepm.service.StatisticsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public CommonPage<StatisticsPageResponseDto> listStatistics(StatisticsPageRequestDto staPageRequestDto) {
        MPJLambdaWrapper<Statistics> mpjLambdaWrapper = new MPJLambdaWrapper<Statistics>()
                .selectAll(Statistics.class)
                .selectAssociation(Supervisor.class, StatisticsPageResponseDto::getSupervisor)
                .selectAssociation(Aqi.class, StatisticsPageResponseDto::getAqi)
                .selectAssociation(GridMember.class, StatisticsPageResponseDto::getGridMember)
                .leftJoin(Supervisor.class, Supervisor::getTelId, Statistics::getFdId)
                .leftJoin(Aqi.class, Aqi::getAqiLevel, Statistics::getAqiLevel)
                .leftJoin(GridMember.class, GridMember::getGmId, Statistics::getGmId);
        if (staPageRequestDto.getProvinceId() != null) {
            mpjLambdaWrapper.eq("province_id", staPageRequestDto.getProvinceId());
        }
        if (staPageRequestDto.getCityId() != null) {
            mpjLambdaWrapper.eq("city_id", staPageRequestDto.getCityId());
        }
        if (staPageRequestDto.getAddress() != null && staPageRequestDto.getAddress() != "") {
            mpjLambdaWrapper.like("address", staPageRequestDto.getAddress());
        }

        if(staPageRequestDto.getAqiLevel() != null) {
            mpjLambdaWrapper.eq("aqi_level", staPageRequestDto.getAqiLevel());
        }

        if(staPageRequestDto.getConfirmDate() != null){
            mpjLambdaWrapper.eq(Statistics::getConfirmDate, staPageRequestDto.getConfirmDate());
        }

        Page<StatisticsPageResponseDto> page = statisticsMapper.selectJoinPage(new Page<>(staPageRequestDto.getPage(), staPageRequestDto.getSize()), StatisticsPageResponseDto.class, mpjLambdaWrapper);

        return CommonPage.restPage(page);
    }



    public List<Map<String, Object>> getStatisticsWithProvinceDetails() {
        return statisticsMapper.getStatisticsWithProvinceDetails();
    }
}
