package com.neusoft.nepm.service;

import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.dto.StatisticsPageRequestDto;
import com.neusoft.nepm.po.Statistics;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

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
    CommonPage<Statistics> listStatistics(StatisticsPageRequestDto statisticsPageRequestDto);
}
