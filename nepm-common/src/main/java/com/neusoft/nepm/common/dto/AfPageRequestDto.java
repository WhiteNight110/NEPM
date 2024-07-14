package com.neusoft.nepm.common.dto;

import com.neusoft.nepm.common.po.Supervisor;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "AqiFeedback分页结果")
public class AfPageRequestDto{

    private Integer page = 1;
    private Integer size = 7;
    private Integer provinceId;
    private Integer cityId;
    private Integer estimatedGrade;
    private Integer state;
    private String telId;

    private Supervisor supervisor;
//    后续添加针对时间的查询
    private Date afDate;
}
