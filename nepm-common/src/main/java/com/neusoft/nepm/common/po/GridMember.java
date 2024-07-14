package com.neusoft.nepm.common.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 空气质量监测网格员表
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@TableName("grid_member")
public class GridMember implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 网格员手机号码
     */
    @TableId
    private Integer gmId;

    /**
     * 网格员名称
     */
    private String gmName;

    /**
     * 网格员登录编码
     */
    private String gmCode;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 网格区域：省编号
     */
    private Integer provinceId;

    /**
     * 网格区域：市编号
     */
    private Integer cityId;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 网格员状态	0：可工作状态	1：临时抽调	2：休假	3：其他
     */
    private Integer state;

    /**
     * 备注
     */
    private String remarks;

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
        return "GridMember{" +
            "gmId=" + gmId +
            ", gmName=" + gmName +
            ", gmCode=" + gmCode +
            ", password=" + password +
            ", provinceId=" + provinceId +
            ", cityId=" + cityId +
            ", tel=" + tel +
            ", state=" + state +
            ", remarks=" + remarks +
        "}";
    }
}
