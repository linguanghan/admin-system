package generator;

import java.util.ArrayList;
import java.util.List;

public class PlayerunitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PlayerunitExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Long value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Long value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Long value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Long value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Long value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Long value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Long> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Long> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Long value1, Long value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Long value1, Long value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Integer value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Integer value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Integer value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Integer value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Integer value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Integer> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Integer> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Integer value1, Integer value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Integer value1, Integer value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(Integer value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(Integer value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(Integer value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(Integer value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(Integer value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<Integer> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<Integer> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(Integer value1, Integer value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(Integer value1, Integer value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andPackageidxIsNull() {
            addCriterion("packageIdx is null");
            return (Criteria) this;
        }

        public Criteria andPackageidxIsNotNull() {
            addCriterion("packageIdx is not null");
            return (Criteria) this;
        }

        public Criteria andPackageidxEqualTo(Integer value) {
            addCriterion("packageIdx =", value, "packageidx");
            return (Criteria) this;
        }

        public Criteria andPackageidxNotEqualTo(Integer value) {
            addCriterion("packageIdx <>", value, "packageidx");
            return (Criteria) this;
        }

        public Criteria andPackageidxGreaterThan(Integer value) {
            addCriterion("packageIdx >", value, "packageidx");
            return (Criteria) this;
        }

        public Criteria andPackageidxGreaterThanOrEqualTo(Integer value) {
            addCriterion("packageIdx >=", value, "packageidx");
            return (Criteria) this;
        }

        public Criteria andPackageidxLessThan(Integer value) {
            addCriterion("packageIdx <", value, "packageidx");
            return (Criteria) this;
        }

        public Criteria andPackageidxLessThanOrEqualTo(Integer value) {
            addCriterion("packageIdx <=", value, "packageidx");
            return (Criteria) this;
        }

        public Criteria andPackageidxIn(List<Integer> values) {
            addCriterion("packageIdx in", values, "packageidx");
            return (Criteria) this;
        }

        public Criteria andPackageidxNotIn(List<Integer> values) {
            addCriterion("packageIdx not in", values, "packageidx");
            return (Criteria) this;
        }

        public Criteria andPackageidxBetween(Integer value1, Integer value2) {
            addCriterion("packageIdx between", value1, value2, "packageidx");
            return (Criteria) this;
        }

        public Criteria andPackageidxNotBetween(Integer value1, Integer value2) {
            addCriterion("packageIdx not between", value1, value2, "packageidx");
            return (Criteria) this;
        }

        public Criteria andBookidxIsNull() {
            addCriterion("bookIdx is null");
            return (Criteria) this;
        }

        public Criteria andBookidxIsNotNull() {
            addCriterion("bookIdx is not null");
            return (Criteria) this;
        }

        public Criteria andBookidxEqualTo(Integer value) {
            addCriterion("bookIdx =", value, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBookidxNotEqualTo(Integer value) {
            addCriterion("bookIdx <>", value, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBookidxGreaterThan(Integer value) {
            addCriterion("bookIdx >", value, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBookidxGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookIdx >=", value, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBookidxLessThan(Integer value) {
            addCriterion("bookIdx <", value, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBookidxLessThanOrEqualTo(Integer value) {
            addCriterion("bookIdx <=", value, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBookidxIn(List<Integer> values) {
            addCriterion("bookIdx in", values, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBookidxNotIn(List<Integer> values) {
            addCriterion("bookIdx not in", values, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBookidxBetween(Integer value1, Integer value2) {
            addCriterion("bookIdx between", value1, value2, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBookidxNotBetween(Integer value1, Integer value2) {
            addCriterion("bookIdx not between", value1, value2, "bookidx");
            return (Criteria) this;
        }

        public Criteria andBooktypeIsNull() {
            addCriterion("bookType is null");
            return (Criteria) this;
        }

        public Criteria andBooktypeIsNotNull() {
            addCriterion("bookType is not null");
            return (Criteria) this;
        }

        public Criteria andBooktypeEqualTo(Integer value) {
            addCriterion("bookType =", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotEqualTo(Integer value) {
            addCriterion("bookType <>", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeGreaterThan(Integer value) {
            addCriterion("bookType >", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("bookType >=", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeLessThan(Integer value) {
            addCriterion("bookType <", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeLessThanOrEqualTo(Integer value) {
            addCriterion("bookType <=", value, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeIn(List<Integer> values) {
            addCriterion("bookType in", values, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotIn(List<Integer> values) {
            addCriterion("bookType not in", values, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeBetween(Integer value1, Integer value2) {
            addCriterion("bookType between", value1, value2, "booktype");
            return (Criteria) this;
        }

        public Criteria andBooktypeNotBetween(Integer value1, Integer value2) {
            addCriterion("bookType not between", value1, value2, "booktype");
            return (Criteria) this;
        }

        public Criteria andUnit1IsNull() {
            addCriterion("unit1 is null");
            return (Criteria) this;
        }

        public Criteria andUnit1IsNotNull() {
            addCriterion("unit1 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit1EqualTo(Integer value) {
            addCriterion("unit1 =", value, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit1NotEqualTo(Integer value) {
            addCriterion("unit1 <>", value, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit1GreaterThan(Integer value) {
            addCriterion("unit1 >", value, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit1GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit1 >=", value, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit1LessThan(Integer value) {
            addCriterion("unit1 <", value, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit1LessThanOrEqualTo(Integer value) {
            addCriterion("unit1 <=", value, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit1In(List<Integer> values) {
            addCriterion("unit1 in", values, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit1NotIn(List<Integer> values) {
            addCriterion("unit1 not in", values, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit1Between(Integer value1, Integer value2) {
            addCriterion("unit1 between", value1, value2, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit1NotBetween(Integer value1, Integer value2) {
            addCriterion("unit1 not between", value1, value2, "unit1");
            return (Criteria) this;
        }

        public Criteria andUnit2IsNull() {
            addCriterion("unit2 is null");
            return (Criteria) this;
        }

        public Criteria andUnit2IsNotNull() {
            addCriterion("unit2 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit2EqualTo(Integer value) {
            addCriterion("unit2 =", value, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit2NotEqualTo(Integer value) {
            addCriterion("unit2 <>", value, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit2GreaterThan(Integer value) {
            addCriterion("unit2 >", value, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit2GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit2 >=", value, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit2LessThan(Integer value) {
            addCriterion("unit2 <", value, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit2LessThanOrEqualTo(Integer value) {
            addCriterion("unit2 <=", value, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit2In(List<Integer> values) {
            addCriterion("unit2 in", values, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit2NotIn(List<Integer> values) {
            addCriterion("unit2 not in", values, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit2Between(Integer value1, Integer value2) {
            addCriterion("unit2 between", value1, value2, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit2NotBetween(Integer value1, Integer value2) {
            addCriterion("unit2 not between", value1, value2, "unit2");
            return (Criteria) this;
        }

        public Criteria andUnit3IsNull() {
            addCriterion("unit3 is null");
            return (Criteria) this;
        }

        public Criteria andUnit3IsNotNull() {
            addCriterion("unit3 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit3EqualTo(Integer value) {
            addCriterion("unit3 =", value, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit3NotEqualTo(Integer value) {
            addCriterion("unit3 <>", value, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit3GreaterThan(Integer value) {
            addCriterion("unit3 >", value, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit3GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit3 >=", value, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit3LessThan(Integer value) {
            addCriterion("unit3 <", value, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit3LessThanOrEqualTo(Integer value) {
            addCriterion("unit3 <=", value, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit3In(List<Integer> values) {
            addCriterion("unit3 in", values, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit3NotIn(List<Integer> values) {
            addCriterion("unit3 not in", values, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit3Between(Integer value1, Integer value2) {
            addCriterion("unit3 between", value1, value2, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit3NotBetween(Integer value1, Integer value2) {
            addCriterion("unit3 not between", value1, value2, "unit3");
            return (Criteria) this;
        }

        public Criteria andUnit4IsNull() {
            addCriterion("unit4 is null");
            return (Criteria) this;
        }

        public Criteria andUnit4IsNotNull() {
            addCriterion("unit4 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit4EqualTo(Integer value) {
            addCriterion("unit4 =", value, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit4NotEqualTo(Integer value) {
            addCriterion("unit4 <>", value, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit4GreaterThan(Integer value) {
            addCriterion("unit4 >", value, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit4GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit4 >=", value, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit4LessThan(Integer value) {
            addCriterion("unit4 <", value, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit4LessThanOrEqualTo(Integer value) {
            addCriterion("unit4 <=", value, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit4In(List<Integer> values) {
            addCriterion("unit4 in", values, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit4NotIn(List<Integer> values) {
            addCriterion("unit4 not in", values, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit4Between(Integer value1, Integer value2) {
            addCriterion("unit4 between", value1, value2, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit4NotBetween(Integer value1, Integer value2) {
            addCriterion("unit4 not between", value1, value2, "unit4");
            return (Criteria) this;
        }

        public Criteria andUnit5IsNull() {
            addCriterion("unit5 is null");
            return (Criteria) this;
        }

        public Criteria andUnit5IsNotNull() {
            addCriterion("unit5 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit5EqualTo(Integer value) {
            addCriterion("unit5 =", value, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit5NotEqualTo(Integer value) {
            addCriterion("unit5 <>", value, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit5GreaterThan(Integer value) {
            addCriterion("unit5 >", value, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit5GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit5 >=", value, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit5LessThan(Integer value) {
            addCriterion("unit5 <", value, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit5LessThanOrEqualTo(Integer value) {
            addCriterion("unit5 <=", value, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit5In(List<Integer> values) {
            addCriterion("unit5 in", values, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit5NotIn(List<Integer> values) {
            addCriterion("unit5 not in", values, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit5Between(Integer value1, Integer value2) {
            addCriterion("unit5 between", value1, value2, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit5NotBetween(Integer value1, Integer value2) {
            addCriterion("unit5 not between", value1, value2, "unit5");
            return (Criteria) this;
        }

        public Criteria andUnit6IsNull() {
            addCriterion("unit6 is null");
            return (Criteria) this;
        }

        public Criteria andUnit6IsNotNull() {
            addCriterion("unit6 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit6EqualTo(Integer value) {
            addCriterion("unit6 =", value, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit6NotEqualTo(Integer value) {
            addCriterion("unit6 <>", value, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit6GreaterThan(Integer value) {
            addCriterion("unit6 >", value, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit6GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit6 >=", value, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit6LessThan(Integer value) {
            addCriterion("unit6 <", value, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit6LessThanOrEqualTo(Integer value) {
            addCriterion("unit6 <=", value, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit6In(List<Integer> values) {
            addCriterion("unit6 in", values, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit6NotIn(List<Integer> values) {
            addCriterion("unit6 not in", values, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit6Between(Integer value1, Integer value2) {
            addCriterion("unit6 between", value1, value2, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit6NotBetween(Integer value1, Integer value2) {
            addCriterion("unit6 not between", value1, value2, "unit6");
            return (Criteria) this;
        }

        public Criteria andUnit7IsNull() {
            addCriterion("unit7 is null");
            return (Criteria) this;
        }

        public Criteria andUnit7IsNotNull() {
            addCriterion("unit7 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit7EqualTo(Integer value) {
            addCriterion("unit7 =", value, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit7NotEqualTo(Integer value) {
            addCriterion("unit7 <>", value, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit7GreaterThan(Integer value) {
            addCriterion("unit7 >", value, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit7GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit7 >=", value, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit7LessThan(Integer value) {
            addCriterion("unit7 <", value, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit7LessThanOrEqualTo(Integer value) {
            addCriterion("unit7 <=", value, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit7In(List<Integer> values) {
            addCriterion("unit7 in", values, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit7NotIn(List<Integer> values) {
            addCriterion("unit7 not in", values, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit7Between(Integer value1, Integer value2) {
            addCriterion("unit7 between", value1, value2, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit7NotBetween(Integer value1, Integer value2) {
            addCriterion("unit7 not between", value1, value2, "unit7");
            return (Criteria) this;
        }

        public Criteria andUnit8IsNull() {
            addCriterion("unit8 is null");
            return (Criteria) this;
        }

        public Criteria andUnit8IsNotNull() {
            addCriterion("unit8 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit8EqualTo(Integer value) {
            addCriterion("unit8 =", value, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit8NotEqualTo(Integer value) {
            addCriterion("unit8 <>", value, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit8GreaterThan(Integer value) {
            addCriterion("unit8 >", value, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit8GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit8 >=", value, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit8LessThan(Integer value) {
            addCriterion("unit8 <", value, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit8LessThanOrEqualTo(Integer value) {
            addCriterion("unit8 <=", value, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit8In(List<Integer> values) {
            addCriterion("unit8 in", values, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit8NotIn(List<Integer> values) {
            addCriterion("unit8 not in", values, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit8Between(Integer value1, Integer value2) {
            addCriterion("unit8 between", value1, value2, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit8NotBetween(Integer value1, Integer value2) {
            addCriterion("unit8 not between", value1, value2, "unit8");
            return (Criteria) this;
        }

        public Criteria andUnit9IsNull() {
            addCriterion("unit9 is null");
            return (Criteria) this;
        }

        public Criteria andUnit9IsNotNull() {
            addCriterion("unit9 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit9EqualTo(Integer value) {
            addCriterion("unit9 =", value, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit9NotEqualTo(Integer value) {
            addCriterion("unit9 <>", value, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit9GreaterThan(Integer value) {
            addCriterion("unit9 >", value, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit9GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit9 >=", value, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit9LessThan(Integer value) {
            addCriterion("unit9 <", value, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit9LessThanOrEqualTo(Integer value) {
            addCriterion("unit9 <=", value, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit9In(List<Integer> values) {
            addCriterion("unit9 in", values, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit9NotIn(List<Integer> values) {
            addCriterion("unit9 not in", values, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit9Between(Integer value1, Integer value2) {
            addCriterion("unit9 between", value1, value2, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit9NotBetween(Integer value1, Integer value2) {
            addCriterion("unit9 not between", value1, value2, "unit9");
            return (Criteria) this;
        }

        public Criteria andUnit10IsNull() {
            addCriterion("unit10 is null");
            return (Criteria) this;
        }

        public Criteria andUnit10IsNotNull() {
            addCriterion("unit10 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit10EqualTo(Integer value) {
            addCriterion("unit10 =", value, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit10NotEqualTo(Integer value) {
            addCriterion("unit10 <>", value, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit10GreaterThan(Integer value) {
            addCriterion("unit10 >", value, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit10GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit10 >=", value, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit10LessThan(Integer value) {
            addCriterion("unit10 <", value, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit10LessThanOrEqualTo(Integer value) {
            addCriterion("unit10 <=", value, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit10In(List<Integer> values) {
            addCriterion("unit10 in", values, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit10NotIn(List<Integer> values) {
            addCriterion("unit10 not in", values, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit10Between(Integer value1, Integer value2) {
            addCriterion("unit10 between", value1, value2, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit10NotBetween(Integer value1, Integer value2) {
            addCriterion("unit10 not between", value1, value2, "unit10");
            return (Criteria) this;
        }

        public Criteria andUnit11IsNull() {
            addCriterion("unit11 is null");
            return (Criteria) this;
        }

        public Criteria andUnit11IsNotNull() {
            addCriterion("unit11 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit11EqualTo(Integer value) {
            addCriterion("unit11 =", value, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit11NotEqualTo(Integer value) {
            addCriterion("unit11 <>", value, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit11GreaterThan(Integer value) {
            addCriterion("unit11 >", value, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit11GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit11 >=", value, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit11LessThan(Integer value) {
            addCriterion("unit11 <", value, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit11LessThanOrEqualTo(Integer value) {
            addCriterion("unit11 <=", value, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit11In(List<Integer> values) {
            addCriterion("unit11 in", values, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit11NotIn(List<Integer> values) {
            addCriterion("unit11 not in", values, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit11Between(Integer value1, Integer value2) {
            addCriterion("unit11 between", value1, value2, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit11NotBetween(Integer value1, Integer value2) {
            addCriterion("unit11 not between", value1, value2, "unit11");
            return (Criteria) this;
        }

        public Criteria andUnit12IsNull() {
            addCriterion("unit12 is null");
            return (Criteria) this;
        }

        public Criteria andUnit12IsNotNull() {
            addCriterion("unit12 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit12EqualTo(Integer value) {
            addCriterion("unit12 =", value, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit12NotEqualTo(Integer value) {
            addCriterion("unit12 <>", value, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit12GreaterThan(Integer value) {
            addCriterion("unit12 >", value, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit12GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit12 >=", value, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit12LessThan(Integer value) {
            addCriterion("unit12 <", value, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit12LessThanOrEqualTo(Integer value) {
            addCriterion("unit12 <=", value, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit12In(List<Integer> values) {
            addCriterion("unit12 in", values, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit12NotIn(List<Integer> values) {
            addCriterion("unit12 not in", values, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit12Between(Integer value1, Integer value2) {
            addCriterion("unit12 between", value1, value2, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit12NotBetween(Integer value1, Integer value2) {
            addCriterion("unit12 not between", value1, value2, "unit12");
            return (Criteria) this;
        }

        public Criteria andUnit13IsNull() {
            addCriterion("unit13 is null");
            return (Criteria) this;
        }

        public Criteria andUnit13IsNotNull() {
            addCriterion("unit13 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit13EqualTo(Integer value) {
            addCriterion("unit13 =", value, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit13NotEqualTo(Integer value) {
            addCriterion("unit13 <>", value, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit13GreaterThan(Integer value) {
            addCriterion("unit13 >", value, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit13GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit13 >=", value, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit13LessThan(Integer value) {
            addCriterion("unit13 <", value, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit13LessThanOrEqualTo(Integer value) {
            addCriterion("unit13 <=", value, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit13In(List<Integer> values) {
            addCriterion("unit13 in", values, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit13NotIn(List<Integer> values) {
            addCriterion("unit13 not in", values, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit13Between(Integer value1, Integer value2) {
            addCriterion("unit13 between", value1, value2, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit13NotBetween(Integer value1, Integer value2) {
            addCriterion("unit13 not between", value1, value2, "unit13");
            return (Criteria) this;
        }

        public Criteria andUnit14IsNull() {
            addCriterion("unit14 is null");
            return (Criteria) this;
        }

        public Criteria andUnit14IsNotNull() {
            addCriterion("unit14 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit14EqualTo(Integer value) {
            addCriterion("unit14 =", value, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit14NotEqualTo(Integer value) {
            addCriterion("unit14 <>", value, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit14GreaterThan(Integer value) {
            addCriterion("unit14 >", value, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit14GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit14 >=", value, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit14LessThan(Integer value) {
            addCriterion("unit14 <", value, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit14LessThanOrEqualTo(Integer value) {
            addCriterion("unit14 <=", value, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit14In(List<Integer> values) {
            addCriterion("unit14 in", values, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit14NotIn(List<Integer> values) {
            addCriterion("unit14 not in", values, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit14Between(Integer value1, Integer value2) {
            addCriterion("unit14 between", value1, value2, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit14NotBetween(Integer value1, Integer value2) {
            addCriterion("unit14 not between", value1, value2, "unit14");
            return (Criteria) this;
        }

        public Criteria andUnit15IsNull() {
            addCriterion("unit15 is null");
            return (Criteria) this;
        }

        public Criteria andUnit15IsNotNull() {
            addCriterion("unit15 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit15EqualTo(Integer value) {
            addCriterion("unit15 =", value, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit15NotEqualTo(Integer value) {
            addCriterion("unit15 <>", value, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit15GreaterThan(Integer value) {
            addCriterion("unit15 >", value, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit15GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit15 >=", value, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit15LessThan(Integer value) {
            addCriterion("unit15 <", value, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit15LessThanOrEqualTo(Integer value) {
            addCriterion("unit15 <=", value, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit15In(List<Integer> values) {
            addCriterion("unit15 in", values, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit15NotIn(List<Integer> values) {
            addCriterion("unit15 not in", values, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit15Between(Integer value1, Integer value2) {
            addCriterion("unit15 between", value1, value2, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit15NotBetween(Integer value1, Integer value2) {
            addCriterion("unit15 not between", value1, value2, "unit15");
            return (Criteria) this;
        }

        public Criteria andUnit16IsNull() {
            addCriterion("unit16 is null");
            return (Criteria) this;
        }

        public Criteria andUnit16IsNotNull() {
            addCriterion("unit16 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit16EqualTo(Integer value) {
            addCriterion("unit16 =", value, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit16NotEqualTo(Integer value) {
            addCriterion("unit16 <>", value, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit16GreaterThan(Integer value) {
            addCriterion("unit16 >", value, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit16GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit16 >=", value, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit16LessThan(Integer value) {
            addCriterion("unit16 <", value, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit16LessThanOrEqualTo(Integer value) {
            addCriterion("unit16 <=", value, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit16In(List<Integer> values) {
            addCriterion("unit16 in", values, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit16NotIn(List<Integer> values) {
            addCriterion("unit16 not in", values, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit16Between(Integer value1, Integer value2) {
            addCriterion("unit16 between", value1, value2, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit16NotBetween(Integer value1, Integer value2) {
            addCriterion("unit16 not between", value1, value2, "unit16");
            return (Criteria) this;
        }

        public Criteria andUnit17IsNull() {
            addCriterion("unit17 is null");
            return (Criteria) this;
        }

        public Criteria andUnit17IsNotNull() {
            addCriterion("unit17 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit17EqualTo(Integer value) {
            addCriterion("unit17 =", value, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit17NotEqualTo(Integer value) {
            addCriterion("unit17 <>", value, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit17GreaterThan(Integer value) {
            addCriterion("unit17 >", value, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit17GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit17 >=", value, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit17LessThan(Integer value) {
            addCriterion("unit17 <", value, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit17LessThanOrEqualTo(Integer value) {
            addCriterion("unit17 <=", value, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit17In(List<Integer> values) {
            addCriterion("unit17 in", values, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit17NotIn(List<Integer> values) {
            addCriterion("unit17 not in", values, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit17Between(Integer value1, Integer value2) {
            addCriterion("unit17 between", value1, value2, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit17NotBetween(Integer value1, Integer value2) {
            addCriterion("unit17 not between", value1, value2, "unit17");
            return (Criteria) this;
        }

        public Criteria andUnit18IsNull() {
            addCriterion("unit18 is null");
            return (Criteria) this;
        }

        public Criteria andUnit18IsNotNull() {
            addCriterion("unit18 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit18EqualTo(Integer value) {
            addCriterion("unit18 =", value, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit18NotEqualTo(Integer value) {
            addCriterion("unit18 <>", value, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit18GreaterThan(Integer value) {
            addCriterion("unit18 >", value, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit18GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit18 >=", value, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit18LessThan(Integer value) {
            addCriterion("unit18 <", value, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit18LessThanOrEqualTo(Integer value) {
            addCriterion("unit18 <=", value, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit18In(List<Integer> values) {
            addCriterion("unit18 in", values, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit18NotIn(List<Integer> values) {
            addCriterion("unit18 not in", values, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit18Between(Integer value1, Integer value2) {
            addCriterion("unit18 between", value1, value2, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit18NotBetween(Integer value1, Integer value2) {
            addCriterion("unit18 not between", value1, value2, "unit18");
            return (Criteria) this;
        }

        public Criteria andUnit19IsNull() {
            addCriterion("unit19 is null");
            return (Criteria) this;
        }

        public Criteria andUnit19IsNotNull() {
            addCriterion("unit19 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit19EqualTo(Integer value) {
            addCriterion("unit19 =", value, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit19NotEqualTo(Integer value) {
            addCriterion("unit19 <>", value, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit19GreaterThan(Integer value) {
            addCriterion("unit19 >", value, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit19GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit19 >=", value, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit19LessThan(Integer value) {
            addCriterion("unit19 <", value, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit19LessThanOrEqualTo(Integer value) {
            addCriterion("unit19 <=", value, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit19In(List<Integer> values) {
            addCriterion("unit19 in", values, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit19NotIn(List<Integer> values) {
            addCriterion("unit19 not in", values, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit19Between(Integer value1, Integer value2) {
            addCriterion("unit19 between", value1, value2, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit19NotBetween(Integer value1, Integer value2) {
            addCriterion("unit19 not between", value1, value2, "unit19");
            return (Criteria) this;
        }

        public Criteria andUnit20IsNull() {
            addCriterion("unit20 is null");
            return (Criteria) this;
        }

        public Criteria andUnit20IsNotNull() {
            addCriterion("unit20 is not null");
            return (Criteria) this;
        }

        public Criteria andUnit20EqualTo(Integer value) {
            addCriterion("unit20 =", value, "unit20");
            return (Criteria) this;
        }

        public Criteria andUnit20NotEqualTo(Integer value) {
            addCriterion("unit20 <>", value, "unit20");
            return (Criteria) this;
        }

        public Criteria andUnit20GreaterThan(Integer value) {
            addCriterion("unit20 >", value, "unit20");
            return (Criteria) this;
        }

        public Criteria andUnit20GreaterThanOrEqualTo(Integer value) {
            addCriterion("unit20 >=", value, "unit20");
            return (Criteria) this;
        }

        public Criteria andUnit20LessThan(Integer value) {
            addCriterion("unit20 <", value, "unit20");
            return (Criteria) this;
        }

        public Criteria andUnit20LessThanOrEqualTo(Integer value) {
            addCriterion("unit20 <=", value, "unit20");
            return (Criteria) this;
        }

        public Criteria andUnit20In(List<Integer> values) {
            addCriterion("unit20 in", values, "unit20");
            return (Criteria) this;
        }

        public Criteria andUnit20NotIn(List<Integer> values) {
            addCriterion("unit20 not in", values, "unit20");
            return (Criteria) this;
        }

        public Criteria andUnit20Between(Integer value1, Integer value2) {
            addCriterion("unit20 between", value1, value2, "unit20");
            return (Criteria) this;
        }

        public Criteria andUnit20NotBetween(Integer value1, Integer value2) {
            addCriterion("unit20 not between", value1, value2, "unit20");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Integer value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Integer value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Integer value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Integer value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Integer> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Integer> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Integer value1, Integer value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }
    }

    /**
     */
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