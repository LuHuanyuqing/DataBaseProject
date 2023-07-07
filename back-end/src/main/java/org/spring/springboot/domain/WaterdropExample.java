package org.spring.springboot.domain;

import java.util.ArrayList;
import java.util.List;

public class WaterdropExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaterdropExample() {
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

        public Criteria andImageeIsNull() {
            addCriterion("imagee is null");
            return (Criteria) this;
        }

        public Criteria andImageeIsNotNull() {
            addCriterion("imagee is not null");
            return (Criteria) this;
        }

        public Criteria andImageeEqualTo(String value) {
            addCriterion("imagee =", value, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeNotEqualTo(String value) {
            addCriterion("imagee <>", value, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeGreaterThan(String value) {
            addCriterion("imagee >", value, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeGreaterThanOrEqualTo(String value) {
            addCriterion("imagee >=", value, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeLessThan(String value) {
            addCriterion("imagee <", value, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeLessThanOrEqualTo(String value) {
            addCriterion("imagee <=", value, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeLike(String value) {
            addCriterion("imagee like", value, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeNotLike(String value) {
            addCriterion("imagee not like", value, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeIn(List<String> values) {
            addCriterion("imagee in", values, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeNotIn(List<String> values) {
            addCriterion("imagee not in", values, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeBetween(String value1, String value2) {
            addCriterion("imagee between", value1, value2, "imagee");
            return (Criteria) this;
        }

        public Criteria andImageeNotBetween(String value1, String value2) {
            addCriterion("imagee not between", value1, value2, "imagee");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(String value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(String value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(String value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(String value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(String value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(String value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLike(String value) {
            addCriterion("gender like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotLike(String value) {
            addCriterion("gender not like", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<String> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<String> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(String value1, String value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(String value1, String value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andFatherIsNull() {
            addCriterion("father is null");
            return (Criteria) this;
        }

        public Criteria andFatherIsNotNull() {
            addCriterion("father is not null");
            return (Criteria) this;
        }

        public Criteria andFatherEqualTo(String value) {
            addCriterion("father =", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherNotEqualTo(String value) {
            addCriterion("father <>", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherGreaterThan(String value) {
            addCriterion("father >", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherGreaterThanOrEqualTo(String value) {
            addCriterion("father >=", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherLessThan(String value) {
            addCriterion("father <", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherLessThanOrEqualTo(String value) {
            addCriterion("father <=", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherLike(String value) {
            addCriterion("father like", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherNotLike(String value) {
            addCriterion("father not like", value, "father");
            return (Criteria) this;
        }

        public Criteria andFatherIn(List<String> values) {
            addCriterion("father in", values, "father");
            return (Criteria) this;
        }

        public Criteria andFatherNotIn(List<String> values) {
            addCriterion("father not in", values, "father");
            return (Criteria) this;
        }

        public Criteria andFatherBetween(String value1, String value2) {
            addCriterion("father between", value1, value2, "father");
            return (Criteria) this;
        }

        public Criteria andFatherNotBetween(String value1, String value2) {
            addCriterion("father not between", value1, value2, "father");
            return (Criteria) this;
        }

        public Criteria andFatheridIsNull() {
            addCriterion("fatherid is null");
            return (Criteria) this;
        }

        public Criteria andFatheridIsNotNull() {
            addCriterion("fatherid is not null");
            return (Criteria) this;
        }

        public Criteria andFatheridEqualTo(Integer value) {
            addCriterion("fatherid =", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotEqualTo(Integer value) {
            addCriterion("fatherid <>", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThan(Integer value) {
            addCriterion("fatherid >", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fatherid >=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThan(Integer value) {
            addCriterion("fatherid <", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThanOrEqualTo(Integer value) {
            addCriterion("fatherid <=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridIn(List<Integer> values) {
            addCriterion("fatherid in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotIn(List<Integer> values) {
            addCriterion("fatherid not in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridBetween(Integer value1, Integer value2) {
            addCriterion("fatherid between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotBetween(Integer value1, Integer value2) {
            addCriterion("fatherid not between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andMotherIsNull() {
            addCriterion("mother is null");
            return (Criteria) this;
        }

        public Criteria andMotherIsNotNull() {
            addCriterion("mother is not null");
            return (Criteria) this;
        }

        public Criteria andMotherEqualTo(String value) {
            addCriterion("mother =", value, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherNotEqualTo(String value) {
            addCriterion("mother <>", value, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherGreaterThan(String value) {
            addCriterion("mother >", value, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherGreaterThanOrEqualTo(String value) {
            addCriterion("mother >=", value, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherLessThan(String value) {
            addCriterion("mother <", value, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherLessThanOrEqualTo(String value) {
            addCriterion("mother <=", value, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherLike(String value) {
            addCriterion("mother like", value, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherNotLike(String value) {
            addCriterion("mother not like", value, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherIn(List<String> values) {
            addCriterion("mother in", values, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherNotIn(List<String> values) {
            addCriterion("mother not in", values, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherBetween(String value1, String value2) {
            addCriterion("mother between", value1, value2, "mother");
            return (Criteria) this;
        }

        public Criteria andMotherNotBetween(String value1, String value2) {
            addCriterion("mother not between", value1, value2, "mother");
            return (Criteria) this;
        }

        public Criteria andMotheridIsNull() {
            addCriterion("motherid is null");
            return (Criteria) this;
        }

        public Criteria andMotheridIsNotNull() {
            addCriterion("motherid is not null");
            return (Criteria) this;
        }

        public Criteria andMotheridEqualTo(Integer value) {
            addCriterion("motherid =", value, "motherid");
            return (Criteria) this;
        }

        public Criteria andMotheridNotEqualTo(Integer value) {
            addCriterion("motherid <>", value, "motherid");
            return (Criteria) this;
        }

        public Criteria andMotheridGreaterThan(Integer value) {
            addCriterion("motherid >", value, "motherid");
            return (Criteria) this;
        }

        public Criteria andMotheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("motherid >=", value, "motherid");
            return (Criteria) this;
        }

        public Criteria andMotheridLessThan(Integer value) {
            addCriterion("motherid <", value, "motherid");
            return (Criteria) this;
        }

        public Criteria andMotheridLessThanOrEqualTo(Integer value) {
            addCriterion("motherid <=", value, "motherid");
            return (Criteria) this;
        }

        public Criteria andMotheridIn(List<Integer> values) {
            addCriterion("motherid in", values, "motherid");
            return (Criteria) this;
        }

        public Criteria andMotheridNotIn(List<Integer> values) {
            addCriterion("motherid not in", values, "motherid");
            return (Criteria) this;
        }

        public Criteria andMotheridBetween(Integer value1, Integer value2) {
            addCriterion("motherid between", value1, value2, "motherid");
            return (Criteria) this;
        }

        public Criteria andMotheridNotBetween(Integer value1, Integer value2) {
            addCriterion("motherid not between", value1, value2, "motherid");
            return (Criteria) this;
        }

        public Criteria andConsortIsNull() {
            addCriterion("consort is null");
            return (Criteria) this;
        }

        public Criteria andConsortIsNotNull() {
            addCriterion("consort is not null");
            return (Criteria) this;
        }

        public Criteria andConsortEqualTo(String value) {
            addCriterion("consort =", value, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortNotEqualTo(String value) {
            addCriterion("consort <>", value, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortGreaterThan(String value) {
            addCriterion("consort >", value, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortGreaterThanOrEqualTo(String value) {
            addCriterion("consort >=", value, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortLessThan(String value) {
            addCriterion("consort <", value, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortLessThanOrEqualTo(String value) {
            addCriterion("consort <=", value, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortLike(String value) {
            addCriterion("consort like", value, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortNotLike(String value) {
            addCriterion("consort not like", value, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortIn(List<String> values) {
            addCriterion("consort in", values, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortNotIn(List<String> values) {
            addCriterion("consort not in", values, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortBetween(String value1, String value2) {
            addCriterion("consort between", value1, value2, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortNotBetween(String value1, String value2) {
            addCriterion("consort not between", value1, value2, "consort");
            return (Criteria) this;
        }

        public Criteria andConsortidIsNull() {
            addCriterion("consortid is null");
            return (Criteria) this;
        }

        public Criteria andConsortidIsNotNull() {
            addCriterion("consortid is not null");
            return (Criteria) this;
        }

        public Criteria andConsortidEqualTo(Integer value) {
            addCriterion("consortid =", value, "consortid");
            return (Criteria) this;
        }

        public Criteria andConsortidNotEqualTo(Integer value) {
            addCriterion("consortid <>", value, "consortid");
            return (Criteria) this;
        }

        public Criteria andConsortidGreaterThan(Integer value) {
            addCriterion("consortid >", value, "consortid");
            return (Criteria) this;
        }

        public Criteria andConsortidGreaterThanOrEqualTo(Integer value) {
            addCriterion("consortid >=", value, "consortid");
            return (Criteria) this;
        }

        public Criteria andConsortidLessThan(Integer value) {
            addCriterion("consortid <", value, "consortid");
            return (Criteria) this;
        }

        public Criteria andConsortidLessThanOrEqualTo(Integer value) {
            addCriterion("consortid <=", value, "consortid");
            return (Criteria) this;
        }

        public Criteria andConsortidIn(List<Integer> values) {
            addCriterion("consortid in", values, "consortid");
            return (Criteria) this;
        }

        public Criteria andConsortidNotIn(List<Integer> values) {
            addCriterion("consortid not in", values, "consortid");
            return (Criteria) this;
        }

        public Criteria andConsortidBetween(Integer value1, Integer value2) {
            addCriterion("consortid between", value1, value2, "consortid");
            return (Criteria) this;
        }

        public Criteria andConsortidNotBetween(Integer value1, Integer value2) {
            addCriterion("consortid not between", value1, value2, "consortid");
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