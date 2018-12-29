package com.wmk.paydemo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemRefundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemRefundExample() {
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

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdIsNull() {
            addCriterion("buyer_logon_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdIsNotNull() {
            addCriterion("buyer_logon_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdEqualTo(String value) {
            addCriterion("buyer_logon_id =", value, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdNotEqualTo(String value) {
            addCriterion("buyer_logon_id <>", value, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdGreaterThan(String value) {
            addCriterion("buyer_logon_id >", value, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_logon_id >=", value, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdLessThan(String value) {
            addCriterion("buyer_logon_id <", value, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdLessThanOrEqualTo(String value) {
            addCriterion("buyer_logon_id <=", value, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdLike(String value) {
            addCriterion("buyer_logon_id like", value, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdNotLike(String value) {
            addCriterion("buyer_logon_id not like", value, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdIn(List<String> values) {
            addCriterion("buyer_logon_id in", values, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdNotIn(List<String> values) {
            addCriterion("buyer_logon_id not in", values, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdBetween(String value1, String value2) {
            addCriterion("buyer_logon_id between", value1, value2, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerLogonIdNotBetween(String value1, String value2) {
            addCriterion("buyer_logon_id not between", value1, value2, "buyerLogonId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdIsNull() {
            addCriterion("buyer_user_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdIsNotNull() {
            addCriterion("buyer_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdEqualTo(String value) {
            addCriterion("buyer_user_id =", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdNotEqualTo(String value) {
            addCriterion("buyer_user_id <>", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdGreaterThan(String value) {
            addCriterion("buyer_user_id >", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_user_id >=", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdLessThan(String value) {
            addCriterion("buyer_user_id <", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdLessThanOrEqualTo(String value) {
            addCriterion("buyer_user_id <=", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdLike(String value) {
            addCriterion("buyer_user_id like", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdNotLike(String value) {
            addCriterion("buyer_user_id not like", value, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdIn(List<String> values) {
            addCriterion("buyer_user_id in", values, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdNotIn(List<String> values) {
            addCriterion("buyer_user_id not in", values, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdBetween(String value1, String value2) {
            addCriterion("buyer_user_id between", value1, value2, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andBuyerUserIdNotBetween(String value1, String value2) {
            addCriterion("buyer_user_id not between", value1, value2, "buyerUserId");
            return (Criteria) this;
        }

        public Criteria andFundChangeIsNull() {
            addCriterion("fund_change is null");
            return (Criteria) this;
        }

        public Criteria andFundChangeIsNotNull() {
            addCriterion("fund_change is not null");
            return (Criteria) this;
        }

        public Criteria andFundChangeEqualTo(String value) {
            addCriterion("fund_change =", value, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeNotEqualTo(String value) {
            addCriterion("fund_change <>", value, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeGreaterThan(String value) {
            addCriterion("fund_change >", value, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeGreaterThanOrEqualTo(String value) {
            addCriterion("fund_change >=", value, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeLessThan(String value) {
            addCriterion("fund_change <", value, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeLessThanOrEqualTo(String value) {
            addCriterion("fund_change <=", value, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeLike(String value) {
            addCriterion("fund_change like", value, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeNotLike(String value) {
            addCriterion("fund_change not like", value, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeIn(List<String> values) {
            addCriterion("fund_change in", values, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeNotIn(List<String> values) {
            addCriterion("fund_change not in", values, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeBetween(String value1, String value2) {
            addCriterion("fund_change between", value1, value2, "fundChange");
            return (Criteria) this;
        }

        public Criteria andFundChangeNotBetween(String value1, String value2) {
            addCriterion("fund_change not between", value1, value2, "fundChange");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayIsNull() {
            addCriterion("gmt_refund_pay is null");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayIsNotNull() {
            addCriterion("gmt_refund_pay is not null");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayEqualTo(Date value) {
            addCriterion("gmt_refund_pay =", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayNotEqualTo(Date value) {
            addCriterion("gmt_refund_pay <>", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayGreaterThan(Date value) {
            addCriterion("gmt_refund_pay >", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_refund_pay >=", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayLessThan(Date value) {
            addCriterion("gmt_refund_pay <", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayLessThanOrEqualTo(Date value) {
            addCriterion("gmt_refund_pay <=", value, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayIn(List<Date> values) {
            addCriterion("gmt_refund_pay in", values, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayNotIn(List<Date> values) {
            addCriterion("gmt_refund_pay not in", values, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayBetween(Date value1, Date value2) {
            addCriterion("gmt_refund_pay between", value1, value2, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andGmtRefundPayNotBetween(Date value1, Date value2) {
            addCriterion("gmt_refund_pay not between", value1, value2, "gmtRefundPay");
            return (Criteria) this;
        }

        public Criteria andRefundFeeIsNull() {
            addCriterion("refund_fee is null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeIsNotNull() {
            addCriterion("refund_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeEqualTo(Double value) {
            addCriterion("refund_fee =", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNotEqualTo(Double value) {
            addCriterion("refund_fee <>", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeGreaterThan(Double value) {
            addCriterion("refund_fee >", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("refund_fee >=", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLessThan(Double value) {
            addCriterion("refund_fee <", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLessThanOrEqualTo(Double value) {
            addCriterion("refund_fee <=", value, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeIn(List<Double> values) {
            addCriterion("refund_fee in", values, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNotIn(List<Double> values) {
            addCriterion("refund_fee not in", values, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeBetween(Double value1, Double value2) {
            addCriterion("refund_fee between", value1, value2, "refundFee");
            return (Criteria) this;
        }

        public Criteria andRefundFeeNotBetween(Double value1, Double value2) {
            addCriterion("refund_fee not between", value1, value2, "refundFee");
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