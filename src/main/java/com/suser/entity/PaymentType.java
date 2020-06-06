package com.suser.entity;

/***
 * 缴费情况
 */
public class PaymentType {
    /**考生号*/
    private String ksh;
    /**目前缴费情况*/
    private String type;
    /**是否报道*/
    private String issignup;

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIssignup() {
        return issignup;
    }

    public void setIssignup(String issignup) {
        this.issignup = issignup;
    }
}
