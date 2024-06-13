package com.neusoft.nepm.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class AqiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AqiExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAqiIdIsNull() {
            addCriterion("aqi_id is null");
            return (Criteria) this;
        }

        public Criteria andAqiIdIsNotNull() {
            addCriterion("aqi_id is not null");
            return (Criteria) this;
        }

        public Criteria andAqiIdEqualTo(Integer value) {
            addCriterion("aqi_id =", value, "aqiId");
            return (Criteria) this;
        }

        public Criteria andAqiIdNotEqualTo(Integer value) {
            addCriterion("aqi_id <>", value, "aqiId");
            return (Criteria) this;
        }

        public Criteria andAqiIdGreaterThan(Integer value) {
            addCriterion("aqi_id >", value, "aqiId");
            return (Criteria) this;
        }

        public Criteria andAqiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("aqi_id >=", value, "aqiId");
            return (Criteria) this;
        }

        public Criteria andAqiIdLessThan(Integer value) {
            addCriterion("aqi_id <", value, "aqiId");
            return (Criteria) this;
        }

        public Criteria andAqiIdLessThanOrEqualTo(Integer value) {
            addCriterion("aqi_id <=", value, "aqiId");
            return (Criteria) this;
        }

        public Criteria andAqiIdIn(List<Integer> values) {
            addCriterion("aqi_id in", values, "aqiId");
            return (Criteria) this;
        }

        public Criteria andAqiIdNotIn(List<Integer> values) {
            addCriterion("aqi_id not in", values, "aqiId");
            return (Criteria) this;
        }

        public Criteria andAqiIdBetween(Integer value1, Integer value2) {
            addCriterion("aqi_id between", value1, value2, "aqiId");
            return (Criteria) this;
        }

        public Criteria andAqiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("aqi_id not between", value1, value2, "aqiId");
            return (Criteria) this;
        }

        public Criteria andChineseExplainIsNull() {
            addCriterion("chinese_explain is null");
            return (Criteria) this;
        }

        public Criteria andChineseExplainIsNotNull() {
            addCriterion("chinese_explain is not null");
            return (Criteria) this;
        }

        public Criteria andChineseExplainEqualTo(String value) {
            addCriterion("chinese_explain =", value, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainNotEqualTo(String value) {
            addCriterion("chinese_explain <>", value, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainGreaterThan(String value) {
            addCriterion("chinese_explain >", value, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainGreaterThanOrEqualTo(String value) {
            addCriterion("chinese_explain >=", value, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainLessThan(String value) {
            addCriterion("chinese_explain <", value, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainLessThanOrEqualTo(String value) {
            addCriterion("chinese_explain <=", value, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainLike(String value) {
            addCriterion("chinese_explain like", value, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainNotLike(String value) {
            addCriterion("chinese_explain not like", value, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainIn(List<String> values) {
            addCriterion("chinese_explain in", values, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainNotIn(List<String> values) {
            addCriterion("chinese_explain not in", values, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainBetween(String value1, String value2) {
            addCriterion("chinese_explain between", value1, value2, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andChineseExplainNotBetween(String value1, String value2) {
            addCriterion("chinese_explain not between", value1, value2, "chineseExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainIsNull() {
            addCriterion("aqi_explain is null");
            return (Criteria) this;
        }

        public Criteria andAqiExplainIsNotNull() {
            addCriterion("aqi_explain is not null");
            return (Criteria) this;
        }

        public Criteria andAqiExplainEqualTo(String value) {
            addCriterion("aqi_explain =", value, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainNotEqualTo(String value) {
            addCriterion("aqi_explain <>", value, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainGreaterThan(String value) {
            addCriterion("aqi_explain >", value, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainGreaterThanOrEqualTo(String value) {
            addCriterion("aqi_explain >=", value, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainLessThan(String value) {
            addCriterion("aqi_explain <", value, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainLessThanOrEqualTo(String value) {
            addCriterion("aqi_explain <=", value, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainLike(String value) {
            addCriterion("aqi_explain like", value, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainNotLike(String value) {
            addCriterion("aqi_explain not like", value, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainIn(List<String> values) {
            addCriterion("aqi_explain in", values, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainNotIn(List<String> values) {
            addCriterion("aqi_explain not in", values, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainBetween(String value1, String value2) {
            addCriterion("aqi_explain between", value1, value2, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andAqiExplainNotBetween(String value1, String value2) {
            addCriterion("aqi_explain not between", value1, value2, "aqiExplain");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andHealthImpactIsNull() {
            addCriterion("health_impact is null");
            return (Criteria) this;
        }

        public Criteria andHealthImpactIsNotNull() {
            addCriterion("health_impact is not null");
            return (Criteria) this;
        }

        public Criteria andHealthImpactEqualTo(String value) {
            addCriterion("health_impact =", value, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactNotEqualTo(String value) {
            addCriterion("health_impact <>", value, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactGreaterThan(String value) {
            addCriterion("health_impact >", value, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactGreaterThanOrEqualTo(String value) {
            addCriterion("health_impact >=", value, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactLessThan(String value) {
            addCriterion("health_impact <", value, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactLessThanOrEqualTo(String value) {
            addCriterion("health_impact <=", value, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactLike(String value) {
            addCriterion("health_impact like", value, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactNotLike(String value) {
            addCriterion("health_impact not like", value, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactIn(List<String> values) {
            addCriterion("health_impact in", values, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactNotIn(List<String> values) {
            addCriterion("health_impact not in", values, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactBetween(String value1, String value2) {
            addCriterion("health_impact between", value1, value2, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andHealthImpactNotBetween(String value1, String value2) {
            addCriterion("health_impact not between", value1, value2, "healthImpact");
            return (Criteria) this;
        }

        public Criteria andTakeStepsIsNull() {
            addCriterion("take_steps is null");
            return (Criteria) this;
        }

        public Criteria andTakeStepsIsNotNull() {
            addCriterion("take_steps is not null");
            return (Criteria) this;
        }

        public Criteria andTakeStepsEqualTo(String value) {
            addCriterion("take_steps =", value, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsNotEqualTo(String value) {
            addCriterion("take_steps <>", value, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsGreaterThan(String value) {
            addCriterion("take_steps >", value, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsGreaterThanOrEqualTo(String value) {
            addCriterion("take_steps >=", value, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsLessThan(String value) {
            addCriterion("take_steps <", value, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsLessThanOrEqualTo(String value) {
            addCriterion("take_steps <=", value, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsLike(String value) {
            addCriterion("take_steps like", value, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsNotLike(String value) {
            addCriterion("take_steps not like", value, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsIn(List<String> values) {
            addCriterion("take_steps in", values, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsNotIn(List<String> values) {
            addCriterion("take_steps not in", values, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsBetween(String value1, String value2) {
            addCriterion("take_steps between", value1, value2, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andTakeStepsNotBetween(String value1, String value2) {
            addCriterion("take_steps not between", value1, value2, "takeSteps");
            return (Criteria) this;
        }

        public Criteria andSo2MinIsNull() {
            addCriterion("so2_min is null");
            return (Criteria) this;
        }

        public Criteria andSo2MinIsNotNull() {
            addCriterion("so2_min is not null");
            return (Criteria) this;
        }

        public Criteria andSo2MinEqualTo(Integer value) {
            addCriterion("so2_min =", value, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MinNotEqualTo(Integer value) {
            addCriterion("so2_min <>", value, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MinGreaterThan(Integer value) {
            addCriterion("so2_min >", value, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MinGreaterThanOrEqualTo(Integer value) {
            addCriterion("so2_min >=", value, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MinLessThan(Integer value) {
            addCriterion("so2_min <", value, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MinLessThanOrEqualTo(Integer value) {
            addCriterion("so2_min <=", value, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MinIn(List<Integer> values) {
            addCriterion("so2_min in", values, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MinNotIn(List<Integer> values) {
            addCriterion("so2_min not in", values, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MinBetween(Integer value1, Integer value2) {
            addCriterion("so2_min between", value1, value2, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MinNotBetween(Integer value1, Integer value2) {
            addCriterion("so2_min not between", value1, value2, "so2Min");
            return (Criteria) this;
        }

        public Criteria andSo2MaxIsNull() {
            addCriterion("so2_max is null");
            return (Criteria) this;
        }

        public Criteria andSo2MaxIsNotNull() {
            addCriterion("so2_max is not null");
            return (Criteria) this;
        }

        public Criteria andSo2MaxEqualTo(Integer value) {
            addCriterion("so2_max =", value, "so2Max");
            return (Criteria) this;
        }

        public Criteria andSo2MaxNotEqualTo(Integer value) {
            addCriterion("so2_max <>", value, "so2Max");
            return (Criteria) this;
        }

        public Criteria andSo2MaxGreaterThan(Integer value) {
            addCriterion("so2_max >", value, "so2Max");
            return (Criteria) this;
        }

        public Criteria andSo2MaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("so2_max >=", value, "so2Max");
            return (Criteria) this;
        }

        public Criteria andSo2MaxLessThan(Integer value) {
            addCriterion("so2_max <", value, "so2Max");
            return (Criteria) this;
        }

        public Criteria andSo2MaxLessThanOrEqualTo(Integer value) {
            addCriterion("so2_max <=", value, "so2Max");
            return (Criteria) this;
        }

        public Criteria andSo2MaxIn(List<Integer> values) {
            addCriterion("so2_max in", values, "so2Max");
            return (Criteria) this;
        }

        public Criteria andSo2MaxNotIn(List<Integer> values) {
            addCriterion("so2_max not in", values, "so2Max");
            return (Criteria) this;
        }

        public Criteria andSo2MaxBetween(Integer value1, Integer value2) {
            addCriterion("so2_max between", value1, value2, "so2Max");
            return (Criteria) this;
        }

        public Criteria andSo2MaxNotBetween(Integer value1, Integer value2) {
            addCriterion("so2_max not between", value1, value2, "so2Max");
            return (Criteria) this;
        }

        public Criteria andCoMinIsNull() {
            addCriterion("co_min is null");
            return (Criteria) this;
        }

        public Criteria andCoMinIsNotNull() {
            addCriterion("co_min is not null");
            return (Criteria) this;
        }

        public Criteria andCoMinEqualTo(Integer value) {
            addCriterion("co_min =", value, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMinNotEqualTo(Integer value) {
            addCriterion("co_min <>", value, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMinGreaterThan(Integer value) {
            addCriterion("co_min >", value, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("co_min >=", value, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMinLessThan(Integer value) {
            addCriterion("co_min <", value, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMinLessThanOrEqualTo(Integer value) {
            addCriterion("co_min <=", value, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMinIn(List<Integer> values) {
            addCriterion("co_min in", values, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMinNotIn(List<Integer> values) {
            addCriterion("co_min not in", values, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMinBetween(Integer value1, Integer value2) {
            addCriterion("co_min between", value1, value2, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMinNotBetween(Integer value1, Integer value2) {
            addCriterion("co_min not between", value1, value2, "coMin");
            return (Criteria) this;
        }

        public Criteria andCoMaxIsNull() {
            addCriterion("co_max is null");
            return (Criteria) this;
        }

        public Criteria andCoMaxIsNotNull() {
            addCriterion("co_max is not null");
            return (Criteria) this;
        }

        public Criteria andCoMaxEqualTo(Integer value) {
            addCriterion("co_max =", value, "coMax");
            return (Criteria) this;
        }

        public Criteria andCoMaxNotEqualTo(Integer value) {
            addCriterion("co_max <>", value, "coMax");
            return (Criteria) this;
        }

        public Criteria andCoMaxGreaterThan(Integer value) {
            addCriterion("co_max >", value, "coMax");
            return (Criteria) this;
        }

        public Criteria andCoMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("co_max >=", value, "coMax");
            return (Criteria) this;
        }

        public Criteria andCoMaxLessThan(Integer value) {
            addCriterion("co_max <", value, "coMax");
            return (Criteria) this;
        }

        public Criteria andCoMaxLessThanOrEqualTo(Integer value) {
            addCriterion("co_max <=", value, "coMax");
            return (Criteria) this;
        }

        public Criteria andCoMaxIn(List<Integer> values) {
            addCriterion("co_max in", values, "coMax");
            return (Criteria) this;
        }

        public Criteria andCoMaxNotIn(List<Integer> values) {
            addCriterion("co_max not in", values, "coMax");
            return (Criteria) this;
        }

        public Criteria andCoMaxBetween(Integer value1, Integer value2) {
            addCriterion("co_max between", value1, value2, "coMax");
            return (Criteria) this;
        }

        public Criteria andCoMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("co_max not between", value1, value2, "coMax");
            return (Criteria) this;
        }

        public Criteria andSpmMinIsNull() {
            addCriterion("spm_min is null");
            return (Criteria) this;
        }

        public Criteria andSpmMinIsNotNull() {
            addCriterion("spm_min is not null");
            return (Criteria) this;
        }

        public Criteria andSpmMinEqualTo(Integer value) {
            addCriterion("spm_min =", value, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMinNotEqualTo(Integer value) {
            addCriterion("spm_min <>", value, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMinGreaterThan(Integer value) {
            addCriterion("spm_min >", value, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMinGreaterThanOrEqualTo(Integer value) {
            addCriterion("spm_min >=", value, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMinLessThan(Integer value) {
            addCriterion("spm_min <", value, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMinLessThanOrEqualTo(Integer value) {
            addCriterion("spm_min <=", value, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMinIn(List<Integer> values) {
            addCriterion("spm_min in", values, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMinNotIn(List<Integer> values) {
            addCriterion("spm_min not in", values, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMinBetween(Integer value1, Integer value2) {
            addCriterion("spm_min between", value1, value2, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMinNotBetween(Integer value1, Integer value2) {
            addCriterion("spm_min not between", value1, value2, "spmMin");
            return (Criteria) this;
        }

        public Criteria andSpmMaxIsNull() {
            addCriterion("spm_max is null");
            return (Criteria) this;
        }

        public Criteria andSpmMaxIsNotNull() {
            addCriterion("spm_max is not null");
            return (Criteria) this;
        }

        public Criteria andSpmMaxEqualTo(Integer value) {
            addCriterion("spm_max =", value, "spmMax");
            return (Criteria) this;
        }

        public Criteria andSpmMaxNotEqualTo(Integer value) {
            addCriterion("spm_max <>", value, "spmMax");
            return (Criteria) this;
        }

        public Criteria andSpmMaxGreaterThan(Integer value) {
            addCriterion("spm_max >", value, "spmMax");
            return (Criteria) this;
        }

        public Criteria andSpmMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("spm_max >=", value, "spmMax");
            return (Criteria) this;
        }

        public Criteria andSpmMaxLessThan(Integer value) {
            addCriterion("spm_max <", value, "spmMax");
            return (Criteria) this;
        }

        public Criteria andSpmMaxLessThanOrEqualTo(Integer value) {
            addCriterion("spm_max <=", value, "spmMax");
            return (Criteria) this;
        }

        public Criteria andSpmMaxIn(List<Integer> values) {
            addCriterion("spm_max in", values, "spmMax");
            return (Criteria) this;
        }

        public Criteria andSpmMaxNotIn(List<Integer> values) {
            addCriterion("spm_max not in", values, "spmMax");
            return (Criteria) this;
        }

        public Criteria andSpmMaxBetween(Integer value1, Integer value2) {
            addCriterion("spm_max between", value1, value2, "spmMax");
            return (Criteria) this;
        }

        public Criteria andSpmMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("spm_max not between", value1, value2, "spmMax");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}