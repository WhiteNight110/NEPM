package com.neusoft.nepm.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Statistics implements Serializable {
    @ApiModelProperty(value = "统计信息编号")
    private Integer id;

    @ApiModelProperty(value = "所属省区域编号")
    private Integer provinceId;

    @ApiModelProperty(value = "所属市区域编号")
    private Integer cityId;

    @ApiModelProperty(value = "反馈信息所在区域详细地址")
    private String address;

    @ApiModelProperty(value = "实测空气二氧化硫浓度值(单位：μg/m3)")
    private Integer so2Value;

    @ApiModelProperty(value = "空气二氧化硫指数级别")
    private Integer so2Level;

    @ApiModelProperty(value = "实测空气一氧化碳浓度值(单位：μg/m3)")
    private Integer coValue;

    @ApiModelProperty(value = "空气一氧化碳指数级别")
    private Integer coLevel;

    @ApiModelProperty(value = "实测空气悬浮颗粒物浓度值(单位：μg/m3)")
    private Integer spmValue;

    @ApiModelProperty(value = "空气PM2.5指数级别")
    private Integer spmLevel;

    @ApiModelProperty(value = "实测空气质量指数级别")
    private Integer aqiId;

    @ApiModelProperty(value = "确认日期")
    private String confirmDate;

    @ApiModelProperty(value = "确认时间")
    private String confirmTime;

    @ApiModelProperty(value = "所属网格员编号")
    private Integer gmId;

    @ApiModelProperty(value = "反馈者编号(公众监督员电话号码)")
    private String fdId;

    @ApiModelProperty(value = "反馈信息描述")
    private String information;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

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

    public Integer getSo2Value() {
        return so2Value;
    }

    public void setSo2Value(Integer so2Value) {
        this.so2Value = so2Value;
    }

    public Integer getSo2Level() {
        return so2Level;
    }

    public void setSo2Level(Integer so2Level) {
        this.so2Level = so2Level;
    }

    public Integer getCoValue() {
        return coValue;
    }

    public void setCoValue(Integer coValue) {
        this.coValue = coValue;
    }

    public Integer getCoLevel() {
        return coLevel;
    }

    public void setCoLevel(Integer coLevel) {
        this.coLevel = coLevel;
    }

    public Integer getSpmValue() {
        return spmValue;
    }

    public void setSpmValue(Integer spmValue) {
        this.spmValue = spmValue;
    }

    public Integer getSpmLevel() {
        return spmLevel;
    }

    public void setSpmLevel(Integer spmLevel) {
        this.spmLevel = spmLevel;
    }

    public Integer getAqiId() {
        return aqiId;
    }

    public void setAqiId(Integer aqiId) {
        this.aqiId = aqiId;
    }

    public String getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", address=").append(address);
        sb.append(", so2Value=").append(so2Value);
        sb.append(", so2Level=").append(so2Level);
        sb.append(", coValue=").append(coValue);
        sb.append(", coLevel=").append(coLevel);
        sb.append(", spmValue=").append(spmValue);
        sb.append(", spmLevel=").append(spmLevel);
        sb.append(", aqiId=").append(aqiId);
        sb.append(", confirmDate=").append(confirmDate);
        sb.append(", confirmTime=").append(confirmTime);
        sb.append(", gmId=").append(gmId);
        sb.append(", fdId=").append(fdId);
        sb.append(", information=").append(information);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}