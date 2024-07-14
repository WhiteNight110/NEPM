package com.neusoft.nepm.common.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "Statistic分页参数")
public class StatisticsPageRequestDto {
    private Integer page = 1;

    private Integer size = 7;

    private Integer provinceId;

    private Integer cityId;

    private String address;

    private Integer so2Level;

    private Integer coLevel;

    private Integer spmLevel;

    private Integer aqiLevel;

    private Date confirmDate;
}
