package com.neusoft.nepm.common.po;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 公众监督员表
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public class Supervisor implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公众监督员编号(即手机号码)
     */
    @TableId
    private String telId;

    /**
     * 公众监督员登录密码
     */
    private String password;

    /**
     * 公众监督员真实姓名
     */
    private String realName;

    /**
     * 公众监督员出生日期
     */
    private Date birthday;

    /**
     * 公众监督员性别(1：男；0：女)
     */
    private Integer sex;

    /**
     * 备注
     */
    private String remarks;

    public String getTelId() {
        return telId;
    }

    public void setTelId(String telId) {
        this.telId = telId;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
            "telId=" + telId +
            ", password=" + password +
            ", realName=" + realName +
            ", birthday=" + birthday +
            ", sex=" + sex +
            ", remarks=" + remarks +
        "}";
    }
}
