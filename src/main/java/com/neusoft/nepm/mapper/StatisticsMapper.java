package com.neusoft.nepm.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.neusoft.nepm.po.Statistics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 空气质量监测数据统计表 Mapper 接口
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public interface StatisticsMapper extends MPJBaseMapper<Statistics> {
    @Select("SELECT s.province_id, gp.province_name, gp.province_abbr, " +
            "SUM(CASE WHEN s.so2_level > 2 THEN 1 ELSE 0 END) AS so2Times, " +
            "SUM(CASE WHEN s.co_level > 2 THEN 1 ELSE 0 END) AS coTimes, " +
            "SUM(CASE WHEN s.spm_level > 2 THEN 1 ELSE 0 END) AS spmTimes " +
            "FROM statistics s " +
            "LEFT JOIN grid_province gp ON s.province_id = gp.province_id " +
            "GROUP BY s.province_id, gp.province_name " +
            "ORDER BY gp.province_id ASC")
    List<Map<String, Object>> getStatisticsWithProvinceDetails();
}
