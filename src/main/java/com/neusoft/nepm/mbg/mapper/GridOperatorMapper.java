package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.GridOperator;
import com.neusoft.nepm.mbg.model.GridOperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GridOperatorMapper {
    int countByExample(GridOperatorExample example);

    int deleteByExample(GridOperatorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GridOperator record);

    int insertSelective(GridOperator record);

    List<GridOperator> selectByExample(GridOperatorExample example);

    GridOperator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GridOperator record, @Param("example") GridOperatorExample example);

    int updateByExample(@Param("record") GridOperator record, @Param("example") GridOperatorExample example);

    int updateByPrimaryKeySelective(GridOperator record);

    int updateByPrimaryKey(GridOperator record);
}