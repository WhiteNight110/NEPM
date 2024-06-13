package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.GridProvince;
import com.neusoft.nepm.mbg.model.GridProvinceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GridProvinceMapper {
    int countByExample(GridProvinceExample example);

    int deleteByExample(GridProvinceExample example);

    int deleteByPrimaryKey(Integer provinceId);

    int insert(GridProvince record);

    int insertSelective(GridProvince record);

    List<GridProvince> selectByExample(GridProvinceExample example);

    GridProvince selectByPrimaryKey(Integer provinceId);

    int updateByExampleSelective(@Param("record") GridProvince record, @Param("example") GridProvinceExample example);

    int updateByExample(@Param("record") GridProvince record, @Param("example") GridProvinceExample example);

    int updateByPrimaryKeySelective(GridProvince record);

    int updateByPrimaryKey(GridProvince record);
}