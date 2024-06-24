package com.neusoft.nepm.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 空气质量指数级别表
 * </p>
 *
 * @author crm
 * @since 2024-06-14
 */
public class Aqi implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 空气质量编号
     */
    @TableId(value = "aqi_id", type = IdType.AUTO)
    private Integer aqiId;

    /**
     * 空气质量指数级别(共六级)
     */
    private Integer aqiLevel;

    /**
     * 空气质量指数级别汉字表述
     */
    private String chineseExplain;

    /**
     * 空气质量指数级别描述
     */
    private String aqiExplain;

    /**
     * 空气质量指数级别表示颜色
     */
    private String color;

    /**
     * 对健康影响情况
     */
    private String healthImpact;

    /**
     * 建议采取的措施
     */
    private String takeSteps;

    /**
     * 本级别二氧化硫浓度最小限值
     */
    private Double so2Min;

    /**
     * 本级别二氧化硫浓度最大限值
     */
    private Double so2Max;

    /**
     * 本级别一氧化碳浓度最小限值
     */
    private Double coMin;

    /**
     * 本级别一氧化碳浓度最大限值
     */
    private Double coMax;

    /**
     * 本级别悬浮颗粒物浓度最小限值
     */
    private Double spmMin;

    /**
     * 本级别悬浮颗粒物浓度最大限值
     */
    private Double spmMax;

    /**
     * 备注
     */
    private String remarks;

    public Integer getAqiId() {
        return aqiId;
    }

    public void setAqiLevel(Integer aqiLevel) {
        this.aqiLevel = aqiLevel;
    }
    public Integer getAqiLevel() {
        return aqiLevel;
    }

    public void setAqiId(Integer aqiId) {
        this.aqiId = aqiId;
    }
    public String getChineseExplain() {
        return chineseExplain;
    }

    public void setChineseExplain(String chineseExplain) {
        this.chineseExplain = chineseExplain;
    }
    public String getAqiExplain() {
        return aqiExplain;
    }

    public void setAqiExplain(String aqiExplain) {
        this.aqiExplain = aqiExplain;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getHealthImpact() {
        return healthImpact;
    }

    public void setHealthImpact(String healthImpact) {
        this.healthImpact = healthImpact;
    }
    public String getTakeSteps() {
        return takeSteps;
    }

    public void setTakeSteps(String takeSteps) {
        this.takeSteps = takeSteps;
    }
    public Double getSo2Min() {
        return so2Min;
    }

    public void setSo2Min(Double so2Min) {
        this.so2Min = so2Min;
    }
    public Double getSo2Max() {
        return so2Max;
    }

    public void setSo2Max(Double so2Max) {
        this.so2Max = so2Max;
    }
    public Double getCoMin() {
        return coMin;
    }

    public void setCoMin(Double coMin) {
        this.coMin = coMin;
    }
    public Double getCoMax() {
        return coMax;
    }

    public void setCoMax(Double coMax) {
        this.coMax = coMax;
    }
    public Double getSpmMin() {
        return spmMin;
    }

    public void setSpmMin(Double spmMin) {
        this.spmMin = spmMin;
    }
    public Double getSpmMax() {
        return spmMax;
    }

    public void setSpmMax(Double spmMax) {
        this.spmMax = spmMax;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Aqi{" +
            "aqiId=" + aqiId +
            ", chineseExplain=" + chineseExplain +
            ", aqiExplain=" + aqiExplain +
            ", color=" + color +
            ", healthImpact=" + healthImpact +
            ", takeSteps=" + takeSteps +
            ", so2Min=" + so2Min +
            ", so2Max=" + so2Max +
            ", coMin=" + coMin +
            ", coMax=" + coMax +
            ", spmMin=" + spmMin +
            ", spmMax=" + spmMax +
            ", remarks=" + remarks +
            ", aqiLevel=" + aqiLevel +
        "}";
    }
}
