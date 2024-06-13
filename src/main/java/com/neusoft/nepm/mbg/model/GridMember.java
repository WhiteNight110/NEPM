package com.neusoft.nepm.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class GridMember implements Serializable {
    @ApiModelProperty(value = "网格员手机号码")
    private Integer gmId;

    @ApiModelProperty(value = "网格员名称")
    private String gmName;

    @ApiModelProperty(value = "网格员登录编码")
    private String gmCode;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "网格区域：省编号")
    private Integer provinceId;

    @ApiModelProperty(value = "网格区域：市编号")
    private Integer cityId;

    @ApiModelProperty(value = "联系电话")
    private String tel;

    @ApiModelProperty(value = "网格员状态 0：可工作状态 1：临时抽调 2：休假 3：其他")
    private Integer state;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getGmId() {
        return gmId;
    }

    public void setGmId(Integer gmId) {
        this.gmId = gmId;
    }

    public String getGmName() {
        return gmName;
    }

    public void setGmName(String gmName) {
        this.gmName = gmName;
    }

    public String getGmCode() {
        return gmCode;
    }

    public void setGmCode(String gmCode) {
        this.gmCode = gmCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
        sb.append(", gmId=").append(gmId);
        sb.append(", gmName=").append(gmName);
        sb.append(", gmCode=").append(gmCode);
        sb.append(", password=").append(password);
        sb.append(", provinceId=").append(provinceId);
        sb.append(", cityId=").append(cityId);
        sb.append(", tel=").append(tel);
        sb.append(", state=").append(state);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}