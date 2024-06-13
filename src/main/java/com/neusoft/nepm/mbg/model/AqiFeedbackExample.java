package com.neusoft.nepm.mbg.model;

import java.util.ArrayList;
import java.util.List;

public class AqiFeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AqiFeedbackExample() {
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

        public Criteria andAfIdIsNull() {
            addCriterion("af_id is null");
            return (Criteria) this;
        }

        public Criteria andAfIdIsNotNull() {
            addCriterion("af_id is not null");
            return (Criteria) this;
        }

        public Criteria andAfIdEqualTo(Integer value) {
            addCriterion("af_id =", value, "afId");
            return (Criteria) this;
        }

        public Criteria andAfIdNotEqualTo(Integer value) {
            addCriterion("af_id <>", value, "afId");
            return (Criteria) this;
        }

        public Criteria andAfIdGreaterThan(Integer value) {
            addCriterion("af_id >", value, "afId");
            return (Criteria) this;
        }

        public Criteria andAfIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("af_id >=", value, "afId");
            return (Criteria) this;
        }

        public Criteria andAfIdLessThan(Integer value) {
            addCriterion("af_id <", value, "afId");
            return (Criteria) this;
        }

        public Criteria andAfIdLessThanOrEqualTo(Integer value) {
            addCriterion("af_id <=", value, "afId");
            return (Criteria) this;
        }

        public Criteria andAfIdIn(List<Integer> values) {
            addCriterion("af_id in", values, "afId");
            return (Criteria) this;
        }

        public Criteria andAfIdNotIn(List<Integer> values) {
            addCriterion("af_id not in", values, "afId");
            return (Criteria) this;
        }

        public Criteria andAfIdBetween(Integer value1, Integer value2) {
            addCriterion("af_id between", value1, value2, "afId");
            return (Criteria) this;
        }

        public Criteria andAfIdNotBetween(Integer value1, Integer value2) {
            addCriterion("af_id not between", value1, value2, "afId");
            return (Criteria) this;
        }

        public Criteria andTelIdIsNull() {
            addCriterion("tel_id is null");
            return (Criteria) this;
        }

        public Criteria andTelIdIsNotNull() {
            addCriterion("tel_id is not null");
            return (Criteria) this;
        }

        public Criteria andTelIdEqualTo(String value) {
            addCriterion("tel_id =", value, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdNotEqualTo(String value) {
            addCriterion("tel_id <>", value, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdGreaterThan(String value) {
            addCriterion("tel_id >", value, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdGreaterThanOrEqualTo(String value) {
            addCriterion("tel_id >=", value, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdLessThan(String value) {
            addCriterion("tel_id <", value, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdLessThanOrEqualTo(String value) {
            addCriterion("tel_id <=", value, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdLike(String value) {
            addCriterion("tel_id like", value, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdNotLike(String value) {
            addCriterion("tel_id not like", value, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdIn(List<String> values) {
            addCriterion("tel_id in", values, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdNotIn(List<String> values) {
            addCriterion("tel_id not in", values, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdBetween(String value1, String value2) {
            addCriterion("tel_id between", value1, value2, "telId");
            return (Criteria) this;
        }

        public Criteria andTelIdNotBetween(String value1, String value2) {
            addCriterion("tel_id not between", value1, value2, "telId");
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

        public Criteria andEstimatedGradeIsNull() {
            addCriterion("estimated_grade is null");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeIsNotNull() {
            addCriterion("estimated_grade is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeEqualTo(Integer value) {
            addCriterion("estimated_grade =", value, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeNotEqualTo(Integer value) {
            addCriterion("estimated_grade <>", value, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeGreaterThan(Integer value) {
            addCriterion("estimated_grade >", value, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("estimated_grade >=", value, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeLessThan(Integer value) {
            addCriterion("estimated_grade <", value, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeLessThanOrEqualTo(Integer value) {
            addCriterion("estimated_grade <=", value, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeIn(List<Integer> values) {
            addCriterion("estimated_grade in", values, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeNotIn(List<Integer> values) {
            addCriterion("estimated_grade not in", values, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeBetween(Integer value1, Integer value2) {
            addCriterion("estimated_grade between", value1, value2, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andEstimatedGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("estimated_grade not between", value1, value2, "estimatedGrade");
            return (Criteria) this;
        }

        public Criteria andAfDateIsNull() {
            addCriterion("af_date is null");
            return (Criteria) this;
        }

        public Criteria andAfDateIsNotNull() {
            addCriterion("af_date is not null");
            return (Criteria) this;
        }

        public Criteria andAfDateEqualTo(String value) {
            addCriterion("af_date =", value, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateNotEqualTo(String value) {
            addCriterion("af_date <>", value, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateGreaterThan(String value) {
            addCriterion("af_date >", value, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateGreaterThanOrEqualTo(String value) {
            addCriterion("af_date >=", value, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateLessThan(String value) {
            addCriterion("af_date <", value, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateLessThanOrEqualTo(String value) {
            addCriterion("af_date <=", value, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateLike(String value) {
            addCriterion("af_date like", value, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateNotLike(String value) {
            addCriterion("af_date not like", value, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateIn(List<String> values) {
            addCriterion("af_date in", values, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateNotIn(List<String> values) {
            addCriterion("af_date not in", values, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateBetween(String value1, String value2) {
            addCriterion("af_date between", value1, value2, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfDateNotBetween(String value1, String value2) {
            addCriterion("af_date not between", value1, value2, "afDate");
            return (Criteria) this;
        }

        public Criteria andAfTimeIsNull() {
            addCriterion("af_time is null");
            return (Criteria) this;
        }

        public Criteria andAfTimeIsNotNull() {
            addCriterion("af_time is not null");
            return (Criteria) this;
        }

        public Criteria andAfTimeEqualTo(String value) {
            addCriterion("af_time =", value, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeNotEqualTo(String value) {
            addCriterion("af_time <>", value, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeGreaterThan(String value) {
            addCriterion("af_time >", value, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeGreaterThanOrEqualTo(String value) {
            addCriterion("af_time >=", value, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeLessThan(String value) {
            addCriterion("af_time <", value, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeLessThanOrEqualTo(String value) {
            addCriterion("af_time <=", value, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeLike(String value) {
            addCriterion("af_time like", value, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeNotLike(String value) {
            addCriterion("af_time not like", value, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeIn(List<String> values) {
            addCriterion("af_time in", values, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeNotIn(List<String> values) {
            addCriterion("af_time not in", values, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeBetween(String value1, String value2) {
            addCriterion("af_time between", value1, value2, "afTime");
            return (Criteria) this;
        }

        public Criteria andAfTimeNotBetween(String value1, String value2) {
            addCriterion("af_time not between", value1, value2, "afTime");
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

        public Criteria andAssignDateIsNull() {
            addCriterion("assign_date is null");
            return (Criteria) this;
        }

        public Criteria andAssignDateIsNotNull() {
            addCriterion("assign_date is not null");
            return (Criteria) this;
        }

        public Criteria andAssignDateEqualTo(String value) {
            addCriterion("assign_date =", value, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateNotEqualTo(String value) {
            addCriterion("assign_date <>", value, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateGreaterThan(String value) {
            addCriterion("assign_date >", value, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateGreaterThanOrEqualTo(String value) {
            addCriterion("assign_date >=", value, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateLessThan(String value) {
            addCriterion("assign_date <", value, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateLessThanOrEqualTo(String value) {
            addCriterion("assign_date <=", value, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateLike(String value) {
            addCriterion("assign_date like", value, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateNotLike(String value) {
            addCriterion("assign_date not like", value, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateIn(List<String> values) {
            addCriterion("assign_date in", values, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateNotIn(List<String> values) {
            addCriterion("assign_date not in", values, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateBetween(String value1, String value2) {
            addCriterion("assign_date between", value1, value2, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignDateNotBetween(String value1, String value2) {
            addCriterion("assign_date not between", value1, value2, "assignDate");
            return (Criteria) this;
        }

        public Criteria andAssignTimeIsNull() {
            addCriterion("assign_time is null");
            return (Criteria) this;
        }

        public Criteria andAssignTimeIsNotNull() {
            addCriterion("assign_time is not null");
            return (Criteria) this;
        }

        public Criteria andAssignTimeEqualTo(String value) {
            addCriterion("assign_time =", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotEqualTo(String value) {
            addCriterion("assign_time <>", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeGreaterThan(String value) {
            addCriterion("assign_time >", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeGreaterThanOrEqualTo(String value) {
            addCriterion("assign_time >=", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeLessThan(String value) {
            addCriterion("assign_time <", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeLessThanOrEqualTo(String value) {
            addCriterion("assign_time <=", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeLike(String value) {
            addCriterion("assign_time like", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotLike(String value) {
            addCriterion("assign_time not like", value, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeIn(List<String> values) {
            addCriterion("assign_time in", values, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotIn(List<String> values) {
            addCriterion("assign_time not in", values, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeBetween(String value1, String value2) {
            addCriterion("assign_time between", value1, value2, "assignTime");
            return (Criteria) this;
        }

        public Criteria andAssignTimeNotBetween(String value1, String value2) {
            addCriterion("assign_time not between", value1, value2, "assignTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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