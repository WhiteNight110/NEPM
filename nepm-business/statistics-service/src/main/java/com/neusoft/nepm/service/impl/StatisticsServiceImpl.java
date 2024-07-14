package com.neusoft.nepm.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.dto.StatisticsPageRequestDto;
import com.neusoft.nepm.common.dto.StatisticsPageResponseDto;
import com.neusoft.nepm.mapper.StatisticsMapper;
import com.neusoft.nepm.common.po.*;
import com.neusoft.nepm.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
            mpjLambdaWrapper.eq(Statistics::getProvinceId, staPageRequestDto.getProvinceId());
        }
        if (staPageRequestDto.getCityId() != null) {
            mpjLambdaWrapper.eq(Statistics::getCityId, staPageRequestDto.getCityId());
        }
        if (staPageRequestDto.getAddress() != null && staPageRequestDto.getAddress() != "") {
            mpjLambdaWrapper.like("address", staPageRequestDto.getAddress());
        }

        if(staPageRequestDto.getAqiLevel() != null) {
            mpjLambdaWrapper.eq(Statistics::getAqiLevel, staPageRequestDto.getAqiLevel());
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

    public List<Map<Integer, Integer>> getStatisticsDistribution() {
        MPJLambdaWrapper<Statistics> mpjLambdaWrapper = new MPJLambdaWrapper<Statistics>()
                .select(Statistics::getAqiLevel)
                .select("COUNT(*) AS count") // 使用别名 count // 统计每个分组的数量
                .groupBy(Statistics::getAqiLevel);

        // 执行查询并获取结果
        List<Map<String, Object>> results = statisticsMapper.selectMaps(mpjLambdaWrapper);

//        System.out.println("========");
//        System.out.println(results);

        // 转换结果格式
        List<Map<Integer, Integer>> distribution = new ArrayList<>();
        for (Map<String, Object> result : results) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put((Integer) result.get("aqi_level"), ((Long) result.get("count")).intValue());
            distribution.add(map);
        }

        return distribution;
    }

    public List<Map<String, Integer>> getAqiLevelByMonth(){
        MPJLambdaWrapper<Statistics> mpjLambdaWrapper = new MPJLambdaWrapper<Statistics>()
                .select("DATE_FORMAT(confirm_date, '%Y-%m') AS month")
                .select("COUNT(*) AS count") // 使用别名 count
                .groupBy("month")
                .ge(Statistics::getAqiLevel, 2)
                .ge(Statistics::getConfirmDate, LocalDate.now().minusMonths(12));

        // 执行查询并获取结果
        List<Map<String, Object>> results = statisticsMapper.selectMaps(mpjLambdaWrapper);

        // System.out.println("========");
        // System.out.println(results);

        // 转换结果格式
        Map<String, Integer> resultMap = new HashMap<>();
        for (Map<String, Object> result : results) {
            resultMap.put((String) result.get("month"), ((Long) result.get("count")).intValue());
        }

        // 补全近12个月的月份
        List<Map<String, Integer>> monthlyCounts = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (int i = 0; i < 12; i++) {
            LocalDate monthDate = now.minusMonths(i);
            String month = monthDate.format(DateTimeFormatter.ofPattern("yyyy-MM"));
            Map<String, Integer> map = new HashMap<>();
            map.put(month, resultMap.getOrDefault(month, 0));
            monthlyCounts.add(map);
        }

        return monthlyCounts;
    }
}
