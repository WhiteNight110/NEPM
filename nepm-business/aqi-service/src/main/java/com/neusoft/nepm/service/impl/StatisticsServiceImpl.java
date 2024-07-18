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
        // 创建MPJLambdaWrapper对象，用于构建查询条件
        MPJLambdaWrapper<Statistics> mpjLambdaWrapper = new MPJLambdaWrapper<Statistics>()
                // 选择Statistics类的所有字段
                .selectAll(Statistics.class)
                // 选择关联的Supervisor类的字段，并映射到StatisticsPageResponseDto的getSupervisor方法
                .selectAssociation(Supervisor.class, StatisticsPageResponseDto::getSupervisor)
                // 选择关联的Aqi类的字段，并映射到StatisticsPageResponseDto的getAqi方法
                .selectAssociation(Aqi.class, StatisticsPageResponseDto::getAqi)
                // 选择关联的GridMember类的字段，并映射到StatisticsPageResponseDto的getGridMember方法
                .selectAssociation(GridMember.class, StatisticsPageResponseDto::getGridMember)
                // 左连接Supervisor类，关联条件为Supervisor的telId字段和Statistics的fdId字段
                .leftJoin(Supervisor.class, Supervisor::getTelId, Statistics::getFdId)
                // 左连接Aqi类，关联条件为Aqi的aqiLevel字段和Statistics的aqiLevel字段
                .leftJoin(Aqi.class, Aqi::getAqiLevel, Statistics::getAqiLevel)
                // 左连接GridMember类，关联条件为GridMember的gmId字段和Statistics的gmId字段
                .leftJoin(GridMember.class, GridMember::getGmId, Statistics::getGmId);

        // 如果请求参数中包含省份ID，则添加相应的查询条件
        if (staPageRequestDto.getProvinceId() != null) {
            mpjLambdaWrapper.eq(Statistics::getProvinceId, staPageRequestDto.getProvinceId());
        }
        // 如果请求参数中包含城市ID，则添加相应的查询条件
        if (staPageRequestDto.getCityId() != null) {
            mpjLambdaWrapper.eq(Statistics::getCityId, staPageRequestDto.getCityId());
        }
        // 如果请求参数中包含地址且地址不为空，则添加模糊查询条件
        if (staPageRequestDto.getAddress() != null && !staPageRequestDto.getAddress().isEmpty()) {
            mpjLambdaWrapper.like("address", staPageRequestDto.getAddress());
        }

        // 如果请求参数中包含AQI等级，则添加相应的查询条件
        if(staPageRequestDto.getAqiLevel() != null) {
            mpjLambdaWrapper.eq(Statistics::getAqiLevel, staPageRequestDto.getAqiLevel());
        }

        // 如果请求参数中包含确认日期，则添加相应的查询条件
        if(staPageRequestDto.getConfirmDate() != null){
            mpjLambdaWrapper.eq(Statistics::getConfirmDate, staPageRequestDto.getConfirmDate());
        }

        // 执行分页查询，获取结果
        Page<StatisticsPageResponseDto> page = statisticsMapper.selectJoinPage(
                new Page<>(staPageRequestDto.getPage(), staPageRequestDto.getSize()),
                StatisticsPageResponseDto.class,
                mpjLambdaWrapper
        );

        // 返回分页查询结果
        return CommonPage.restPage(page);
    }




    public List<Map<String, Object>> getStatisticsWithProvinceDetails() {
        return statisticsMapper.getStatisticsWithProvinceDetails();
    }

    @Override
    public List<Map<Integer, Integer>> getSo2Distribution() {
        MPJLambdaWrapper<Statistics> mpjLambdaWrapper = new MPJLambdaWrapper<Statistics>()
                .select(Statistics::getSo2Level)
                .select("COUNT(*) AS count") // 使用别名 count // 统计每个分组的数量
                .groupBy(Statistics::getSo2Level);

        // 执行查询并获取结果
        List<Map<String, Object>> results = statisticsMapper.selectMaps(mpjLambdaWrapper);

        // 转换结果格式
        List<Map<Integer, Integer>> distribution = new ArrayList<>();
        for (Map<String, Object> result : results) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put((Integer) result.get("so2_level"), ((Long) result.get("count")).intValue());
            distribution.add(map);
        }

        return distribution;
    }

    @Override
    public List<Map<Integer, Integer>> getCoDistribution() {
        MPJLambdaWrapper<Statistics> mpjLambdaWrapper = new MPJLambdaWrapper<Statistics>()
                .select(Statistics::getCoLevel)
                .select("COUNT(*) AS count") // 使用别名 count // 统计每个分组的数量
                .groupBy(Statistics::getCoLevel);

        // 执行查询并获取结果
        List<Map<String, Object>> results = statisticsMapper.selectMaps(mpjLambdaWrapper);

        // 转换结果格式
        List<Map<Integer, Integer>> distribution = new ArrayList<>();
        for (Map<String, Object> result : results) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put((Integer) result.get("co_level"), ((Long) result.get("count")).intValue());
            distribution.add(map);
        }

        return distribution;
    }

    @Override
    public List<Map<Integer, Integer>> getSpmDistribution() {
        MPJLambdaWrapper<Statistics> mpjLambdaWrapper = new MPJLambdaWrapper<Statistics>()
                .select(Statistics::getSpmLevel)
                .select("COUNT(*) AS count") // 使用别名 count // 统计每个分组的数量
                .groupBy(Statistics::getSpmLevel);

        // 执行查询并获取结果
        List<Map<String, Object>> results = statisticsMapper.selectMaps(mpjLambdaWrapper);

        // 转换结果格式
        List<Map<Integer, Integer>> distribution = new ArrayList<>();
        for (Map<String, Object> result : results) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put((Integer) result.get("spm_level"), ((Long) result.get("count")).intValue());
            distribution.add(map);
        }

        return distribution;
    }

    @Override
    public List<Map<Integer, Integer>> getAqiDistribution() {
        MPJLambdaWrapper<Statistics> mpjLambdaWrapper = new MPJLambdaWrapper<Statistics>()
                .select(Statistics::getAqiLevel)
                .select("COUNT(*) AS count") // 使用别名 count // 统计每个分组的数量
                .groupBy(Statistics::getAqiLevel);

        // 执行查询并获取结果
        List<Map<String, Object>> results = statisticsMapper.selectMaps(mpjLambdaWrapper);
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
