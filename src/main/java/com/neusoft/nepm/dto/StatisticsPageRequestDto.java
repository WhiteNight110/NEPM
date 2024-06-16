package com.neusoft.nepm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Statistic分页结果")
public class StatisticsPageRequestDto {
    private int page = 1;
    private int size = 5;
    private int province_id;
    private String address;
    private int so2Level;
    private int coLevel;
    private int spmLevel;
    private int aqiLevel;

    //    后续添加针对时间的查询
}
