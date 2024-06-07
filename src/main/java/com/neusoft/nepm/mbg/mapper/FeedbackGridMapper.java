package com.neusoft.nepm.mbg.mapper;

import com.neusoft.nepm.mbg.model.FeedbackGrid;
import com.neusoft.nepm.mbg.model.FeedbackGridExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackGridMapper {
    int countByExample(FeedbackGridExample example);

    int deleteByExample(FeedbackGridExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FeedbackGrid record);

    int insertSelective(FeedbackGrid record);

    List<FeedbackGrid> selectByExample(FeedbackGridExample example);

    FeedbackGrid selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FeedbackGrid record, @Param("example") FeedbackGridExample example);

    int updateByExample(@Param("record") FeedbackGrid record, @Param("example") FeedbackGridExample example);

    int updateByPrimaryKeySelective(FeedbackGrid record);

    int updateByPrimaryKey(FeedbackGrid record);
}