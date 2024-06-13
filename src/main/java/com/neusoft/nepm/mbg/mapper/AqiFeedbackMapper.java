package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.AqiFeedback;
import com.neusoft.nepm.mbg.model.AqiFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AqiFeedbackMapper {
    int countByExample(AqiFeedbackExample example);

    int deleteByExample(AqiFeedbackExample example);

    int deleteByPrimaryKey(Integer afId);

    int insert(AqiFeedback record);

    int insertSelective(AqiFeedback record);

    List<AqiFeedback> selectByExample(AqiFeedbackExample example);

    AqiFeedback selectByPrimaryKey(Integer afId);

    int updateByExampleSelective(@Param("record") AqiFeedback record, @Param("example") AqiFeedbackExample example);

    int updateByExample(@Param("record") AqiFeedback record, @Param("example") AqiFeedbackExample example);

    int updateByPrimaryKeySelective(AqiFeedback record);

    int updateByPrimaryKey(AqiFeedback record);
}