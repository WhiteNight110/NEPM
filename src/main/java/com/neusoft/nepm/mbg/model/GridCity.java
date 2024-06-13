package com.neusoft.nepm.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class GridCity implements Serializable {
    @ApiModelProperty(value = "系统网格覆盖市区域编号")
    private Integer cityId;

    @ApiModelProperty(value = "系统网格覆盖市区域名称")
    private String cityName;

    @ApiModelProperty(value = "所属省区域编号")
    private Integer provinceId;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
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
        sb.append(", cityId=").append(cityId);
        sb.append(", cityName=").append(cityName);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}