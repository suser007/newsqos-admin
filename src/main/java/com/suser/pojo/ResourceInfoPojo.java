package com.suser.pojo;

import com.suser.entity.ResourceInfo;

public class ResourceInfoPojo {
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
    /**录取专业*/
    private String admission;
    /**所属学部*/
    private String division;
    /**学校是否第一志愿*/
    private String schoolisfirst;
    /**专业是否第一志愿*/
    private String professionalisfirst;
    /**学制类型*/
    private String schooling;
    /**年级*/
    private String grade;
    /**是否報道*/
    private String hasreports;
    /**家庭电话**/
    private String homephoto;

    public ResourceInfoPojo() {
    }

    public ResourceInfoPojo(ResourceInfo info, String admission, String division) {
        this.ksh = info.getKsh();
        this.name = info.getName();
        this.idcard = info.getIdcard();
        this.sex = info.getSex();
        this.zzmm = info.getZzmm();
        this.byzx = info.getByzx();
        this.bylb = info.getBylb();
        this.zcmc = info.getZcmc();
        this.jg = info.getJg();
        this.homeaddress = info.getHomeaddress();
        this.code = info.getCode();
        this.rewards = info.getRewards();
        this.results = info.getResults();
        this.schoolisfirst = info.getSchoolisfirst();
        this.professionalisfirst = info.getProfessionalisfirst();
        this.schooling = info.getSchooling();
        this.grade = info.getGrade();
        this.hasreports = info.getHasreports();
        this.homephoto = info.getHomephoto();

        this.admission = admission;
        this.division = division;
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

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
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
