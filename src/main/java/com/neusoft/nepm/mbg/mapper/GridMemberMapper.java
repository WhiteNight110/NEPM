package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.GridMember;
import com.neusoft.nepm.mbg.model.GridMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GridMemberMapper {
    int countByExample(GridMemberExample example);

    int deleteByExample(GridMemberExample example);

    int deleteByPrimaryKey(Integer gmId);

    int insert(GridMember record);

    int insertSelective(GridMember record);

    List<GridMember> selectByExample(GridMemberExample example);

    GridMember selectByPrimaryKey(Integer gmId);

    int updateByExampleSelective(@Param("record") GridMember record, @Param("example") GridMemberExample example);

    int updateByExample(@Param("record") GridMember record, @Param("example") GridMemberExample example);

    int updateByPrimaryKeySelective(GridMember record);

    int updateByPrimaryKey(GridMember record);
}