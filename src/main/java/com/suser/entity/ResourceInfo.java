package com.suser.entity;

import com.suser.pojo.ResourceInfoPojo;

import java.util.Date;

/******
 * 生源信息 只提供查询
 */
public class ResourceInfo {
    /**考生号*/
    private String ksh;
    /**姓名*/
    private String name;
    /**身份证号*/
    private String idcard;
    /**性别*/
    private String sex;
    /**政治面貌*/
    private String zzmm;
    /**毕业中学*/
    private String byzx;
    /**毕业类别*/
    private String bylb;
    /**政策名称*/
    private String zcmc;
    /**籍贯*/
    private String jg;
    /**家庭住址*/
    private String homeaddress;
    /**邮政编码*/
    private String code;
    /**考生奖惩情况*/
    private String rewards;
    /**高考分数*/
    private String results;
    /**录取专业代码*/
    private String admissioncode;
    /**学校是否第一志愿*/
    private String schoolisfirst;
    /**专业是否第一志愿*/
    private String professionalisfirst;
    /**学制类型*/
    private String schooling;
    /**年级*/
    private String grade;
    /**是否报道*/
    private String hasreports;
    /**家庭电话**/
    private String homephoto;

    public ResourceInfo() {
    }

    public ResourceInfo(ResourceInfoPojo pojo,String admissioncode) {
        this.ksh = pojo.getKsh();
        this.name = pojo.getName();
        this.idcard = pojo.getIdcard();
        this.sex = pojo.getSex();
        this.zzmm = pojo.getZzmm();
        this.byzx = pojo.getByzx();
        this.bylb = pojo.getBylb();
        this.jg = pojo.getJg();
        this.homeaddress = pojo.getHomeaddress();
        this.results = pojo.getResults();
        this.schoolisfirst = pojo.getSchoolisfirst();
        this.professionalisfirst = pojo.getProfessionalisfirst();
        this.schooling = pojo.getSchooling();
        this.hasreports = pojo.getHasreports();
        this.homephoto = pojo.getHomephoto();

        this.admissioncode = admissioncode;
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZzmm() {
        return zzmm;
    }

    public void setZzmm(String zzmm) {
        this.zzmm = zzmm;
    }

    public String getByzx() {
        return byzx;
    }

    public void setByzx(String byzx) {
        this.byzx = byzx;
    }

    public String getBylb() {
        return bylb;
    }

    public void setBylb(String bylb) {
        this.bylb = bylb;
    }

    public String getZcmc() {
        return zcmc;
    }

    public void setZcmc(String zcmc) {
        this.zcmc = zcmc;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getAdmissioncode() {
        return admissioncode;
    }

    public void setAdmissioncode(String admissioncode) {
        this.admissioncode = admissioncode;
    }

    public String getSchoolisfirst() {
        return schoolisfirst;
    }

    public void setSchoolisfirst(String schoolisfirst) {
        this.schoolisfirst = schoolisfirst;
    }

    public String getProfessionalisfirst() {
        return professionalisfirst;
    }

    public void setProfessionalisfirst(String professionalisfirst) {
        this.professionalisfirst = professionalisfirst;
    }

    public String getSchooling() {
        return schooling;
    }

    public void setSchooling(String schooling) {
        this.schooling = schooling;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHasreports() {
        return hasreports;
    }

    public void setHasreports(String hasreports) {
        this.hasreports = hasreports;
    }

    public String getHomephoto() {
        return homephoto;
    }

    public void setHomephoto(String homephoto) {
        this.homephoto = homephoto;
    }
}
