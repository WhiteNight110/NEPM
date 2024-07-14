package com.neusoft.nepm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.common.dto.StatisticsPageRequestDto;
import com.neusoft.nepm.common.dto.StatisticsPageResponseDto;
import com.neusoft.nepm.common.po.Statistics;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 空气质量监测数据统计表 服务类
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public interface StatisticsService extends IService<Statistics> {

    /**
     * 分页查询 Statistics
     * @param statisticsPageRequestDto
     * @return CommonPage<Statistics>
     */
    CommonPage<StatisticsPageResponseDto> listStatistics(StatisticsPageRequestDto statisticsPageRequestDto);

    public List<Map<String, Object>> getStatisticsWithProvinceDetails();

    public List<Map<Integer, Integer>> getStatisticsDistribution();

    public List<Map<String, Integer>> getAqiLevelByMonth();
}
