package com.suser.entity;

import com.suser.pojo.ClassesPojo;

public class Classes {
    private String ksh;
    private String studentNum;
    private String classesNum;

    public Classes() {
    }

    public Classes(ClassesPojo classesPojo) {
        this.ksh = classesPojo.getKsh();
        this.studentNum = classesPojo.getStudentNum();
        this.classesNum = classesPojo.getClassesNum();
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

    public String getClassesNum() {
        return classesNum;
    }

    public void setClassesNum(String classesNum) {
        this.classesNum = classesNum;
    }
}
