package com.neusoft.nepm.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Admins implements Serializable {
    @ApiModelProperty(value = "系统管理员编号")
    private Integer adminId;

    @ApiModelProperty(value = "系统管理员登录编码")
    private String adminCode;

    @ApiModelProperty(value = "系统管理员登录密码")
    private String password;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        sb.append(", adminId=").append(adminId);
        sb.append(", adminCode=").append(adminCode);
        sb.append(", password=").append(password);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}