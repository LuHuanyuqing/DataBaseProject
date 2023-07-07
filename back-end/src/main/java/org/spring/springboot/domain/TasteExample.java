package org.spring.springboot.domain;

import java.util.ArrayList;
import java.util.List;

public class TasteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TasteExample() {
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

        public Criteria andWaterdropIsNull() {
            addCriterion("waterdrop is null");
            return (Criteria) this;
        }

        public Criteria andWaterdropIsNotNull() {
            addCriterion("waterdrop is not null");
            return (Criteria) this;
        }

        public Criteria andWaterdropEqualTo(String value) {
            addCriterion("waterdrop =", value, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropNotEqualTo(String value) {
            addCriterion("waterdrop <>", value, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropGreaterThan(String value) {
            addCriterion("waterdrop >", value, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropGreaterThanOrEqualTo(String value) {
            addCriterion("waterdrop >=", value, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropLessThan(String value) {
            addCriterion("waterdrop <", value, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropLessThanOrEqualTo(String value) {
            addCriterion("waterdrop <=", value, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropLike(String value) {
            addCriterion("waterdrop like", value, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropNotLike(String value) {
            addCriterion("waterdrop not like", value, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropIn(List<String> values) {
            addCriterion("waterdrop in", values, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropNotIn(List<String> values) {
            addCriterion("waterdrop not in", values, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropBetween(String value1, String value2) {
            addCriterion("waterdrop between", value1, value2, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropNotBetween(String value1, String value2) {
            addCriterion("waterdrop not between", value1, value2, "waterdrop");
            return (Criteria) this;
        }

        public Criteria andWaterdropidIsNull() {
            addCriterion("waterdropid is null");
            return (Criteria) this;
        }

        public Criteria andWaterdropidIsNotNull() {
            addCriterion("waterdropid is not null");
            return (Criteria) this;
        }

        public Criteria andWaterdropidEqualTo(Integer value) {
            addCriterion("waterdropid =", value, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andWaterdropidNotEqualTo(Integer value) {
            addCriterion("waterdropid <>", value, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andWaterdropidGreaterThan(Integer value) {
            addCriterion("waterdropid >", value, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andWaterdropidGreaterThanOrEqualTo(Integer value) {
            addCriterion("waterdropid >=", value, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andWaterdropidLessThan(Integer value) {
            addCriterion("waterdropid <", value, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andWaterdropidLessThanOrEqualTo(Integer value) {
            addCriterion("waterdropid <=", value, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andWaterdropidIn(List<Integer> values) {
            addCriterion("waterdropid in", values, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andWaterdropidNotIn(List<Integer> values) {
            addCriterion("waterdropid not in", values, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andWaterdropidBetween(Integer value1, Integer value2) {
            addCriterion("waterdropid between", value1, value2, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andWaterdropidNotBetween(Integer value1, Integer value2) {
            addCriterion("waterdropid not between", value1, value2, "waterdropid");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFortIsNull() {
            addCriterion("fort is null");
            return (Criteria) this;
        }

        public Criteria andFortIsNotNull() {
            addCriterion("fort is not null");
            return (Criteria) this;
        }

        public Criteria andFortEqualTo(String value) {
            addCriterion("fort =", value, "fort");
            return (Criteria) this;
        }

        public Criteria andFortNotEqualTo(String value) {
            addCriterion("fort <>", value, "fort");
            return (Criteria) this;
        }

        public Criteria andFortGreaterThan(String value) {
            addCriterion("fort >", value, "fort");
            return (Criteria) this;
        }

        public Criteria andFortGreaterThanOrEqualTo(String value) {
            addCriterion("fort >=", value, "fort");
            return (Criteria) this;
        }

        public Criteria andFortLessThan(String value) {
            addCriterion("fort <", value, "fort");
            return (Criteria) this;
        }

        public Criteria andFortLessThanOrEqualTo(String value) {
            addCriterion("fort <=", value, "fort");
            return (Criteria) this;
        }

        public Criteria andFortLike(String value) {
            addCriterion("fort like", value, "fort");
            return (Criteria) this;
        }

        public Criteria andFortNotLike(String value) {
            addCriterion("fort not like", value, "fort");
            return (Criteria) this;
        }

        public Criteria andFortIn(List<String> values) {
            addCriterion("fort in", values, "fort");
            return (Criteria) this;
        }

        public Criteria andFortNotIn(List<String> values) {
            addCriterion("fort not in", values, "fort");
            return (Criteria) this;
        }

        public Criteria andFortBetween(String value1, String value2) {
            addCriterion("fort between", value1, value2, "fort");
            return (Criteria) this;
        }

        public Criteria andFortNotBetween(String value1, String value2) {
            addCriterion("fort not between", value1, value2, "fort");
            return (Criteria) this;
        }

        public Criteria andFortidIsNull() {
            addCriterion("fortid is null");
            return (Criteria) this;
        }

        public Criteria andFortidIsNotNull() {
            addCriterion("fortid is not null");
            return (Criteria) this;
        }

        public Criteria andFortidEqualTo(Integer value) {
            addCriterion("fortid =", value, "fortid");
            return (Criteria) this;
        }

        public Criteria andFortidNotEqualTo(Integer value) {
            addCriterion("fortid <>", value, "fortid");
            return (Criteria) this;
        }

        public Criteria andFortidGreaterThan(Integer value) {
            addCriterion("fortid >", value, "fortid");
            return (Criteria) this;
        }

        public Criteria andFortidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fortid >=", value, "fortid");
            return (Criteria) this;
        }

        public Criteria andFortidLessThan(Integer value) {
            addCriterion("fortid <", value, "fortid");
            return (Criteria) this;
        }

        public Criteria andFortidLessThanOrEqualTo(Integer value) {
            addCriterion("fortid <=", value, "fortid");
            return (Criteria) this;
        }

        public Criteria andFortidIn(List<Integer> values) {
            addCriterion("fortid in", values, "fortid");
            return (Criteria) this;
        }

        public Criteria andFortidNotIn(List<Integer> values) {
            addCriterion("fortid not in", values, "fortid");
            return (Criteria) this;
        }

        public Criteria andFortidBetween(Integer value1, Integer value2) {
            addCriterion("fortid between", value1, value2, "fortid");
            return (Criteria) this;
        }

        public Criteria andFortidNotBetween(Integer value1, Integer value2) {
            addCriterion("fortid not between", value1, value2, "fortid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createtime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createtime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updatetime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updatetime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
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