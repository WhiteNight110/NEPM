package com.neusoft.nepm.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

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
    private Integer so2Value;

    /**
     * 空气二氧化硫指数级别
     */
    private Integer so2Level;

    /**
     * 实测空气一氧化碳浓度值(单位：μg/m3)
     */
    private Integer coValue;

    /**
     * 空气一氧化碳指数级别
     */
    private Integer coLevel;

    /**
     * 实测空气悬浮颗粒物浓度值(单位：μg/m3)
     */
    private Integer spmValue;

    /**
     * 空气PM2.5指数级别
     */
    private Integer spmLevel;

    /**
     * 实测空气质量指数级别
     */
    private Integer aqiId;

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
            ", aqiId=" + aqiId +
            ", confirmDate=" + confirmDate +
            ", confirmTime=" + confirmTime +
            ", gmId=" + gmId +
            ", fdId=" + fdId +
            ", information=" + information +
            ", remarks=" + remarks +
        "}";
    }
}
