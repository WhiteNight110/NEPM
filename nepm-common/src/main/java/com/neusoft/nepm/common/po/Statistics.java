package com.neusoft.nepm.common.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * <p>
 * 空气质量监测数据统计表
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public class Statistics implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 统计信息编号
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date confirmDate;

    /**
     * 确认时间
     */
    private Time confirmTime;

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

    public Integer getAqiLevel() {
        return aqiLevel;
    }

    public void setAqiLevel(Integer aqiLevel) {
        this.aqiLevel = aqiLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Double getSo2Value() {
        return so2Value;
    }

    public void setSo2Value(Double so2Value) {
        this.so2Value = so2Value;
    }
    public Integer getSo2Level() {
        return so2Level;
    }

    public void setSo2Level(Integer so2Level) {
        this.so2Level = so2Level;
    }
    public Double getCoValue() {
        return coValue;
    }

    public void setCoValue(Double coValue) {
        this.coValue = coValue;
    }
    public Integer getCoLevel() {
        return coLevel;
    }

    public void setCoLevel(Integer coLevel) {
        this.coLevel = coLevel;
    }
    public Double getSpmValue() {
        return spmValue;
    }

    public void setSpmValue(Double spmValue) {
        this.spmValue = spmValue;
    }
    public Integer getSpmLevel() {
        return spmLevel;
    }

    public void setSpmLevel(Integer spmLevel) {
        this.spmLevel = spmLevel;
    }
    public Integer getAqiId() {
        return aqiLevel;
    }

    public void setAqiId(Integer aqiLevel) {
        this.aqiLevel = aqiLevel;
    }
    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }
    public Time getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Time confirmTime) {
        this.confirmTime = confirmTime;
    }
    public Integer getGmId() {
        return gmId;
    }

    public void setGmId(Integer gmId) {
        this.gmId = gmId;
    }
    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId;
    }
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Statistics{" +
            "id=" + id +
            ", provinceId=" + provinceId +
            ", cityId=" + cityId +
            ", address=" + address +
            ", so2Value=" + so2Value +
            ", so2Level=" + so2Level +
            ", coValue=" + coValue +
            ", coLevel=" + coLevel +
            ", spmValue=" + spmValue +
            ", spmLevel=" + spmLevel +
            ", aqiLevel=" + aqiLevel +
            ", confirmDate=" + confirmDate +
            ", confirmTime=" + confirmTime +
            ", gmId=" + gmId +
            ", fdId=" + fdId +
            ", information=" + information +
            ", remarks=" + remarks +
        "}";
    }
}
