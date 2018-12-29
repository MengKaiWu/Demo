package com.wmk.paydemo.entity;

public class Refundmsg {
    private String out_trade_no;
    private String trade_no;
    private String refund_amount;
    private String refund_currency;
    private String refund_reason;
    private String out_request_no;
    private String operator_id;
    private String store_id;
    private String terminal_id;
    private String org_pid;

    public Refundmsg() {
    }

    public Refundmsg(String out_trade_no, String trade_no, String refund_amount, String refund_currency, String refund_reason, String out_request_no, String operator_id, String store_id, String terminal_id, String org_pid) {
        this.out_trade_no = out_trade_no;
        this.trade_no = trade_no;
        this.refund_amount = refund_amount;
        this.refund_currency = refund_currency;
        this.refund_reason = refund_reason;
        this.out_request_no = out_request_no;
        this.operator_id = operator_id;
        this.store_id = store_id;
        this.terminal_id = terminal_id;
        this.org_pid = org_pid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(String refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getRefund_currency() {
        return refund_currency;
    }

    public void setRefund_currency(String refund_currency) {
        this.refund_currency = refund_currency;
    }

    public String getRefund_reason() {
        return refund_reason;
    }

    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

    public String getOut_request_no() {
        return out_request_no;
    }

    public void setOut_request_no(String out_request_no) {
        this.out_request_no = out_request_no;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public String getOrg_pid() {
        return org_pid;
    }

    public void setOrg_pid(String org_pid) {
        this.org_pid = org_pid;
    }
}
