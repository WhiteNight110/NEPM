package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.Aqi;
import com.neusoft.nepm.mbg.model.AqiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AqiMapper {
    int countByExample(AqiExample example);

    int deleteByExample(AqiExample example);

    int deleteByPrimaryKey(Integer aqiId);

    int insert(Aqi record);

    int insertSelective(Aqi record);

    List<Aqi> selectByExample(AqiExample example);

    Aqi selectByPrimaryKey(Integer aqiId);

    int updateByExampleSelective(@Param("record") Aqi record, @Param("example") AqiExample example);

    int updateByExample(@Param("record") Aqi record, @Param("example") AqiExample example);

    int updateByPrimaryKeySelective(Aqi record);

    int updateByPrimaryKey(Aqi record);
}