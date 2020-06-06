package com.suser.pojo;

public class ClassesPojo {
    private String ksh;
    private String studentNum;
    private String name;
    private String sex;
    private String jg;
    private String admission;
    private String division;
    private String classesNum;
    private String hasReports;
    private String homePhoto;

    public ClassesPojo() {
    }

    public ClassesPojo(String ksh, String studentNum, String name, String sex, String jg, String admission, String division, String classesNum, String hasReports, String homePhoto) {
        this.ksh = ksh;
        this.studentNum = studentNum;
        this.name = name;
        this.sex = sex;
        this.jg = jg;
        this.admission = admission;
        this.division = division;
        this.classesNum = classesNum;
        this.hasReports = hasReports;
        this.homePhoto = homePhoto;
    }

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
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

    public String getClassesNum() {
        return classesNum;
    }

    public void setClassesNum(String classesNum) {
        this.classesNum = classesNum;
    }

    public String getHasReports() {
        return hasReports;
    }

    public void setHasReports(String hasReports) {
        this.hasReports = hasReports;
    }

    public String getHomePhoto() {
        return homePhoto;
    }

    public void setHomePhoto(String homePhoto) {
        this.homePhoto = homePhoto;
    }
}
