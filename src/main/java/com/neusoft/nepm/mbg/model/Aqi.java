package com.neusoft.nepm.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Aqi implements Serializable {
    @ApiModelProperty(value = "空气质量指数级别(共六级)")
    private Integer aqiId;

    @ApiModelProperty(value = "空气质量指数级别汉字表述")
    private String chineseExplain;

    @ApiModelProperty(value = "空气质量指数级别描述")
    private String aqiExplain;

    @ApiModelProperty(value = "空气质量指数级别表示颜色")
    private String color;

    @ApiModelProperty(value = "对健康影响情况")
    private String healthImpact;

    @ApiModelProperty(value = "建议采取的措施")
    private String takeSteps;

    @ApiModelProperty(value = "本级别二氧化硫浓度最小限值")
    private Integer so2Min;

    @ApiModelProperty(value = "本级别二氧化硫浓度最大限值")
    private Integer so2Max;

    @ApiModelProperty(value = "本级别一氧化碳浓度最小限值")
    private Integer coMin;

    @ApiModelProperty(value = "本级别一氧化碳浓度最大限值")
    private Integer coMax;

    @ApiModelProperty(value = "本级别悬浮颗粒物浓度最小限值")
    private Integer spmMin;

    @ApiModelProperty(value = "本级别悬浮颗粒物浓度最大限值")
    private Integer spmMax;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getAqiId() {
        return aqiId;
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

    public Integer getSo2Min() {
        return so2Min;
    }

    public void setSo2Min(Integer so2Min) {
        this.so2Min = so2Min;
    }

    public Integer getSo2Max() {
        return so2Max;
    }

    public void setSo2Max(Integer so2Max) {
        this.so2Max = so2Max;
    }

    public Integer getCoMin() {
        return coMin;
    }

    public void setCoMin(Integer coMin) {
        this.coMin = coMin;
    }

    public Integer getCoMax() {
        return coMax;
    }

    public void setCoMax(Integer coMax) {
        this.coMax = coMax;
    }

    public Integer getSpmMin() {
        return spmMin;
    }

    public void setSpmMin(Integer spmMin) {
        this.spmMin = spmMin;
    }

    public Integer getSpmMax() {
        return spmMax;
    }

    public void setSpmMax(Integer spmMax) {
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aqiId=").append(aqiId);
        sb.append(", chineseExplain=").append(chineseExplain);
        sb.append(", aqiExplain=").append(aqiExplain);
        sb.append(", color=").append(color);
        sb.append(", healthImpact=").append(healthImpact);
        sb.append(", takeSteps=").append(takeSteps);
        sb.append(", so2Min=").append(so2Min);
        sb.append(", so2Max=").append(so2Max);
        sb.append(", coMin=").append(coMin);
        sb.append(", coMax=").append(coMax);
        sb.append(", spmMin=").append(spmMin);
        sb.append(", spmMax=").append(spmMax);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}