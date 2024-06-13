package com.neusoft.nepm.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AqiFeedback implements Serializable {
    @ApiModelProperty(value = "空气质量公众监督反馈信息编号")
    private Integer afId;

    @ApiModelProperty(value = "所属公众监督员编号(即手机号码)")
    private String telId;

    @ApiModelProperty(value = "反馈信息所在省区域编号")
    private Integer provinceId;

    @ApiModelProperty(value = "反馈信息所在市区域编号")
    private Integer cityId;

    @ApiModelProperty(value = "反馈信息所在区域详细地址")
    private String address;

    @ApiModelProperty(value = "反馈信息描述")
    private String information;

    @ApiModelProperty(value = "反馈者对空气质量指数级别的预估等级")
    private Integer estimatedGrade;

    @ApiModelProperty(value = "反馈日期")
    private String afDate;

    @ApiModelProperty(value = "反馈时间")
    private String afTime;

    @ApiModelProperty(value = "指派网格员编号")
    private Integer gmId;

    @ApiModelProperty(value = "指派日期")
    private String assignDate;

    @ApiModelProperty(value = "指派时间")
    private String assignTime;

    @ApiModelProperty(value = "信息状态 0：未指派 1：已指派 2：已确认")
    private Integer state;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getAfId() {
        return afId;
    }

    public void setAfId(Integer afId) {
        this.afId = afId;
    }

    public String getTelId() {
        return telId;
    }

    public void setTelId(String telId) {
        this.telId = telId;
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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getEstimatedGrade() {
        return estimatedGrade;
    }

    public void setEstimatedGrade(Integer estimatedGrade) {
        this.estimatedGrade = estimatedGrade;
    }

    public String getAfDate() {
        return afDate;
    }

    public void setAfDate(String afDate) {
        this.afDate = afDate;
    }

    public String getAfTime() {
        return afTime;
    }

    public void setAfTime(String afTime) {
        this.afTime = afTime;
    }

    public Integer getGmId() {
        return gmId;
    }

    public void setGmId(Integer gmId) {
        this.gmId = gmId;
    }

    public String getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(String assignDate) {
        this.assignDate = assignDate;
    }

    public String getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(String assignTime) {
        this.assignTime = assignTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
        sb.append(", afId=").append(afId);
        sb.append(", telId=").append(telId);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", address=").append(address);
        sb.append(", information=").append(information);
        sb.append(", estimatedGrade=").append(estimatedGrade);
        sb.append(", afDate=").append(afDate);
        sb.append(", afTime=").append(afTime);
        sb.append(", gmId=").append(gmId);
        sb.append(", assignDate=").append(assignDate);
        sb.append(", assignTime=").append(assignTime);
        sb.append(", state=").append(state);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}