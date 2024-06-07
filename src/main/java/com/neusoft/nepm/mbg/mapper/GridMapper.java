package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.Grid;
import com.neusoft.nepm.mbg.model.GridExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GridMapper {
    int countByExample(GridExample example);

    int deleteByExample(GridExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Grid record);

    int insertSelective(Grid record);

    List<Grid> selectByExample(GridExample example);

    Grid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Grid record, @Param("example") GridExample example);

    int updateByExample(@Param("record") Grid record, @Param("example") GridExample example);

    int updateByPrimaryKeySelective(Grid record);

    int updateByPrimaryKey(Grid record);
}