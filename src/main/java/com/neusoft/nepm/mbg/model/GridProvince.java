package com.neusoft.nepm.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class GridProvince implements Serializable {
    @ApiModelProperty(value = "系统网格覆盖省区域编号")
    private Integer provinceId;

    @ApiModelProperty(value = "系统网格覆盖省区域名称")
    private String provinceName;

    @ApiModelProperty(value = "系统网格覆盖省区域简称")
    private String provinceAbbr;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceAbbr() {
        return provinceAbbr;
    }

    public void setProvinceAbbr(String provinceAbbr) {
        this.provinceAbbr = provinceAbbr;
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
        sb.append(", provinceId=").append(provinceId);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", provinceAbbr=").append(provinceAbbr);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}