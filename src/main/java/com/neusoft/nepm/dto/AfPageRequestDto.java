package com.neusoft.nepm.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.po.AqiFeedback;
import com.neusoft.nepm.po.Supervisor;
import com.neusoft.nepm.service.impl.SupervisorServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@ApiModel(description = "AqiFeedback分页结果")
public class AfPageRequestDto{

    private Integer page = 1;
    private Integer size = 5;
    private Integer provinceId;
    private Integer cityId;
    private Integer estimatedGrade;
    private Integer state;
    private String telId;

    private Supervisor supervisor;
//    后续添加针对时间的查询
    private Date afDate;
}
