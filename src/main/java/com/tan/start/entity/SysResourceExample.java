package com.tan.start.entity;

import java.util.ArrayList;
import java.util.List;

public class SysResourceExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public SysResourceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
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
            addCriterion("sys_resource.id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("sys_resource.id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("sys_resource.id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("sys_resource.id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("sys_resource.id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sys_resource.id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("sys_resource.id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("sys_resource.id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("sys_resource.id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("sys_resource.id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("sys_resource.id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("sys_resource.id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("sys_resource.value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("sys_resource.value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("sys_resource.value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("sys_resource.value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("sys_resource.value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("sys_resource.value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("sys_resource.value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("sys_resource.value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("sys_resource.value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("sys_resource.value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("sys_resource.value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("sys_resource.value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("sys_resource.value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("sys_resource.value not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("sys_resource.name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("sys_resource.name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("sys_resource.name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("sys_resource.name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("sys_resource.name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("sys_resource.name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("sys_resource.name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("sys_resource.name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("sys_resource.name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("sys_resource.name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("sys_resource.name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("sys_resource.name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("sys_resource.name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("sys_resource.name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("sys_resource.type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("sys_resource.type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("sys_resource.type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("sys_resource.type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("sys_resource.type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sys_resource.type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("sys_resource.type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("sys_resource.type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("sys_resource.type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("sys_resource.type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("sys_resource.type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("sys_resource.type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("sys_resource.type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("sys_resource.type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("sys_resource.level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("sys_resource.level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("sys_resource.level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("sys_resource.level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("sys_resource.level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("sys_resource.level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("sys_resource.level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("sys_resource.level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("sys_resource.level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("sys_resource.level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("sys_resource.level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("sys_resource.level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("sys_resource.level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("sys_resource.level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andParentIsNull() {
            addCriterion("sys_resource.parent is null");
            return (Criteria) this;
        }

        public Criteria andParentIsNotNull() {
            addCriterion("sys_resource.parent is not null");
            return (Criteria) this;
        }

        public Criteria andParentEqualTo(String value) {
            addCriterion("sys_resource.parent =", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotEqualTo(String value) {
            addCriterion("sys_resource.parent <>", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThan(String value) {
            addCriterion("sys_resource.parent >", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentGreaterThanOrEqualTo(String value) {
            addCriterion("sys_resource.parent >=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThan(String value) {
            addCriterion("sys_resource.parent <", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLessThanOrEqualTo(String value) {
            addCriterion("sys_resource.parent <=", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentLike(String value) {
            addCriterion("sys_resource.parent like", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotLike(String value) {
            addCriterion("sys_resource.parent not like", value, "parent");
            return (Criteria) this;
        }

        public Criteria andParentIn(List<String> values) {
            addCriterion("sys_resource.parent in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotIn(List<String> values) {
            addCriterion("sys_resource.parent not in", values, "parent");
            return (Criteria) this;
        }

        public Criteria andParentBetween(String value1, String value2) {
            addCriterion("sys_resource.parent between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andParentNotBetween(String value1, String value2) {
            addCriterion("sys_resource.parent not between", value1, value2, "parent");
            return (Criteria) this;
        }

        public Criteria andClassesIsNull() {
            addCriterion("sys_resource.classes is null");
            return (Criteria) this;
        }

        public Criteria andClassesIsNotNull() {
            addCriterion("sys_resource.classes is not null");
            return (Criteria) this;
        }

        public Criteria andClassesEqualTo(String value) {
            addCriterion("sys_resource.classes =", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesNotEqualTo(String value) {
            addCriterion("sys_resource.classes <>", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesGreaterThan(String value) {
            addCriterion("sys_resource.classes >", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesGreaterThanOrEqualTo(String value) {
            addCriterion("sys_resource.classes >=", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesLessThan(String value) {
            addCriterion("sys_resource.classes <", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesLessThanOrEqualTo(String value) {
            addCriterion("sys_resource.classes <=", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesLike(String value) {
            addCriterion("sys_resource.classes like", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesNotLike(String value) {
            addCriterion("sys_resource.classes not like", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesIn(List<String> values) {
            addCriterion("sys_resource.classes in", values, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesNotIn(List<String> values) {
            addCriterion("sys_resource.classes not in", values, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesBetween(String value1, String value2) {
            addCriterion("sys_resource.classes between", value1, value2, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesNotBetween(String value1, String value2) {
            addCriterion("sys_resource.classes not between", value1, value2, "classes");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("sys_resource.priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("sys_resource.priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("sys_resource.priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("sys_resource.priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("sys_resource.priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_resource.priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("sys_resource.priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("sys_resource.priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("sys_resource.priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("sys_resource.priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("sys_resource.priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_resource.priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("sys_resource.state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("sys_resource.state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("sys_resource.state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("sys_resource.state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("sys_resource.state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_resource.state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("sys_resource.state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("sys_resource.state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("sys_resource.state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("sys_resource.state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("sys_resource.state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_resource.state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_resource
     *
     * @mbg.generated do_not_delete_during_merge Fri Jul 12 21:30:54 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_resource
     *
     * @mbg.generated Fri Jul 12 21:30:54 CST 2019
     */
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