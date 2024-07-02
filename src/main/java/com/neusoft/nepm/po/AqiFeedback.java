package com.neusoft.nepm.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 * <p>
 * 空气质量公众监督反馈表
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@TableName("aqi_feedback")
public class AqiFeedback implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 空气质量公众监督反馈信息编号
     */
    @TableId(value = "af_id", type = IdType.AUTO)
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date afDate;

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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date assignDate;

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
    public Date getAfDate() {
        return afDate;
    }

    public void setAfDate(Date afDate) {
        this.afDate = afDate;
    }
    public Time getAfTime() {
        return afTime;
    }

    public void setAfTime(Time afTime) {
        this.afTime = afTime;
    }
    public Integer getGmId() {
        return gmId;
    }

    public void setGmId(Integer gmId) {
        this.gmId = gmId;
    }
    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }
    public Time getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(Time assignTime) {
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
        return "AqiFeedback{" +
            "afId=" + afId +
            ", telId=" + telId +
            ", provinceId=" + provinceId +
            ", cityId=" + cityId +
            ", address=" + address +
            ", information=" + information +
            ", estimatedGrade=" + estimatedGrade +
            ", afDate=" + afDate +
            ", afTime=" + afTime +
            ", gmId=" + gmId +
            ", assignDate=" + assignDate +
            ", assignTime=" + assignTime +
            ", state=" + state +
            ", remarks=" + remarks +
        "}";
    }
}
