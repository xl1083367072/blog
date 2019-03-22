package com.xl.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andRelease_dateIsNull() {
            addCriterion("release_date is null");
            return (Criteria) this;
        }

        public Criteria andRelease_dateIsNotNull() {
            addCriterion("release_date is not null");
            return (Criteria) this;
        }

        public Criteria andRelease_dateEqualTo(Date value) {
            addCriterion("release_date =", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateNotEqualTo(Date value) {
            addCriterion("release_date <>", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateGreaterThan(Date value) {
            addCriterion("release_date >", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("release_date >=", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateLessThan(Date value) {
            addCriterion("release_date <", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateLessThanOrEqualTo(Date value) {
            addCriterion("release_date <=", value, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateIn(List<Date> values) {
            addCriterion("release_date in", values, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateNotIn(List<Date> values) {
            addCriterion("release_date not in", values, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateBetween(Date value1, Date value2) {
            addCriterion("release_date between", value1, value2, "release_date");
            return (Criteria) this;
        }

        public Criteria andRelease_dateNotBetween(Date value1, Date value2) {
            addCriterion("release_date not between", value1, value2, "release_date");
            return (Criteria) this;
        }

        public Criteria andClick_hitIsNull() {
            addCriterion("click_hit is null");
            return (Criteria) this;
        }

        public Criteria andClick_hitIsNotNull() {
            addCriterion("click_hit is not null");
            return (Criteria) this;
        }

        public Criteria andClick_hitEqualTo(Integer value) {
            addCriterion("click_hit =", value, "click_hit");
            return (Criteria) this;
        }

        public Criteria andClick_hitNotEqualTo(Integer value) {
            addCriterion("click_hit <>", value, "click_hit");
            return (Criteria) this;
        }

        public Criteria andClick_hitGreaterThan(Integer value) {
            addCriterion("click_hit >", value, "click_hit");
            return (Criteria) this;
        }

        public Criteria andClick_hitGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_hit >=", value, "click_hit");
            return (Criteria) this;
        }

        public Criteria andClick_hitLessThan(Integer value) {
            addCriterion("click_hit <", value, "click_hit");
            return (Criteria) this;
        }

        public Criteria andClick_hitLessThanOrEqualTo(Integer value) {
            addCriterion("click_hit <=", value, "click_hit");
            return (Criteria) this;
        }

        public Criteria andClick_hitIn(List<Integer> values) {
            addCriterion("click_hit in", values, "click_hit");
            return (Criteria) this;
        }

        public Criteria andClick_hitNotIn(List<Integer> values) {
            addCriterion("click_hit not in", values, "click_hit");
            return (Criteria) this;
        }

        public Criteria andClick_hitBetween(Integer value1, Integer value2) {
            addCriterion("click_hit between", value1, value2, "click_hit");
            return (Criteria) this;
        }

        public Criteria andClick_hitNotBetween(Integer value1, Integer value2) {
            addCriterion("click_hit not between", value1, value2, "click_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitIsNull() {
            addCriterion("reply_hit is null");
            return (Criteria) this;
        }

        public Criteria andReply_hitIsNotNull() {
            addCriterion("reply_hit is not null");
            return (Criteria) this;
        }

        public Criteria andReply_hitEqualTo(Integer value) {
            addCriterion("reply_hit =", value, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitNotEqualTo(Integer value) {
            addCriterion("reply_hit <>", value, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitGreaterThan(Integer value) {
            addCriterion("reply_hit >", value, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_hit >=", value, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitLessThan(Integer value) {
            addCriterion("reply_hit <", value, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitLessThanOrEqualTo(Integer value) {
            addCriterion("reply_hit <=", value, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitIn(List<Integer> values) {
            addCriterion("reply_hit in", values, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitNotIn(List<Integer> values) {
            addCriterion("reply_hit not in", values, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitBetween(Integer value1, Integer value2) {
            addCriterion("reply_hit between", value1, value2, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andReply_hitNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_hit not between", value1, value2, "reply_hit");
            return (Criteria) this;
        }

        public Criteria andType_idIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andType_idIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andType_idEqualTo(Integer value) {
            addCriterion("type_id =", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idGreaterThan(Integer value) {
            addCriterion("type_id >", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idLessThan(Integer value) {
            addCriterion("type_id <", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idIn(List<Integer> values) {
            addCriterion("type_id in", values, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "type_id");
            return (Criteria) this;
        }

        public Criteria andType_idNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "type_id");
            return (Criteria) this;
        }

        public Criteria andKey_wordIsNull() {
            addCriterion("key_word is null");
            return (Criteria) this;
        }

        public Criteria andKey_wordIsNotNull() {
            addCriterion("key_word is not null");
            return (Criteria) this;
        }

        public Criteria andKey_wordEqualTo(String value) {
            addCriterion("key_word =", value, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordNotEqualTo(String value) {
            addCriterion("key_word <>", value, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordGreaterThan(String value) {
            addCriterion("key_word >", value, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordGreaterThanOrEqualTo(String value) {
            addCriterion("key_word >=", value, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordLessThan(String value) {
            addCriterion("key_word <", value, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordLessThanOrEqualTo(String value) {
            addCriterion("key_word <=", value, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordLike(String value) {
            addCriterion("key_word like", value, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordNotLike(String value) {
            addCriterion("key_word not like", value, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordIn(List<String> values) {
            addCriterion("key_word in", values, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordNotIn(List<String> values) {
            addCriterion("key_word not in", values, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordBetween(String value1, String value2) {
            addCriterion("key_word between", value1, value2, "key_word");
            return (Criteria) this;
        }

        public Criteria andKey_wordNotBetween(String value1, String value2) {
            addCriterion("key_word not between", value1, value2, "key_word");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
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