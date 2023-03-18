package generator;

import java.util.ArrayList;
import java.util.List;

public class PlayerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PlayerExample() {
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

        public Criteria andAccountidIsNull() {
            addCriterion("accountID is null");
            return (Criteria) this;
        }

        public Criteria andAccountidIsNotNull() {
            addCriterion("accountID is not null");
            return (Criteria) this;
        }

        public Criteria andAccountidEqualTo(Long value) {
            addCriterion("accountID =", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotEqualTo(Long value) {
            addCriterion("accountID <>", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThan(Long value) {
            addCriterion("accountID >", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidGreaterThanOrEqualTo(Long value) {
            addCriterion("accountID >=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThan(Long value) {
            addCriterion("accountID <", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidLessThanOrEqualTo(Long value) {
            addCriterion("accountID <=", value, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidIn(List<Long> values) {
            addCriterion("accountID in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotIn(List<Long> values) {
            addCriterion("accountID not in", values, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidBetween(Long value1, Long value2) {
            addCriterion("accountID between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andAccountidNotBetween(Long value1, Long value2) {
            addCriterion("accountID not between", value1, value2, "accountid");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("`name` is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("`name` is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("`name` =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("`name` <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("`name` >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("`name` >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("`name` <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("`name` <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("`name` like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("`name` not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("`name` in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("`name` not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("`name` between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("`name` not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(Integer value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(Integer value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(Integer value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(Integer value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(Integer value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(Integer value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<Integer> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<Integer> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(Integer value1, Integer value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(Integer value1, Integer value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlIsNull() {
            addCriterion("headImageUrl is null");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlIsNotNull() {
            addCriterion("headImageUrl is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlEqualTo(String value) {
            addCriterion("headImageUrl =", value, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlNotEqualTo(String value) {
            addCriterion("headImageUrl <>", value, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlGreaterThan(String value) {
            addCriterion("headImageUrl >", value, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlGreaterThanOrEqualTo(String value) {
            addCriterion("headImageUrl >=", value, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlLessThan(String value) {
            addCriterion("headImageUrl <", value, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlLessThanOrEqualTo(String value) {
            addCriterion("headImageUrl <=", value, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlLike(String value) {
            addCriterion("headImageUrl like", value, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlNotLike(String value) {
            addCriterion("headImageUrl not like", value, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlIn(List<String> values) {
            addCriterion("headImageUrl in", values, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlNotIn(List<String> values) {
            addCriterion("headImageUrl not in", values, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlBetween(String value1, String value2) {
            addCriterion("headImageUrl between", value1, value2, "headimageurl");
            return (Criteria) this;
        }

        public Criteria andHeadimageurlNotBetween(String value1, String value2) {
            addCriterion("headImageUrl not between", value1, value2, "headimageurl");
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

        public Criteria andCreatetimeEqualTo(Long value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Long value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Long value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Long value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Long value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Long> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Long> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Long value1, Long value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Long value1, Long value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andLvIsNull() {
            addCriterion("lv is null");
            return (Criteria) this;
        }

        public Criteria andLvIsNotNull() {
            addCriterion("lv is not null");
            return (Criteria) this;
        }

        public Criteria andLvEqualTo(Integer value) {
            addCriterion("lv =", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotEqualTo(Integer value) {
            addCriterion("lv <>", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvGreaterThan(Integer value) {
            addCriterion("lv >", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvGreaterThanOrEqualTo(Integer value) {
            addCriterion("lv >=", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvLessThan(Integer value) {
            addCriterion("lv <", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvLessThanOrEqualTo(Integer value) {
            addCriterion("lv <=", value, "lv");
            return (Criteria) this;
        }

        public Criteria andLvIn(List<Integer> values) {
            addCriterion("lv in", values, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotIn(List<Integer> values) {
            addCriterion("lv not in", values, "lv");
            return (Criteria) this;
        }

        public Criteria andLvBetween(Integer value1, Integer value2) {
            addCriterion("lv between", value1, value2, "lv");
            return (Criteria) this;
        }

        public Criteria andLvNotBetween(Integer value1, Integer value2) {
            addCriterion("lv not between", value1, value2, "lv");
            return (Criteria) this;
        }

        public Criteria andGmlevelIsNull() {
            addCriterion("gmLevel is null");
            return (Criteria) this;
        }

        public Criteria andGmlevelIsNotNull() {
            addCriterion("gmLevel is not null");
            return (Criteria) this;
        }

        public Criteria andGmlevelEqualTo(Integer value) {
            addCriterion("gmLevel =", value, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andGmlevelNotEqualTo(Integer value) {
            addCriterion("gmLevel <>", value, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andGmlevelGreaterThan(Integer value) {
            addCriterion("gmLevel >", value, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andGmlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("gmLevel >=", value, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andGmlevelLessThan(Integer value) {
            addCriterion("gmLevel <", value, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andGmlevelLessThanOrEqualTo(Integer value) {
            addCriterion("gmLevel <=", value, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andGmlevelIn(List<Integer> values) {
            addCriterion("gmLevel in", values, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andGmlevelNotIn(List<Integer> values) {
            addCriterion("gmLevel not in", values, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andGmlevelBetween(Integer value1, Integer value2) {
            addCriterion("gmLevel between", value1, value2, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andGmlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("gmLevel not between", value1, value2, "gmlevel");
            return (Criteria) this;
        }

        public Criteria andViplevelIsNull() {
            addCriterion("vipLevel is null");
            return (Criteria) this;
        }

        public Criteria andViplevelIsNotNull() {
            addCriterion("vipLevel is not null");
            return (Criteria) this;
        }

        public Criteria andViplevelEqualTo(Integer value) {
            addCriterion("vipLevel =", value, "viplevel");
            return (Criteria) this;
        }

        public Criteria andViplevelNotEqualTo(Integer value) {
            addCriterion("vipLevel <>", value, "viplevel");
            return (Criteria) this;
        }

        public Criteria andViplevelGreaterThan(Integer value) {
            addCriterion("vipLevel >", value, "viplevel");
            return (Criteria) this;
        }

        public Criteria andViplevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("vipLevel >=", value, "viplevel");
            return (Criteria) this;
        }

        public Criteria andViplevelLessThan(Integer value) {
            addCriterion("vipLevel <", value, "viplevel");
            return (Criteria) this;
        }

        public Criteria andViplevelLessThanOrEqualTo(Integer value) {
            addCriterion("vipLevel <=", value, "viplevel");
            return (Criteria) this;
        }

        public Criteria andViplevelIn(List<Integer> values) {
            addCriterion("vipLevel in", values, "viplevel");
            return (Criteria) this;
        }

        public Criteria andViplevelNotIn(List<Integer> values) {
            addCriterion("vipLevel not in", values, "viplevel");
            return (Criteria) this;
        }

        public Criteria andViplevelBetween(Integer value1, Integer value2) {
            addCriterion("vipLevel between", value1, value2, "viplevel");
            return (Criteria) this;
        }

        public Criteria andViplevelNotBetween(Integer value1, Integer value2) {
            addCriterion("vipLevel not between", value1, value2, "viplevel");
            return (Criteria) this;
        }

        public Criteria andVipexpIsNull() {
            addCriterion("vipExp is null");
            return (Criteria) this;
        }

        public Criteria andVipexpIsNotNull() {
            addCriterion("vipExp is not null");
            return (Criteria) this;
        }

        public Criteria andVipexpEqualTo(Integer value) {
            addCriterion("vipExp =", value, "vipexp");
            return (Criteria) this;
        }

        public Criteria andVipexpNotEqualTo(Integer value) {
            addCriterion("vipExp <>", value, "vipexp");
            return (Criteria) this;
        }

        public Criteria andVipexpGreaterThan(Integer value) {
            addCriterion("vipExp >", value, "vipexp");
            return (Criteria) this;
        }

        public Criteria andVipexpGreaterThanOrEqualTo(Integer value) {
            addCriterion("vipExp >=", value, "vipexp");
            return (Criteria) this;
        }

        public Criteria andVipexpLessThan(Integer value) {
            addCriterion("vipExp <", value, "vipexp");
            return (Criteria) this;
        }

        public Criteria andVipexpLessThanOrEqualTo(Integer value) {
            addCriterion("vipExp <=", value, "vipexp");
            return (Criteria) this;
        }

        public Criteria andVipexpIn(List<Integer> values) {
            addCriterion("vipExp in", values, "vipexp");
            return (Criteria) this;
        }

        public Criteria andVipexpNotIn(List<Integer> values) {
            addCriterion("vipExp not in", values, "vipexp");
            return (Criteria) this;
        }

        public Criteria andVipexpBetween(Integer value1, Integer value2) {
            addCriterion("vipExp between", value1, value2, "vipexp");
            return (Criteria) this;
        }

        public Criteria andVipexpNotBetween(Integer value1, Integer value2) {
            addCriterion("vipExp not between", value1, value2, "vipexp");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeIsNull() {
            addCriterion("totalRecharge is null");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeIsNotNull() {
            addCriterion("totalRecharge is not null");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeEqualTo(Integer value) {
            addCriterion("totalRecharge =", value, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeNotEqualTo(Integer value) {
            addCriterion("totalRecharge <>", value, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeGreaterThan(Integer value) {
            addCriterion("totalRecharge >", value, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalRecharge >=", value, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeLessThan(Integer value) {
            addCriterion("totalRecharge <", value, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeLessThanOrEqualTo(Integer value) {
            addCriterion("totalRecharge <=", value, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeIn(List<Integer> values) {
            addCriterion("totalRecharge in", values, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeNotIn(List<Integer> values) {
            addCriterion("totalRecharge not in", values, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeBetween(Integer value1, Integer value2) {
            addCriterion("totalRecharge between", value1, value2, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andTotalrechargeNotBetween(Integer value1, Integer value2) {
            addCriterion("totalRecharge not between", value1, value2, "totalrecharge");
            return (Criteria) this;
        }

        public Criteria andCrystalIsNull() {
            addCriterion("crystal is null");
            return (Criteria) this;
        }

        public Criteria andCrystalIsNotNull() {
            addCriterion("crystal is not null");
            return (Criteria) this;
        }

        public Criteria andCrystalEqualTo(Integer value) {
            addCriterion("crystal =", value, "crystal");
            return (Criteria) this;
        }

        public Criteria andCrystalNotEqualTo(Integer value) {
            addCriterion("crystal <>", value, "crystal");
            return (Criteria) this;
        }

        public Criteria andCrystalGreaterThan(Integer value) {
            addCriterion("crystal >", value, "crystal");
            return (Criteria) this;
        }

        public Criteria andCrystalGreaterThanOrEqualTo(Integer value) {
            addCriterion("crystal >=", value, "crystal");
            return (Criteria) this;
        }

        public Criteria andCrystalLessThan(Integer value) {
            addCriterion("crystal <", value, "crystal");
            return (Criteria) this;
        }

        public Criteria andCrystalLessThanOrEqualTo(Integer value) {
            addCriterion("crystal <=", value, "crystal");
            return (Criteria) this;
        }

        public Criteria andCrystalIn(List<Integer> values) {
            addCriterion("crystal in", values, "crystal");
            return (Criteria) this;
        }

        public Criteria andCrystalNotIn(List<Integer> values) {
            addCriterion("crystal not in", values, "crystal");
            return (Criteria) this;
        }

        public Criteria andCrystalBetween(Integer value1, Integer value2) {
            addCriterion("crystal between", value1, value2, "crystal");
            return (Criteria) this;
        }

        public Criteria andCrystalNotBetween(Integer value1, Integer value2) {
            addCriterion("crystal not between", value1, value2, "crystal");
            return (Criteria) this;
        }

        public Criteria andGoldIsNull() {
            addCriterion("gold is null");
            return (Criteria) this;
        }

        public Criteria andGoldIsNotNull() {
            addCriterion("gold is not null");
            return (Criteria) this;
        }

        public Criteria andGoldEqualTo(Integer value) {
            addCriterion("gold =", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotEqualTo(Integer value) {
            addCriterion("gold <>", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThan(Integer value) {
            addCriterion("gold >", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("gold >=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThan(Integer value) {
            addCriterion("gold <", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThanOrEqualTo(Integer value) {
            addCriterion("gold <=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldIn(List<Integer> values) {
            addCriterion("gold in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotIn(List<Integer> values) {
            addCriterion("gold not in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldBetween(Integer value1, Integer value2) {
            addCriterion("gold between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotBetween(Integer value1, Integer value2) {
            addCriterion("gold not between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andRoomcardIsNull() {
            addCriterion("roomCard is null");
            return (Criteria) this;
        }

        public Criteria andRoomcardIsNotNull() {
            addCriterion("roomCard is not null");
            return (Criteria) this;
        }

        public Criteria andRoomcardEqualTo(Integer value) {
            addCriterion("roomCard =", value, "roomcard");
            return (Criteria) this;
        }

        public Criteria andRoomcardNotEqualTo(Integer value) {
            addCriterion("roomCard <>", value, "roomcard");
            return (Criteria) this;
        }

        public Criteria andRoomcardGreaterThan(Integer value) {
            addCriterion("roomCard >", value, "roomcard");
            return (Criteria) this;
        }

        public Criteria andRoomcardGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomCard >=", value, "roomcard");
            return (Criteria) this;
        }

        public Criteria andRoomcardLessThan(Integer value) {
            addCriterion("roomCard <", value, "roomcard");
            return (Criteria) this;
        }

        public Criteria andRoomcardLessThanOrEqualTo(Integer value) {
            addCriterion("roomCard <=", value, "roomcard");
            return (Criteria) this;
        }

        public Criteria andRoomcardIn(List<Integer> values) {
            addCriterion("roomCard in", values, "roomcard");
            return (Criteria) this;
        }

        public Criteria andRoomcardNotIn(List<Integer> values) {
            addCriterion("roomCard not in", values, "roomcard");
            return (Criteria) this;
        }

        public Criteria andRoomcardBetween(Integer value1, Integer value2) {
            addCriterion("roomCard between", value1, value2, "roomcard");
            return (Criteria) this;
        }

        public Criteria andRoomcardNotBetween(Integer value1, Integer value2) {
            addCriterion("roomCard not between", value1, value2, "roomcard");
            return (Criteria) this;
        }

        public Criteria andFastcardIsNull() {
            addCriterion("fastCard is null");
            return (Criteria) this;
        }

        public Criteria andFastcardIsNotNull() {
            addCriterion("fastCard is not null");
            return (Criteria) this;
        }

        public Criteria andFastcardEqualTo(Integer value) {
            addCriterion("fastCard =", value, "fastcard");
            return (Criteria) this;
        }

        public Criteria andFastcardNotEqualTo(Integer value) {
            addCriterion("fastCard <>", value, "fastcard");
            return (Criteria) this;
        }

        public Criteria andFastcardGreaterThan(Integer value) {
            addCriterion("fastCard >", value, "fastcard");
            return (Criteria) this;
        }

        public Criteria andFastcardGreaterThanOrEqualTo(Integer value) {
            addCriterion("fastCard >=", value, "fastcard");
            return (Criteria) this;
        }

        public Criteria andFastcardLessThan(Integer value) {
            addCriterion("fastCard <", value, "fastcard");
            return (Criteria) this;
        }

        public Criteria andFastcardLessThanOrEqualTo(Integer value) {
            addCriterion("fastCard <=", value, "fastcard");
            return (Criteria) this;
        }

        public Criteria andFastcardIn(List<Integer> values) {
            addCriterion("fastCard in", values, "fastcard");
            return (Criteria) this;
        }

        public Criteria andFastcardNotIn(List<Integer> values) {
            addCriterion("fastCard not in", values, "fastcard");
            return (Criteria) this;
        }

        public Criteria andFastcardBetween(Integer value1, Integer value2) {
            addCriterion("fastCard between", value1, value2, "fastcard");
            return (Criteria) this;
        }

        public Criteria andFastcardNotBetween(Integer value1, Integer value2) {
            addCriterion("fastCard not between", value1, value2, "fastcard");
            return (Criteria) this;
        }

        public Criteria andCheattimesIsNull() {
            addCriterion("cheatTimes is null");
            return (Criteria) this;
        }

        public Criteria andCheattimesIsNotNull() {
            addCriterion("cheatTimes is not null");
            return (Criteria) this;
        }

        public Criteria andCheattimesEqualTo(Integer value) {
            addCriterion("cheatTimes =", value, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andCheattimesNotEqualTo(Integer value) {
            addCriterion("cheatTimes <>", value, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andCheattimesGreaterThan(Integer value) {
            addCriterion("cheatTimes >", value, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andCheattimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("cheatTimes >=", value, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andCheattimesLessThan(Integer value) {
            addCriterion("cheatTimes <", value, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andCheattimesLessThanOrEqualTo(Integer value) {
            addCriterion("cheatTimes <=", value, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andCheattimesIn(List<Integer> values) {
            addCriterion("cheatTimes in", values, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andCheattimesNotIn(List<Integer> values) {
            addCriterion("cheatTimes not in", values, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andCheattimesBetween(Integer value1, Integer value2) {
            addCriterion("cheatTimes between", value1, value2, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andCheattimesNotBetween(Integer value1, Integer value2) {
            addCriterion("cheatTimes not between", value1, value2, "cheattimes");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeIsNull() {
            addCriterion("banned_ChatExpiredTime is null");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeIsNotNull() {
            addCriterion("banned_ChatExpiredTime is not null");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeEqualTo(Integer value) {
            addCriterion("banned_ChatExpiredTime =", value, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeNotEqualTo(Integer value) {
            addCriterion("banned_ChatExpiredTime <>", value, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeGreaterThan(Integer value) {
            addCriterion("banned_ChatExpiredTime >", value, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("banned_ChatExpiredTime >=", value, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeLessThan(Integer value) {
            addCriterion("banned_ChatExpiredTime <", value, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeLessThanOrEqualTo(Integer value) {
            addCriterion("banned_ChatExpiredTime <=", value, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeIn(List<Integer> values) {
            addCriterion("banned_ChatExpiredTime in", values, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeNotIn(List<Integer> values) {
            addCriterion("banned_ChatExpiredTime not in", values, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeBetween(Integer value1, Integer value2) {
            addCriterion("banned_ChatExpiredTime between", value1, value2, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedChatexpiredtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("banned_ChatExpiredTime not between", value1, value2, "bannedChatexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeIsNull() {
            addCriterion("banned_LoginExpiredTime is null");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeIsNotNull() {
            addCriterion("banned_LoginExpiredTime is not null");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeEqualTo(Integer value) {
            addCriterion("banned_LoginExpiredTime =", value, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeNotEqualTo(Integer value) {
            addCriterion("banned_LoginExpiredTime <>", value, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeGreaterThan(Integer value) {
            addCriterion("banned_LoginExpiredTime >", value, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("banned_LoginExpiredTime >=", value, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeLessThan(Integer value) {
            addCriterion("banned_LoginExpiredTime <", value, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeLessThanOrEqualTo(Integer value) {
            addCriterion("banned_LoginExpiredTime <=", value, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeIn(List<Integer> values) {
            addCriterion("banned_LoginExpiredTime in", values, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeNotIn(List<Integer> values) {
            addCriterion("banned_LoginExpiredTime not in", values, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeBetween(Integer value1, Integer value2) {
            addCriterion("banned_LoginExpiredTime between", value1, value2, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedLoginexpiredtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("banned_LoginExpiredTime not between", value1, value2, "bannedLoginexpiredtime");
            return (Criteria) this;
        }

        public Criteria andBannedtimesIsNull() {
            addCriterion("bannedTimes is null");
            return (Criteria) this;
        }

        public Criteria andBannedtimesIsNotNull() {
            addCriterion("bannedTimes is not null");
            return (Criteria) this;
        }

        public Criteria andBannedtimesEqualTo(Integer value) {
            addCriterion("bannedTimes =", value, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andBannedtimesNotEqualTo(Integer value) {
            addCriterion("bannedTimes <>", value, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andBannedtimesGreaterThan(Integer value) {
            addCriterion("bannedTimes >", value, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andBannedtimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("bannedTimes >=", value, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andBannedtimesLessThan(Integer value) {
            addCriterion("bannedTimes <", value, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andBannedtimesLessThanOrEqualTo(Integer value) {
            addCriterion("bannedTimes <=", value, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andBannedtimesIn(List<Integer> values) {
            addCriterion("bannedTimes in", values, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andBannedtimesNotIn(List<Integer> values) {
            addCriterion("bannedTimes not in", values, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andBannedtimesBetween(Integer value1, Integer value2) {
            addCriterion("bannedTimes between", value1, value2, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andBannedtimesNotBetween(Integer value1, Integer value2) {
            addCriterion("bannedTimes not between", value1, value2, "bannedtimes");
            return (Criteria) this;
        }

        public Criteria andLastloginIsNull() {
            addCriterion("lastLogin is null");
            return (Criteria) this;
        }

        public Criteria andLastloginIsNotNull() {
            addCriterion("lastLogin is not null");
            return (Criteria) this;
        }

        public Criteria andLastloginEqualTo(Integer value) {
            addCriterion("lastLogin =", value, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastloginNotEqualTo(Integer value) {
            addCriterion("lastLogin <>", value, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastloginGreaterThan(Integer value) {
            addCriterion("lastLogin >", value, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastloginGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastLogin >=", value, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastloginLessThan(Integer value) {
            addCriterion("lastLogin <", value, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastloginLessThanOrEqualTo(Integer value) {
            addCriterion("lastLogin <=", value, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastloginIn(List<Integer> values) {
            addCriterion("lastLogin in", values, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastloginNotIn(List<Integer> values) {
            addCriterion("lastLogin not in", values, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastloginBetween(Integer value1, Integer value2) {
            addCriterion("lastLogin between", value1, value2, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastloginNotBetween(Integer value1, Integer value2) {
            addCriterion("lastLogin not between", value1, value2, "lastlogin");
            return (Criteria) this;
        }

        public Criteria andLastlogoutIsNull() {
            addCriterion("lastLogout is null");
            return (Criteria) this;
        }

        public Criteria andLastlogoutIsNotNull() {
            addCriterion("lastLogout is not null");
            return (Criteria) this;
        }

        public Criteria andLastlogoutEqualTo(Integer value) {
            addCriterion("lastLogout =", value, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andLastlogoutNotEqualTo(Integer value) {
            addCriterion("lastLogout <>", value, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andLastlogoutGreaterThan(Integer value) {
            addCriterion("lastLogout >", value, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andLastlogoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("lastLogout >=", value, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andLastlogoutLessThan(Integer value) {
            addCriterion("lastLogout <", value, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andLastlogoutLessThanOrEqualTo(Integer value) {
            addCriterion("lastLogout <=", value, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andLastlogoutIn(List<Integer> values) {
            addCriterion("lastLogout in", values, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andLastlogoutNotIn(List<Integer> values) {
            addCriterion("lastLogout not in", values, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andLastlogoutBetween(Integer value1, Integer value2) {
            addCriterion("lastLogout between", value1, value2, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andLastlogoutNotBetween(Integer value1, Integer value2) {
            addCriterion("lastLogout not between", value1, value2, "lastlogout");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeIsNull() {
            addCriterion("currentGameType is null");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeIsNotNull() {
            addCriterion("currentGameType is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeEqualTo(Integer value) {
            addCriterion("currentGameType =", value, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeNotEqualTo(Integer value) {
            addCriterion("currentGameType <>", value, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeGreaterThan(Integer value) {
            addCriterion("currentGameType >", value, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("currentGameType >=", value, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeLessThan(Integer value) {
            addCriterion("currentGameType <", value, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeLessThanOrEqualTo(Integer value) {
            addCriterion("currentGameType <=", value, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeIn(List<Integer> values) {
            addCriterion("currentGameType in", values, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeNotIn(List<Integer> values) {
            addCriterion("currentGameType not in", values, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeBetween(Integer value1, Integer value2) {
            addCriterion("currentGameType between", value1, value2, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andCurrentgametypeNotBetween(Integer value1, Integer value2) {
            addCriterion("currentGameType not between", value1, value2, "currentgametype");
            return (Criteria) this;
        }

        public Criteria andRefererIsNull() {
            addCriterion("referer is null");
            return (Criteria) this;
        }

        public Criteria andRefererIsNotNull() {
            addCriterion("referer is not null");
            return (Criteria) this;
        }

        public Criteria andRefererEqualTo(Integer value) {
            addCriterion("referer =", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotEqualTo(Integer value) {
            addCriterion("referer <>", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererGreaterThan(Integer value) {
            addCriterion("referer >", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererGreaterThanOrEqualTo(Integer value) {
            addCriterion("referer >=", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLessThan(Integer value) {
            addCriterion("referer <", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererLessThanOrEqualTo(Integer value) {
            addCriterion("referer <=", value, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererIn(List<Integer> values) {
            addCriterion("referer in", values, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotIn(List<Integer> values) {
            addCriterion("referer not in", values, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererBetween(Integer value1, Integer value2) {
            addCriterion("referer between", value1, value2, "referer");
            return (Criteria) this;
        }

        public Criteria andRefererNotBetween(Integer value1, Integer value2) {
            addCriterion("referer not between", value1, value2, "referer");
            return (Criteria) this;
        }

        public Criteria andFamilyidIsNull() {
            addCriterion("familyID is null");
            return (Criteria) this;
        }

        public Criteria andFamilyidIsNotNull() {
            addCriterion("familyID is not null");
            return (Criteria) this;
        }

        public Criteria andFamilyidEqualTo(Long value) {
            addCriterion("familyID =", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotEqualTo(Long value) {
            addCriterion("familyID <>", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidGreaterThan(Long value) {
            addCriterion("familyID >", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidGreaterThanOrEqualTo(Long value) {
            addCriterion("familyID >=", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidLessThan(Long value) {
            addCriterion("familyID <", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidLessThanOrEqualTo(Long value) {
            addCriterion("familyID <=", value, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidIn(List<Long> values) {
            addCriterion("familyID in", values, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotIn(List<Long> values) {
            addCriterion("familyID not in", values, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidBetween(Long value1, Long value2) {
            addCriterion("familyID between", value1, value2, "familyid");
            return (Criteria) this;
        }

        public Criteria andFamilyidNotBetween(Long value1, Long value2) {
            addCriterion("familyID not between", value1, value2, "familyid");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdIsNull() {
            addCriterion("onelevel_agents_id is null");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdIsNotNull() {
            addCriterion("onelevel_agents_id is not null");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdEqualTo(Integer value) {
            addCriterion("onelevel_agents_id =", value, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdNotEqualTo(Integer value) {
            addCriterion("onelevel_agents_id <>", value, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdGreaterThan(Integer value) {
            addCriterion("onelevel_agents_id >", value, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("onelevel_agents_id >=", value, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdLessThan(Integer value) {
            addCriterion("onelevel_agents_id <", value, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdLessThanOrEqualTo(Integer value) {
            addCriterion("onelevel_agents_id <=", value, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdIn(List<Integer> values) {
            addCriterion("onelevel_agents_id in", values, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdNotIn(List<Integer> values) {
            addCriterion("onelevel_agents_id not in", values, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdBetween(Integer value1, Integer value2) {
            addCriterion("onelevel_agents_id between", value1, value2, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andOnelevelAgentsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("onelevel_agents_id not between", value1, value2, "onelevelAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdIsNull() {
            addCriterion("top_agents_id is null");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdIsNotNull() {
            addCriterion("top_agents_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdEqualTo(Integer value) {
            addCriterion("top_agents_id =", value, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdNotEqualTo(Integer value) {
            addCriterion("top_agents_id <>", value, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdGreaterThan(Integer value) {
            addCriterion("top_agents_id >", value, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("top_agents_id >=", value, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdLessThan(Integer value) {
            addCriterion("top_agents_id <", value, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdLessThanOrEqualTo(Integer value) {
            addCriterion("top_agents_id <=", value, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdIn(List<Integer> values) {
            addCriterion("top_agents_id in", values, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdNotIn(List<Integer> values) {
            addCriterion("top_agents_id not in", values, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdBetween(Integer value1, Integer value2) {
            addCriterion("top_agents_id between", value1, value2, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andTopAgentsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("top_agents_id not between", value1, value2, "topAgentsId");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realName is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realName is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realName =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realName <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realName >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realName >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realName <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realName <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realName like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realName not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realName in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realName not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realName between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realName not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnumberIsNull() {
            addCriterion("realNumber is null");
            return (Criteria) this;
        }

        public Criteria andRealnumberIsNotNull() {
            addCriterion("realNumber is not null");
            return (Criteria) this;
        }

        public Criteria andRealnumberEqualTo(String value) {
            addCriterion("realNumber =", value, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberNotEqualTo(String value) {
            addCriterion("realNumber <>", value, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberGreaterThan(String value) {
            addCriterion("realNumber >", value, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberGreaterThanOrEqualTo(String value) {
            addCriterion("realNumber >=", value, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberLessThan(String value) {
            addCriterion("realNumber <", value, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberLessThanOrEqualTo(String value) {
            addCriterion("realNumber <=", value, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberLike(String value) {
            addCriterion("realNumber like", value, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberNotLike(String value) {
            addCriterion("realNumber not like", value, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberIn(List<String> values) {
            addCriterion("realNumber in", values, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberNotIn(List<String> values) {
            addCriterion("realNumber not in", values, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberBetween(String value1, String value2) {
            addCriterion("realNumber between", value1, value2, "realnumber");
            return (Criteria) this;
        }

        public Criteria andRealnumberNotBetween(String value1, String value2) {
            addCriterion("realNumber not between", value1, value2, "realnumber");
            return (Criteria) this;
        }

        public Criteria andZleroomcardIsNull() {
            addCriterion("zleRoomCard is null");
            return (Criteria) this;
        }

        public Criteria andZleroomcardIsNotNull() {
            addCriterion("zleRoomCard is not null");
            return (Criteria) this;
        }

        public Criteria andZleroomcardEqualTo(Integer value) {
            addCriterion("zleRoomCard =", value, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andZleroomcardNotEqualTo(Integer value) {
            addCriterion("zleRoomCard <>", value, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andZleroomcardGreaterThan(Integer value) {
            addCriterion("zleRoomCard >", value, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andZleroomcardGreaterThanOrEqualTo(Integer value) {
            addCriterion("zleRoomCard >=", value, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andZleroomcardLessThan(Integer value) {
            addCriterion("zleRoomCard <", value, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andZleroomcardLessThanOrEqualTo(Integer value) {
            addCriterion("zleRoomCard <=", value, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andZleroomcardIn(List<Integer> values) {
            addCriterion("zleRoomCard in", values, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andZleroomcardNotIn(List<Integer> values) {
            addCriterion("zleRoomCard not in", values, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andZleroomcardBetween(Integer value1, Integer value2) {
            addCriterion("zleRoomCard between", value1, value2, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andZleroomcardNotBetween(Integer value1, Integer value2) {
            addCriterion("zleRoomCard not between", value1, value2, "zleroomcard");
            return (Criteria) this;
        }

        public Criteria andRealRefererIsNull() {
            addCriterion("real_referer is null");
            return (Criteria) this;
        }

        public Criteria andRealRefererIsNotNull() {
            addCriterion("real_referer is not null");
            return (Criteria) this;
        }

        public Criteria andRealRefererEqualTo(Integer value) {
            addCriterion("real_referer =", value, "realReferer");
            return (Criteria) this;
        }

        public Criteria andRealRefererNotEqualTo(Integer value) {
            addCriterion("real_referer <>", value, "realReferer");
            return (Criteria) this;
        }

        public Criteria andRealRefererGreaterThan(Integer value) {
            addCriterion("real_referer >", value, "realReferer");
            return (Criteria) this;
        }

        public Criteria andRealRefererGreaterThanOrEqualTo(Integer value) {
            addCriterion("real_referer >=", value, "realReferer");
            return (Criteria) this;
        }

        public Criteria andRealRefererLessThan(Integer value) {
            addCriterion("real_referer <", value, "realReferer");
            return (Criteria) this;
        }

        public Criteria andRealRefererLessThanOrEqualTo(Integer value) {
            addCriterion("real_referer <=", value, "realReferer");
            return (Criteria) this;
        }

        public Criteria andRealRefererIn(List<Integer> values) {
            addCriterion("real_referer in", values, "realReferer");
            return (Criteria) this;
        }

        public Criteria andRealRefererNotIn(List<Integer> values) {
            addCriterion("real_referer not in", values, "realReferer");
            return (Criteria) this;
        }

        public Criteria andRealRefererBetween(Integer value1, Integer value2) {
            addCriterion("real_referer between", value1, value2, "realReferer");
            return (Criteria) this;
        }

        public Criteria andRealRefererNotBetween(Integer value1, Integer value2) {
            addCriterion("real_referer not between", value1, value2, "realReferer");
            return (Criteria) this;
        }

        public Criteria andWxUnionidIsNull() {
            addCriterion("wx_unionid is null");
            return (Criteria) this;
        }

        public Criteria andWxUnionidIsNotNull() {
            addCriterion("wx_unionid is not null");
            return (Criteria) this;
        }

        public Criteria andWxUnionidEqualTo(String value) {
            addCriterion("wx_unionid =", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotEqualTo(String value) {
            addCriterion("wx_unionid <>", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidGreaterThan(String value) {
            addCriterion("wx_unionid >", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_unionid >=", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidLessThan(String value) {
            addCriterion("wx_unionid <", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidLessThanOrEqualTo(String value) {
            addCriterion("wx_unionid <=", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidLike(String value) {
            addCriterion("wx_unionid like", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotLike(String value) {
            addCriterion("wx_unionid not like", value, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidIn(List<String> values) {
            addCriterion("wx_unionid in", values, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotIn(List<String> values) {
            addCriterion("wx_unionid not in", values, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidBetween(String value1, String value2) {
            addCriterion("wx_unionid between", value1, value2, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andWxUnionidNotBetween(String value1, String value2) {
            addCriterion("wx_unionid not between", value1, value2, "wxUnionid");
            return (Criteria) this;
        }

        public Criteria andFakeIsNull() {
            addCriterion("fake is null");
            return (Criteria) this;
        }

        public Criteria andFakeIsNotNull() {
            addCriterion("fake is not null");
            return (Criteria) this;
        }

        public Criteria andFakeEqualTo(Integer value) {
            addCriterion("fake =", value, "fake");
            return (Criteria) this;
        }

        public Criteria andFakeNotEqualTo(Integer value) {
            addCriterion("fake <>", value, "fake");
            return (Criteria) this;
        }

        public Criteria andFakeGreaterThan(Integer value) {
            addCriterion("fake >", value, "fake");
            return (Criteria) this;
        }

        public Criteria andFakeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fake >=", value, "fake");
            return (Criteria) this;
        }

        public Criteria andFakeLessThan(Integer value) {
            addCriterion("fake <", value, "fake");
            return (Criteria) this;
        }

        public Criteria andFakeLessThanOrEqualTo(Integer value) {
            addCriterion("fake <=", value, "fake");
            return (Criteria) this;
        }

        public Criteria andFakeIn(List<Integer> values) {
            addCriterion("fake in", values, "fake");
            return (Criteria) this;
        }

        public Criteria andFakeNotIn(List<Integer> values) {
            addCriterion("fake not in", values, "fake");
            return (Criteria) this;
        }

        public Criteria andFakeBetween(Integer value1, Integer value2) {
            addCriterion("fake between", value1, value2, "fake");
            return (Criteria) this;
        }

        public Criteria andFakeNotBetween(Integer value1, Integer value2) {
            addCriterion("fake not between", value1, value2, "fake");
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