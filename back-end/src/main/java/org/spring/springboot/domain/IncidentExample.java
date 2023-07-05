package org.spring.springboot.domain;

import java.util.ArrayList;
import java.util.List;

public class IncidentExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public IncidentExample() {
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

		public Criteria andMemberrIsNull() {
			addCriterion("memberr is null");
			return (Criteria) this;
		}

		public Criteria andMemberrIsNotNull() {
			addCriterion("memberr is not null");
			return (Criteria) this;
		}

		public Criteria andMemberrEqualTo(String value) {
			addCriterion("memberr =", value, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrNotEqualTo(String value) {
			addCriterion("memberr <>", value, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrGreaterThan(String value) {
			addCriterion("memberr >", value, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrGreaterThanOrEqualTo(String value) {
			addCriterion("memberr >=", value, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrLessThan(String value) {
			addCriterion("memberr <", value, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrLessThanOrEqualTo(String value) {
			addCriterion("memberr <=", value, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrLike(String value) {
			addCriterion("memberr like", value, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrNotLike(String value) {
			addCriterion("memberr not like", value, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrIn(List<String> values) {
			addCriterion("memberr in", values, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrNotIn(List<String> values) {
			addCriterion("memberr not in", values, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrBetween(String value1, String value2) {
			addCriterion("memberr between", value1, value2, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberrNotBetween(String value1, String value2) {
			addCriterion("memberr not between", value1, value2, "memberr");
			return (Criteria) this;
		}

		public Criteria andMemberridIsNull() {
			addCriterion("memberrid is null");
			return (Criteria) this;
		}

		public Criteria andMemberridIsNotNull() {
			addCriterion("memberrid is not null");
			return (Criteria) this;
		}

		public Criteria andMemberridEqualTo(Integer value) {
			addCriterion("memberrid =", value, "memberrid");
			return (Criteria) this;
		}

		public Criteria andMemberridNotEqualTo(Integer value) {
			addCriterion("memberrid <>", value, "memberrid");
			return (Criteria) this;
		}

		public Criteria andMemberridGreaterThan(Integer value) {
			addCriterion("memberrid >", value, "memberrid");
			return (Criteria) this;
		}

		public Criteria andMemberridGreaterThanOrEqualTo(Integer value) {
			addCriterion("memberrid >=", value, "memberrid");
			return (Criteria) this;
		}

		public Criteria andMemberridLessThan(Integer value) {
			addCriterion("memberrid <", value, "memberrid");
			return (Criteria) this;
		}

		public Criteria andMemberridLessThanOrEqualTo(Integer value) {
			addCriterion("memberrid <=", value, "memberrid");
			return (Criteria) this;
		}

		public Criteria andMemberridIn(List<Integer> values) {
			addCriterion("memberrid in", values, "memberrid");
			return (Criteria) this;
		}

		public Criteria andMemberridNotIn(List<Integer> values) {
			addCriterion("memberrid not in", values, "memberrid");
			return (Criteria) this;
		}

		public Criteria andMemberridBetween(Integer value1, Integer value2) {
			addCriterion("memberrid between", value1, value2, "memberrid");
			return (Criteria) this;
		}

		public Criteria andMemberridNotBetween(Integer value1, Integer value2) {
			addCriterion("memberrid not between", value1, value2, "memberrid");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionIsNull() {
			addCriterion("eventdescription is null");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionIsNotNull() {
			addCriterion("eventdescription is not null");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionEqualTo(String value) {
			addCriterion("eventdescription =", value, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionNotEqualTo(String value) {
			addCriterion("eventdescription <>", value, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionGreaterThan(String value) {
			addCriterion("eventdescription >", value, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionGreaterThanOrEqualTo(String value) {
			addCriterion("eventdescription >=", value, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionLessThan(String value) {
			addCriterion("eventdescription <", value, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionLessThanOrEqualTo(String value) {
			addCriterion("eventdescription <=", value, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionLike(String value) {
			addCriterion("eventdescription like", value, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionNotLike(String value) {
			addCriterion("eventdescription not like", value, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionIn(List<String> values) {
			addCriterion("eventdescription in", values, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionNotIn(List<String> values) {
			addCriterion("eventdescription not in", values, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionBetween(String value1, String value2) {
			addCriterion("eventdescription between", value1, value2, "eventdescription");
			return (Criteria) this;
		}

		public Criteria andEventdescriptionNotBetween(String value1, String value2) {
			addCriterion("eventdescription not between", value1, value2, "eventdescription");
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