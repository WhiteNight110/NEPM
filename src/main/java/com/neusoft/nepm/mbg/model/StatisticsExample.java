package com.neusoft.nepm.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class StatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticsExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andSo2ValueIsNull() {
            addCriterion("so2_value is null");
            return (Criteria) this;
        }

        public Criteria andSo2ValueIsNotNull() {
            addCriterion("so2_value is not null");
            return (Criteria) this;
        }

        public Criteria andSo2ValueEqualTo(Integer value) {
            addCriterion("so2_value =", value, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2ValueNotEqualTo(Integer value) {
            addCriterion("so2_value <>", value, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2ValueGreaterThan(Integer value) {
            addCriterion("so2_value >", value, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2ValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("so2_value >=", value, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2ValueLessThan(Integer value) {
            addCriterion("so2_value <", value, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2ValueLessThanOrEqualTo(Integer value) {
            addCriterion("so2_value <=", value, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2ValueIn(List<Integer> values) {
            addCriterion("so2_value in", values, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2ValueNotIn(List<Integer> values) {
            addCriterion("so2_value not in", values, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2ValueBetween(Integer value1, Integer value2) {
            addCriterion("so2_value between", value1, value2, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2ValueNotBetween(Integer value1, Integer value2) {
            addCriterion("so2_value not between", value1, value2, "so2Value");
            return (Criteria) this;
        }

        public Criteria andSo2LevelIsNull() {
            addCriterion("so2_level is null");
            return (Criteria) this;
        }

        public Criteria andSo2LevelIsNotNull() {
            addCriterion("so2_level is not null");
            return (Criteria) this;
        }

        public Criteria andSo2LevelEqualTo(Integer value) {
            addCriterion("so2_level =", value, "so2Level");
            return (Criteria) this;
        }

        public Criteria andSo2LevelNotEqualTo(Integer value) {
            addCriterion("so2_level <>", value, "so2Level");
            return (Criteria) this;
        }

        public Criteria andSo2LevelGreaterThan(Integer value) {
            addCriterion("so2_level >", value, "so2Level");
            return (Criteria) this;
        }

        public Criteria andSo2LevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("so2_level >=", value, "so2Level");
            return (Criteria) this;
        }

        public Criteria andSo2LevelLessThan(Integer value) {
            addCriterion("so2_level <", value, "so2Level");
            return (Criteria) this;
        }

        public Criteria andSo2LevelLessThanOrEqualTo(Integer value) {
            addCriterion("so2_level <=", value, "so2Level");
            return (Criteria) this;
        }

        public Criteria andSo2LevelIn(List<Integer> values) {
            addCriterion("so2_level in", values, "so2Level");
            return (Criteria) this;
        }

        public Criteria andSo2LevelNotIn(List<Integer> values) {
            addCriterion("so2_level not in", values, "so2Level");
            return (Criteria) this;
        }

        public Criteria andSo2LevelBetween(Integer value1, Integer value2) {
            addCriterion("so2_level between", value1, value2, "so2Level");
            return (Criteria) this;
        }

        public Criteria andSo2LevelNotBetween(Integer value1, Integer value2) {
            addCriterion("so2_level not between", value1, value2, "so2Level");
            return (Criteria) this;
        }

        public Criteria andCoValueIsNull() {
            addCriterion("co_value is null");
            return (Criteria) this;
        }

        public Criteria andCoValueIsNotNull() {
            addCriterion("co_value is not null");
            return (Criteria) this;
        }

        public Criteria andCoValueEqualTo(Integer value) {
            addCriterion("co_value =", value, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoValueNotEqualTo(Integer value) {
            addCriterion("co_value <>", value, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoValueGreaterThan(Integer value) {
            addCriterion("co_value >", value, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("co_value >=", value, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoValueLessThan(Integer value) {
            addCriterion("co_value <", value, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoValueLessThanOrEqualTo(Integer value) {
            addCriterion("co_value <=", value, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoValueIn(List<Integer> values) {
            addCriterion("co_value in", values, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoValueNotIn(List<Integer> values) {
            addCriterion("co_value not in", values, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoValueBetween(Integer value1, Integer value2) {
            addCriterion("co_value between", value1, value2, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoValueNotBetween(Integer value1, Integer value2) {
            addCriterion("co_value not between", value1, value2, "coValue");
            return (Criteria) this;
        }

        public Criteria andCoLevelIsNull() {
            addCriterion("co_level is null");
            return (Criteria) this;
        }

        public Criteria andCoLevelIsNotNull() {
            addCriterion("co_level is not null");
            return (Criteria) this;
        }

        public Criteria andCoLevelEqualTo(Integer value) {
            addCriterion("co_level =", value, "coLevel");
            return (Criteria) this;
        }

        public Criteria andCoLevelNotEqualTo(Integer value) {
            addCriterion("co_level <>", value, "coLevel");
            return (Criteria) this;
        }

        public Criteria andCoLevelGreaterThan(Integer value) {
            addCriterion("co_level >", value, "coLevel");
            return (Criteria) this;
        }

        public Criteria andCoLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("co_level >=", value, "coLevel");
            return (Criteria) this;
        }

        public Criteria andCoLevelLessThan(Integer value) {
            addCriterion("co_level <", value, "coLevel");
            return (Criteria) this;
        }

        public Criteria andCoLevelLessThanOrEqualTo(Integer value) {
            addCriterion("co_level <=", value, "coLevel");
            return (Criteria) this;
        }

        public Criteria andCoLevelIn(List<Integer> values) {
            addCriterion("co_level in", values, "coLevel");
            return (Criteria) this;
        }

        public Criteria andCoLevelNotIn(List<Integer> values) {
            addCriterion("co_level not in", values, "coLevel");
            return (Criteria) this;
        }

        public Criteria andCoLevelBetween(Integer value1, Integer value2) {
            addCriterion("co_level between", value1, value2, "coLevel");
            return (Criteria) this;
        }

        public Criteria andCoLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("co_level not between", value1, value2, "coLevel");
            return (Criteria) this;
        }

        public Criteria andSpmValueIsNull() {
            addCriterion("spm_value is null");
            return (Criteria) this;
        }

        public Criteria andSpmValueIsNotNull() {
            addCriterion("spm_value is not null");
            return (Criteria) this;
        }

        public Criteria andSpmValueEqualTo(Integer value) {
            addCriterion("spm_value =", value, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmValueNotEqualTo(Integer value) {
            addCriterion("spm_value <>", value, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmValueGreaterThan(Integer value) {
            addCriterion("spm_value >", value, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("spm_value >=", value, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmValueLessThan(Integer value) {
            addCriterion("spm_value <", value, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmValueLessThanOrEqualTo(Integer value) {
            addCriterion("spm_value <=", value, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmValueIn(List<Integer> values) {
            addCriterion("spm_value in", values, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmValueNotIn(List<Integer> values) {
            addCriterion("spm_value not in", values, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmValueBetween(Integer value1, Integer value2) {
            addCriterion("spm_value between", value1, value2, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmValueNotBetween(Integer value1, Integer value2) {
            addCriterion("spm_value not between", value1, value2, "spmValue");
            return (Criteria) this;
        }

        public Criteria andSpmLevelIsNull() {
            addCriterion("spm_level is null");
            return (Criteria) this;
        }

        public Criteria andSpmLevelIsNotNull() {
            addCriterion("spm_level is not null");
            return (Criteria) this;
        }

        public Criteria andSpmLevelEqualTo(Integer value) {
            addCriterion("spm_level =", value, "spmLevel");
            return (Criteria) this;
        }

        public Criteria andSpmLevelNotEqualTo(Integer value) {
            addCriterion("spm_level <>", value, "spmLevel");
            return (Criteria) this;
        }

        public Criteria andSpmLevelGreaterThan(Integer value) {
            addCriterion("spm_level >", value, "spmLevel");
            return (Criteria) this;
        }

        public Criteria andSpmLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("spm_level >=", value, "spmLevel");
            return (Criteria) this;
        }

        public Criteria andSpmLevelLessThan(Integer value) {
            addCriterion("spm_level <", value, "spmLevel");
            return (Criteria) this;
        }

        public Criteria andSpmLevelLessThanOrEqualTo(Integer value) {
            addCriterion("spm_level <=", value, "spmLevel");
            return (Criteria) this;
        }

        public Criteria andSpmLevelIn(List<Integer> values) {
            addCriterion("spm_level in", values, "spmLevel");
            return (Criteria) this;
        }

        public Criteria andSpmLevelNotIn(List<Integer> values) {
            addCriterion("spm_level not in", values, "spmLevel");
            return (Criteria) this;
        }

        public Criteria andSpmLevelBetween(Integer value1, Integer value2) {
            addCriterion("spm_level between", value1, value2, "spmLevel");
            return (Criteria) this;
        }

        public Criteria andSpmLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("spm_level not between", value1, value2, "spmLevel");
            return (Criteria) this;
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

        public Criteria andConfirmDateIsNull() {
            addCriterion("confirm_date is null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIsNotNull() {
            addCriterion("confirm_date is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmDateEqualTo(String value) {
            addCriterion("confirm_date =", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotEqualTo(String value) {
            addCriterion("confirm_date <>", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThan(String value) {
            addCriterion("confirm_date >", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_date >=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThan(String value) {
            addCriterion("confirm_date <", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLessThanOrEqualTo(String value) {
            addCriterion("confirm_date <=", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateLike(String value) {
            addCriterion("confirm_date like", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotLike(String value) {
            addCriterion("confirm_date not like", value, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateIn(List<String> values) {
            addCriterion("confirm_date in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotIn(List<String> values) {
            addCriterion("confirm_date not in", values, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateBetween(String value1, String value2) {
            addCriterion("confirm_date between", value1, value2, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmDateNotBetween(String value1, String value2) {
            addCriterion("confirm_date not between", value1, value2, "confirmDate");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNull() {
            addCriterion("confirm_time is null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIsNotNull() {
            addCriterion("confirm_time is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeEqualTo(String value) {
            addCriterion("confirm_time =", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotEqualTo(String value) {
            addCriterion("confirm_time <>", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThan(String value) {
            addCriterion("confirm_time >", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_time >=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThan(String value) {
            addCriterion("confirm_time <", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLessThanOrEqualTo(String value) {
            addCriterion("confirm_time <=", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeLike(String value) {
            addCriterion("confirm_time like", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotLike(String value) {
            addCriterion("confirm_time not like", value, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeIn(List<String> values) {
            addCriterion("confirm_time in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotIn(List<String> values) {
            addCriterion("confirm_time not in", values, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeBetween(String value1, String value2) {
            addCriterion("confirm_time between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andConfirmTimeNotBetween(String value1, String value2) {
            addCriterion("confirm_time not between", value1, value2, "confirmTime");
            return (Criteria) this;
        }

        public Criteria andGmIdIsNull() {
            addCriterion("gm_id is null");
            return (Criteria) this;
        }

        public Criteria andGmIdIsNotNull() {
            addCriterion("gm_id is not null");
            return (Criteria) this;
        }

        public Criteria andGmIdEqualTo(Integer value) {
            addCriterion("gm_id =", value, "gmId");
            return (Criteria) this;
        }

        public Criteria andGmIdNotEqualTo(Integer value) {
            addCriterion("gm_id <>", value, "gmId");
            return (Criteria) this;
        }

        public Criteria andGmIdGreaterThan(Integer value) {
            addCriterion("gm_id >", value, "gmId");
            return (Criteria) this;
        }

        public Criteria andGmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gm_id >=", value, "gmId");
            return (Criteria) this;
        }

        public Criteria andGmIdLessThan(Integer value) {
            addCriterion("gm_id <", value, "gmId");
            return (Criteria) this;
        }

        public Criteria andGmIdLessThanOrEqualTo(Integer value) {
            addCriterion("gm_id <=", value, "gmId");
            return (Criteria) this;
        }

        public Criteria andGmIdIn(List<Integer> values) {
            addCriterion("gm_id in", values, "gmId");
            return (Criteria) this;
        }

        public Criteria andGmIdNotIn(List<Integer> values) {
            addCriterion("gm_id not in", values, "gmId");
            return (Criteria) this;
        }

        public Criteria andGmIdBetween(Integer value1, Integer value2) {
            addCriterion("gm_id between", value1, value2, "gmId");
            return (Criteria) this;
        }

        public Criteria andGmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gm_id not between", value1, value2, "gmId");
            return (Criteria) this;
        }

        public Criteria andFdIdIsNull() {
            addCriterion("fd_id is null");
            return (Criteria) this;
        }

        public Criteria andFdIdIsNotNull() {
            addCriterion("fd_id is not null");
            return (Criteria) this;
        }

        public Criteria andFdIdEqualTo(String value) {
            addCriterion("fd_id =", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotEqualTo(String value) {
            addCriterion("fd_id <>", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdGreaterThan(String value) {
            addCriterion("fd_id >", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdGreaterThanOrEqualTo(String value) {
            addCriterion("fd_id >=", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdLessThan(String value) {
            addCriterion("fd_id <", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdLessThanOrEqualTo(String value) {
            addCriterion("fd_id <=", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdLike(String value) {
            addCriterion("fd_id like", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotLike(String value) {
            addCriterion("fd_id not like", value, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdIn(List<String> values) {
            addCriterion("fd_id in", values, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotIn(List<String> values) {
            addCriterion("fd_id not in", values, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdBetween(String value1, String value2) {
            addCriterion("fd_id between", value1, value2, "fdId");
            return (Criteria) this;
        }

        public Criteria andFdIdNotBetween(String value1, String value2) {
            addCriterion("fd_id not between", value1, value2, "fdId");
            return (Criteria) this;
        }

        public Criteria andInformationIsNull() {
            addCriterion("information is null");
            return (Criteria) this;
        }

        public Criteria andInformationIsNotNull() {
            addCriterion("information is not null");
            return (Criteria) this;
        }

        public Criteria andInformationEqualTo(String value) {
            addCriterion("information =", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotEqualTo(String value) {
            addCriterion("information <>", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationGreaterThan(String value) {
            addCriterion("information >", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationGreaterThanOrEqualTo(String value) {
            addCriterion("information >=", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLessThan(String value) {
            addCriterion("information <", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLessThanOrEqualTo(String value) {
            addCriterion("information <=", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationLike(String value) {
            addCriterion("information like", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotLike(String value) {
            addCriterion("information not like", value, "information");
            return (Criteria) this;
        }

        public Criteria andInformationIn(List<String> values) {
            addCriterion("information in", values, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotIn(List<String> values) {
            addCriterion("information not in", values, "information");
            return (Criteria) this;
        }

        public Criteria andInformationBetween(String value1, String value2) {
            addCriterion("information between", value1, value2, "information");
            return (Criteria) this;
        }

        public Criteria andInformationNotBetween(String value1, String value2) {
            addCriterion("information not between", value1, value2, "information");
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