package com.neusoft.nepm.dto;

import com.neusoft.nepm.po.Aqi;
import com.neusoft.nepm.po.GridMember;
import com.neusoft.nepm.po.Supervisor;
import lombok.Data;

@Data
public class StatisticsPageResponseDto {

    private Integer id;

    /**
     * 所属省区域编号
     */
    private Integer provinceId;

    /**
     * 所属市区域编号
     */
    private Integer cityId;

    /**
     * 反馈信息所在区域详细地址
     */
    private String address;

    /**
     * 实测空气二氧化硫浓度值(单位：μg/m3)
     */
    private Double so2Value;

    /**
     * 空气二氧化硫指数级别
     */
    private Integer so2Level;

    /**
     * 实测空气一氧化碳浓度值(单位：μg/m3)
     */
    private Double coValue;

    /**
     * 空气一氧化碳指数级别
     */
    private Integer coLevel;

    /**
     * 实测空气悬浮颗粒物浓度值(单位：μg/m3)
     */
    private Double spmValue;

    /**
     * 空气PM2.5指数级别
     */
    private Integer spmLevel;

    /**
     * 实测空气质量指数级别
     */
    private Integer aqiLevel;

    /**
     * 确认日期
     */
    private String confirmDate;

    /**
     * 确认时间
     */
    private String confirmTime;

    /**
     * 所属网格员编号
     */
    private Integer gmId;

    /**
     * 反馈者编号(公众监督员电话号码)
     */
    private String fdId;

    /**
     * 反馈信息描述
     */
    private String information;

    /**
     * 备注
     */
    private String remarks;

    private Aqi aqi;

    private GridMember gridMember;

    private Supervisor supervisor;
}
