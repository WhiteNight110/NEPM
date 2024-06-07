package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.TaskDetail;
import com.neusoft.nepm.mbg.model.TaskDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskDetailMapper {
    int countByExample(TaskDetailExample example);

    int deleteByExample(TaskDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaskDetail record);

    int insertSelective(TaskDetail record);

    List<TaskDetail> selectByExample(TaskDetailExample example);

    TaskDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaskDetail record, @Param("example") TaskDetailExample example);

    int updateByExample(@Param("record") TaskDetail record, @Param("example") TaskDetailExample example);

    int updateByPrimaryKeySelective(TaskDetail record);

    int updateByPrimaryKey(TaskDetail record);
}