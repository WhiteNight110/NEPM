package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.Aqi;
import com.neusoft.nepm.mbg.model.AqiExample;
import java.util.List;

import org.apache.ibatis.annotations.*;

@Mapper
public interface AqiMapper {
    int countByExample(AqiExample example);

    int deleteByExample(AqiExample example);

    int deleteByPrimaryKey(Integer aqiId);

    int insert(Aqi record);

    int insertSelective(Aqi record);

    /**
     * 查询所有AQI数据
     * @return List<Aqi>
     */
//    @Select("SELECT * FROM aqi")
//    @Results({
//            @Result(column = "aqi_id", property = "aqiId"),
//            @Result(column = "chinese_explain", property = "chineseExplain"),
//            @Result(column = "aqi_explain", property = "aqiExplain"),
//            @Result(column = "color", property = "color"),
//            @Result(column = "health_impact", property = "healthImpact"),
//            @Result(column = "take_steps", property = "takeSteps"),
//            @Result(column = "so2_min", property = "so2Min"),
//            @Result(column = "so2_max", property = "so2Max"),
//            @Result(column = "co_min", property = "coMin"),
//            @Result(column = "co_max", property = "coMax"),
//            @Result(column = "spm_min", property = "spmMin"),
//            @Result(column = "spm_max", property = "spmMax"),
//            @Result(column = "remarks", property = "remarks"),
//    })
    List<Aqi> selectByAll();

    List<Aqi> selectByExample(AqiExample example);

    Aqi selectByPrimaryKey(Integer aqiId);

    int updateByExampleSelective(@Param("record") Aqi record, @Param("example") AqiExample example);

    int updateByExample(@Param("record") Aqi record, @Param("example") AqiExample example);

    int updateByPrimaryKeySelective(Aqi record);

    int updateByPrimaryKey(Aqi record);
}