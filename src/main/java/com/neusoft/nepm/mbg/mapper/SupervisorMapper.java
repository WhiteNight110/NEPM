package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.Supervisor;
import com.neusoft.nepm.mbg.model.SupervisorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupervisorMapper {
    int countByExample(SupervisorExample example);

    int deleteByExample(SupervisorExample example);

    int deleteByPrimaryKey(String telId);

    int insert(Supervisor record);

    int insertSelective(Supervisor record);

    List<Supervisor> selectByExample(SupervisorExample example);

    Supervisor selectByPrimaryKey(String telId);

    int updateByExampleSelective(@Param("record") Supervisor record, @Param("example") SupervisorExample example);

    int updateByExample(@Param("record") Supervisor record, @Param("example") SupervisorExample example);

    int updateByPrimaryKeySelective(Supervisor record);

    int updateByPrimaryKey(Supervisor record);
}