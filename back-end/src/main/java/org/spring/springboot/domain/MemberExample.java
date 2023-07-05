package org.spring.springboot.domain;

import java.util.ArrayList;
import java.util.List;

public class MemberExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public MemberExample() {
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

		public Criteria andAvatarIsNull() {
			addCriterion("avatar is null");
			return (Criteria) this;
		}

		public Criteria andAvatarIsNotNull() {
			addCriterion("avatar is not null");
			return (Criteria) this;
		}

		public Criteria andAvatarEqualTo(String value) {
			addCriterion("avatar =", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotEqualTo(String value) {
			addCriterion("avatar <>", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarGreaterThan(String value) {
			addCriterion("avatar >", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarGreaterThanOrEqualTo(String value) {
			addCriterion("avatar >=", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarLessThan(String value) {
			addCriterion("avatar <", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarLessThanOrEqualTo(String value) {
			addCriterion("avatar <=", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarLike(String value) {
			addCriterion("avatar like", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotLike(String value) {
			addCriterion("avatar not like", value, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarIn(List<String> values) {
			addCriterion("avatar in", values, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotIn(List<String> values) {
			addCriterion("avatar not in", values, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarBetween(String value1, String value2) {
			addCriterion("avatar between", value1, value2, "avatar");
			return (Criteria) this;
		}

		public Criteria andAvatarNotBetween(String value1, String value2) {
			addCriterion("avatar not between", value1, value2, "avatar");
			return (Criteria) this;
		}

		public Criteria andFamilyIsNull() {
			addCriterion("family is null");
			return (Criteria) this;
		}

		public Criteria andFamilyIsNotNull() {
			addCriterion("family is not null");
			return (Criteria) this;
		}

		public Criteria andFamilyEqualTo(String value) {
			addCriterion("family =", value, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyNotEqualTo(String value) {
			addCriterion("family <>", value, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyGreaterThan(String value) {
			addCriterion("family >", value, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyGreaterThanOrEqualTo(String value) {
			addCriterion("family >=", value, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyLessThan(String value) {
			addCriterion("family <", value, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyLessThanOrEqualTo(String value) {
			addCriterion("family <=", value, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyLike(String value) {
			addCriterion("family like", value, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyNotLike(String value) {
			addCriterion("family not like", value, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyIn(List<String> values) {
			addCriterion("family in", values, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyNotIn(List<String> values) {
			addCriterion("family not in", values, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyBetween(String value1, String value2) {
			addCriterion("family between", value1, value2, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyNotBetween(String value1, String value2) {
			addCriterion("family not between", value1, value2, "family");
			return (Criteria) this;
		}

		public Criteria andFamilyidIsNull() {
			addCriterion("familyid is null");
			return (Criteria) this;
		}

		public Criteria andFamilyidIsNotNull() {
			addCriterion("familyid is not null");
			return (Criteria) this;
		}

		public Criteria andFamilyidEqualTo(Integer value) {
			addCriterion("familyid =", value, "familyid");
			return (Criteria) this;
		}

		public Criteria andFamilyidNotEqualTo(Integer value) {
			addCriterion("familyid <>", value, "familyid");
			return (Criteria) this;
		}

		public Criteria andFamilyidGreaterThan(Integer value) {
			addCriterion("familyid >", value, "familyid");
			return (Criteria) this;
		}

		public Criteria andFamilyidGreaterThanOrEqualTo(Integer value) {
			addCriterion("familyid >=", value, "familyid");
			return (Criteria) this;
		}

		public Criteria andFamilyidLessThan(Integer value) {
			addCriterion("familyid <", value, "familyid");
			return (Criteria) this;
		}

		public Criteria andFamilyidLessThanOrEqualTo(Integer value) {
			addCriterion("familyid <=", value, "familyid");
			return (Criteria) this;
		}

		public Criteria andFamilyidIn(List<Integer> values) {
			addCriterion("familyid in", values, "familyid");
			return (Criteria) this;
		}

		public Criteria andFamilyidNotIn(List<Integer> values) {
			addCriterion("familyid not in", values, "familyid");
			return (Criteria) this;
		}

		public Criteria andFamilyidBetween(Integer value1, Integer value2) {
			addCriterion("familyid between", value1, value2, "familyid");
			return (Criteria) this;
		}

		public Criteria andFamilyidNotBetween(Integer value1, Integer value2) {
			addCriterion("familyid not between", value1, value2, "familyid");
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

		public Criteria andSpousesIsNull() {
			addCriterion("spouses is null");
			return (Criteria) this;
		}

		public Criteria andSpousesIsNotNull() {
			addCriterion("spouses is not null");
			return (Criteria) this;
		}

		public Criteria andSpousesEqualTo(String value) {
			addCriterion("spouses =", value, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesNotEqualTo(String value) {
			addCriterion("spouses <>", value, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesGreaterThan(String value) {
			addCriterion("spouses >", value, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesGreaterThanOrEqualTo(String value) {
			addCriterion("spouses >=", value, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesLessThan(String value) {
			addCriterion("spouses <", value, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesLessThanOrEqualTo(String value) {
			addCriterion("spouses <=", value, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesLike(String value) {
			addCriterion("spouses like", value, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesNotLike(String value) {
			addCriterion("spouses not like", value, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesIn(List<String> values) {
			addCriterion("spouses in", values, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesNotIn(List<String> values) {
			addCriterion("spouses not in", values, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesBetween(String value1, String value2) {
			addCriterion("spouses between", value1, value2, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesNotBetween(String value1, String value2) {
			addCriterion("spouses not between", value1, value2, "spouses");
			return (Criteria) this;
		}

		public Criteria andSpousesidIsNull() {
			addCriterion("spousesid is null");
			return (Criteria) this;
		}

		public Criteria andSpousesidIsNotNull() {
			addCriterion("spousesid is not null");
			return (Criteria) this;
		}

		public Criteria andSpousesidEqualTo(Integer value) {
			addCriterion("spousesid =", value, "spousesid");
			return (Criteria) this;
		}

		public Criteria andSpousesidNotEqualTo(Integer value) {
			addCriterion("spousesid <>", value, "spousesid");
			return (Criteria) this;
		}

		public Criteria andSpousesidGreaterThan(Integer value) {
			addCriterion("spousesid >", value, "spousesid");
			return (Criteria) this;
		}

		public Criteria andSpousesidGreaterThanOrEqualTo(Integer value) {
			addCriterion("spousesid >=", value, "spousesid");
			return (Criteria) this;
		}

		public Criteria andSpousesidLessThan(Integer value) {
			addCriterion("spousesid <", value, "spousesid");
			return (Criteria) this;
		}

		public Criteria andSpousesidLessThanOrEqualTo(Integer value) {
			addCriterion("spousesid <=", value, "spousesid");
			return (Criteria) this;
		}

		public Criteria andSpousesidIn(List<Integer> values) {
			addCriterion("spousesid in", values, "spousesid");
			return (Criteria) this;
		}

		public Criteria andSpousesidNotIn(List<Integer> values) {
			addCriterion("spousesid not in", values, "spousesid");
			return (Criteria) this;
		}

		public Criteria andSpousesidBetween(Integer value1, Integer value2) {
			addCriterion("spousesid between", value1, value2, "spousesid");
			return (Criteria) this;
		}

		public Criteria andSpousesidNotBetween(Integer value1, Integer value2) {
			addCriterion("spousesid not between", value1, value2, "spousesid");
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