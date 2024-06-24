package com.neusoft.nepm.dto;


import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
public class AfPageResponseDto {
    private Integer afId;

    private String name;

    private String provinceName;

    private String cityName;

    private Integer estimatedGrade;

    private Date afDate;

    private Time afTime;

    private Integer state = -1;
}
