package com.neusoft.nepm.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统网格覆盖市区域表
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@TableName("grid_city")
public class GridCity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统网格覆盖市区域编号
     */
    @TableId(value = "city_id", type = IdType.AUTO)
    private Integer cityId;

    /**
     * 系统网格覆盖市区域名称
     */
    private String cityName;

    /**
     * 所属省区域编号
     */
    private Integer provinceId;

    /**
     * 备注
     */
    private String remarks;

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
        return "GridCity{" +
            "cityId=" + cityId +
            ", cityName=" + cityName +
            ", provinceId=" + provinceId +
            ", remarks=" + remarks +
        "}";
    }
}
