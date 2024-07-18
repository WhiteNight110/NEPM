package com.neusoft.nepm.common.dto;


import com.neusoft.nepm.common.po.Supervisor;
import lombok.Data;

import java.sql.Time;

@Data
public class AfPageResponseDto {
    private Integer afId;

    /**
     * 所属公众监督员编号(即手机号码)
     */
    private String telId;

    /**
     * 反馈信息所在省区域编号
     */
    private Integer provinceId;

    /**
     * 反馈信息所在市区域编号
     */
    private Integer cityId;

    /**
     * 反馈信息所在区域详细地址
     */
    private String address;

    /**
     * 反馈信息描述
     */
    private String information;

    /**
     * 反馈者对空气质量指数级别的预估等级
     */
    private Integer estimatedGrade;

    /**
     * 反馈日期
     */
    private String afDate;

    /**
     * 反馈时间
     */
    private Time afTime;

    /**
     * 指派网格员编号
     */
    private Integer gmId;

    /**
     * 指派日期
     */
    private String assignDate;

    /**
     * 指派时间
     */
    private Time assignTime;

    /**
     * 信息状态	0：未指派	1：已指派	2：已确认
     */
    private Integer state;

    /**
     * 备注
     */
    private String remarks;

    private Supervisor supervisor;

}
