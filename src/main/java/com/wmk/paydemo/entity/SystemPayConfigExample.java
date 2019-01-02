package com.wmk.paydemo.entity;

import java.util.ArrayList;
import java.util.List;

public class SystemPayConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemPayConfigExample() {
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

        public Criteria andSystemIdIsNull() {
            addCriterion("system_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemIdIsNotNull() {
            addCriterion("system_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemIdEqualTo(String value) {
            addCriterion("system_id =", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotEqualTo(String value) {
            addCriterion("system_id <>", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThan(String value) {
            addCriterion("system_id >", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdGreaterThanOrEqualTo(String value) {
            addCriterion("system_id >=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThan(String value) {
            addCriterion("system_id <", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLessThanOrEqualTo(String value) {
            addCriterion("system_id <=", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdLike(String value) {
            addCriterion("system_id like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotLike(String value) {
            addCriterion("system_id not like", value, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdIn(List<String> values) {
            addCriterion("system_id in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotIn(List<String> values) {
            addCriterion("system_id not in", values, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdBetween(String value1, String value2) {
            addCriterion("system_id between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemIdNotBetween(String value1, String value2) {
            addCriterion("system_id not between", value1, value2, "systemId");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNull() {
            addCriterion("system_name is null");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNotNull() {
            addCriterion("system_name is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNameEqualTo(String value) {
            addCriterion("system_name =", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotEqualTo(String value) {
            addCriterion("system_name <>", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThan(String value) {
            addCriterion("system_name >", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("system_name >=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThan(String value) {
            addCriterion("system_name <", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThanOrEqualTo(String value) {
            addCriterion("system_name <=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLike(String value) {
            addCriterion("system_name like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotLike(String value) {
            addCriterion("system_name not like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameIn(List<String> values) {
            addCriterion("system_name in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotIn(List<String> values) {
            addCriterion("system_name not in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameBetween(String value1, String value2) {
            addCriterion("system_name between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotBetween(String value1, String value2) {
            addCriterion("system_name not between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andFormatIsNull() {
            addCriterion("format is null");
            return (Criteria) this;
        }

        public Criteria andFormatIsNotNull() {
            addCriterion("format is not null");
            return (Criteria) this;
        }

        public Criteria andFormatEqualTo(String value) {
            addCriterion("format =", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotEqualTo(String value) {
            addCriterion("format <>", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatGreaterThan(String value) {
            addCriterion("format >", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatGreaterThanOrEqualTo(String value) {
            addCriterion("format >=", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLessThan(String value) {
            addCriterion("format <", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLessThanOrEqualTo(String value) {
            addCriterion("format <=", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLike(String value) {
            addCriterion("format like", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotLike(String value) {
            addCriterion("format not like", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatIn(List<String> values) {
            addCriterion("format in", values, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotIn(List<String> values) {
            addCriterion("format not in", values, "format");
            return (Criteria) this;
        }

        public Criteria andFormatBetween(String value1, String value2) {
            addCriterion("format between", value1, value2, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotBetween(String value1, String value2) {
            addCriterion("format not between", value1, value2, "format");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNull() {
            addCriterion("return_url is null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNotNull() {
            addCriterion("return_url is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlEqualTo(String value) {
            addCriterion("return_url =", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotEqualTo(String value) {
            addCriterion("return_url <>", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThan(String value) {
            addCriterion("return_url >", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("return_url >=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThan(String value) {
            addCriterion("return_url <", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThanOrEqualTo(String value) {
            addCriterion("return_url <=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLike(String value) {
            addCriterion("return_url like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotLike(String value) {
            addCriterion("return_url not like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIn(List<String> values) {
            addCriterion("return_url in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotIn(List<String> values) {
            addCriterion("return_url not in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlBetween(String value1, String value2) {
            addCriterion("return_url between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotBetween(String value1, String value2) {
            addCriterion("return_url not between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andCharsetIsNull() {
            addCriterion("charset is null");
            return (Criteria) this;
        }

        public Criteria andCharsetIsNotNull() {
            addCriterion("charset is not null");
            return (Criteria) this;
        }

        public Criteria andCharsetEqualTo(String value) {
            addCriterion("charset =", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotEqualTo(String value) {
            addCriterion("charset <>", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetGreaterThan(String value) {
            addCriterion("charset >", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetGreaterThanOrEqualTo(String value) {
            addCriterion("charset >=", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLessThan(String value) {
            addCriterion("charset <", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLessThanOrEqualTo(String value) {
            addCriterion("charset <=", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetLike(String value) {
            addCriterion("charset like", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotLike(String value) {
            addCriterion("charset not like", value, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetIn(List<String> values) {
            addCriterion("charset in", values, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotIn(List<String> values) {
            addCriterion("charset not in", values, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetBetween(String value1, String value2) {
            addCriterion("charset between", value1, value2, "charset");
            return (Criteria) this;
        }

        public Criteria andCharsetNotBetween(String value1, String value2) {
            addCriterion("charset not between", value1, value2, "charset");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNull() {
            addCriterion("sign_type is null");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNotNull() {
            addCriterion("sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andSignTypeEqualTo(String value) {
            addCriterion("sign_type =", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotEqualTo(String value) {
            addCriterion("sign_type <>", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThan(String value) {
            addCriterion("sign_type >", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_type >=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThan(String value) {
            addCriterion("sign_type <", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThanOrEqualTo(String value) {
            addCriterion("sign_type <=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLike(String value) {
            addCriterion("sign_type like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotLike(String value) {
            addCriterion("sign_type not like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeIn(List<String> values) {
            addCriterion("sign_type in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotIn(List<String> values) {
            addCriterion("sign_type not in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeBetween(String value1, String value2) {
            addCriterion("sign_type between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotBetween(String value1, String value2) {
            addCriterion("sign_type not between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignIsNull() {
            addCriterion("sign is null");
            return (Criteria) this;
        }

        public Criteria andSignIsNotNull() {
            addCriterion("sign is not null");
            return (Criteria) this;
        }

        public Criteria andSignEqualTo(String value) {
            addCriterion("sign =", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotEqualTo(String value) {
            addCriterion("sign <>", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThan(String value) {
            addCriterion("sign >", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignGreaterThanOrEqualTo(String value) {
            addCriterion("sign >=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThan(String value) {
            addCriterion("sign <", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLessThanOrEqualTo(String value) {
            addCriterion("sign <=", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignLike(String value) {
            addCriterion("sign like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotLike(String value) {
            addCriterion("sign not like", value, "sign");
            return (Criteria) this;
        }

        public Criteria andSignIn(List<String> values) {
            addCriterion("sign in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotIn(List<String> values) {
            addCriterion("sign not in", values, "sign");
            return (Criteria) this;
        }

        public Criteria andSignBetween(String value1, String value2) {
            addCriterion("sign between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andSignNotBetween(String value1, String value2) {
            addCriterion("sign not between", value1, value2, "sign");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(String value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(String value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(String value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(String value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(String value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(String value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLike(String value) {
            addCriterion("timestamp like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotLike(String value) {
            addCriterion("timestamp not like", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<String> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<String> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(String value1, String value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(String value1, String value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenIsNull() {
            addCriterion("app_auth_token is null");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenIsNotNull() {
            addCriterion("app_auth_token is not null");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenEqualTo(String value) {
            addCriterion("app_auth_token =", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenNotEqualTo(String value) {
            addCriterion("app_auth_token <>", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenGreaterThan(String value) {
            addCriterion("app_auth_token >", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenGreaterThanOrEqualTo(String value) {
            addCriterion("app_auth_token >=", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenLessThan(String value) {
            addCriterion("app_auth_token <", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenLessThanOrEqualTo(String value) {
            addCriterion("app_auth_token <=", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenLike(String value) {
            addCriterion("app_auth_token like", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenNotLike(String value) {
            addCriterion("app_auth_token not like", value, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenIn(List<String> values) {
            addCriterion("app_auth_token in", values, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenNotIn(List<String> values) {
            addCriterion("app_auth_token not in", values, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenBetween(String value1, String value2) {
            addCriterion("app_auth_token between", value1, value2, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andAppAuthTokenNotBetween(String value1, String value2) {
            addCriterion("app_auth_token not between", value1, value2, "appAuthToken");
            return (Criteria) this;
        }

        public Criteria andBizContentIsNull() {
            addCriterion("biz_content is null");
            return (Criteria) this;
        }

        public Criteria andBizContentIsNotNull() {
            addCriterion("biz_content is not null");
            return (Criteria) this;
        }

        public Criteria andBizContentEqualTo(String value) {
            addCriterion("biz_content =", value, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentNotEqualTo(String value) {
            addCriterion("biz_content <>", value, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentGreaterThan(String value) {
            addCriterion("biz_content >", value, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentGreaterThanOrEqualTo(String value) {
            addCriterion("biz_content >=", value, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentLessThan(String value) {
            addCriterion("biz_content <", value, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentLessThanOrEqualTo(String value) {
            addCriterion("biz_content <=", value, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentLike(String value) {
            addCriterion("biz_content like", value, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentNotLike(String value) {
            addCriterion("biz_content not like", value, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentIn(List<String> values) {
            addCriterion("biz_content in", values, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentNotIn(List<String> values) {
            addCriterion("biz_content not in", values, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentBetween(String value1, String value2) {
            addCriterion("biz_content between", value1, value2, "bizContent");
            return (Criteria) this;
        }

        public Criteria andBizContentNotBetween(String value1, String value2) {
            addCriterion("biz_content not between", value1, value2, "bizContent");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyIsNull() {
            addCriterion("RSA_PRIVATE_KEY is null");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyIsNotNull() {
            addCriterion("RSA_PRIVATE_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyEqualTo(String value) {
            addCriterion("RSA_PRIVATE_KEY =", value, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyNotEqualTo(String value) {
            addCriterion("RSA_PRIVATE_KEY <>", value, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyGreaterThan(String value) {
            addCriterion("RSA_PRIVATE_KEY >", value, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("RSA_PRIVATE_KEY >=", value, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyLessThan(String value) {
            addCriterion("RSA_PRIVATE_KEY <", value, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("RSA_PRIVATE_KEY <=", value, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyLike(String value) {
            addCriterion("RSA_PRIVATE_KEY like", value, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyNotLike(String value) {
            addCriterion("RSA_PRIVATE_KEY not like", value, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyIn(List<String> values) {
            addCriterion("RSA_PRIVATE_KEY in", values, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyNotIn(List<String> values) {
            addCriterion("RSA_PRIVATE_KEY not in", values, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyBetween(String value1, String value2) {
            addCriterion("RSA_PRIVATE_KEY between", value1, value2, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andRsaPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("RSA_PRIVATE_KEY not between", value1, value2, "rsaPrivateKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyIsNull() {
            addCriterion("ALIPAY_PUBLIC_KEY is null");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyIsNotNull() {
            addCriterion("ALIPAY_PUBLIC_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyEqualTo(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY =", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotEqualTo(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY <>", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyGreaterThan(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY >", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY >=", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyLessThan(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY <", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY <=", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyLike(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY like", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotLike(String value) {
            addCriterion("ALIPAY_PUBLIC_KEY not like", value, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyIn(List<String> values) {
            addCriterion("ALIPAY_PUBLIC_KEY in", values, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotIn(List<String> values) {
            addCriterion("ALIPAY_PUBLIC_KEY not in", values, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyBetween(String value1, String value2) {
            addCriterion("ALIPAY_PUBLIC_KEY between", value1, value2, "alipayPublicKey");
            return (Criteria) this;
        }

        public Criteria andAlipayPublicKeyNotBetween(String value1, String value2) {
            addCriterion("ALIPAY_PUBLIC_KEY not between", value1, value2, "alipayPublicKey");
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