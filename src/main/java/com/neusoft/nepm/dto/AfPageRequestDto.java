package com.neusoft.nepm.dto;

import com.neusoft.nepm.common.api.CommonPage;
import com.neusoft.nepm.po.AqiFeedback;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "AqiFeedback分页结果")
public class AfPageRequestDto{

    private int page = 1;
    private int size = 5;
    private int provinceId;
    private int cityId;
    private int estimatedId;
    private int state;

//    后续添加针对时间的查询

}
