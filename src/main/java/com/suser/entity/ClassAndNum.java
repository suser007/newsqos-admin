package com.suser.entity;

/***
 * 分班后数据
 */
public class ClassAndNum {
    /**考生号*/
    private String ksh;
    /**学号*/
    private String studentid;
    /**班级号，几班*/
    private String classid;
    /**专业代码*/
    private String professional;
    /**年级*/
    private String grade;
    /**是否报道*/
    private String issignup;
    /**高考成绩*/
    private int results;

    public String getKsh() {
        return ksh;
    }

    public void setKsh(String ksh) {
        this.ksh = ksh;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIssignup() {
        return issignup;
    }

    public void setIssignup(String issignup) {
        this.issignup = issignup;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }
}
