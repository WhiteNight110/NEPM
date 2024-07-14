package com.neusoft.nepm.common.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 系统管理员表
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public class Admins implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统管理员编号
     */
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    /**
     * 系统管理员登录编码
     */
    private String adminCode;

    /**
     * 系统管理员登录密码
     */
    private String password;

    /**
     * 备注
     */
    private String remarks;

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
        return "Admins{" +
            "adminId=" + adminId +
            ", adminCode=" + adminCode +
            ", password=" + password +
            ", remarks=" + remarks +
        "}";
    }
}
