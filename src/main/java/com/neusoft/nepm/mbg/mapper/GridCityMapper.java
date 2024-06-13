package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.GridCity;
import com.neusoft.nepm.mbg.model.GridCityExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GridCityMapper {
    int countByExample(GridCityExample example);

    int deleteByExample(GridCityExample example);

    int deleteByPrimaryKey(Integer cityId);

    int insert(GridCity record);

    int insertSelective(GridCity record);

    List<GridCity> selectByExample(GridCityExample example);

    GridCity selectByPrimaryKey(Integer cityId);

    int updateByExampleSelective(@Param("record") GridCity record, @Param("example") GridCityExample example);

    int updateByExample(@Param("record") GridCity record, @Param("example") GridCityExample example);

    int updateByPrimaryKeySelective(GridCity record);

    int updateByPrimaryKey(GridCity record);
}