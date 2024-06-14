package com.neusoft.nepm.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统网格覆盖省区域表
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
@TableName("grid_province")
public class GridProvince implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统网格覆盖省区域编号
     */
    @TableId(value = "province_id", type = IdType.AUTO)
    private Integer provinceId;

    /**
     * 系统网格覆盖省区域名称
     */
    private String provinceName;

    /**
     * 系统网格覆盖省区域简称
     */
    private String provinceAbbr;

    /**
     * 备注
     */
    private String remarks;

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
        return "GridProvince{" +
            "provinceId=" + provinceId +
            ", provinceName=" + provinceName +
            ", provinceAbbr=" + provinceAbbr +
            ", remarks=" + remarks +
        "}";
    }
}
