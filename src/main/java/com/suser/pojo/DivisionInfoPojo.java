package com.suser.pojo;

import java.io.File;
import java.util.List;

/***学部的报到率信息**/
public class DivisionInfoPojo {
    private String divisionName;   //学部名字
    private int studentCount;  //学生人数
    private int hasBeenReportsCount; //已报到人数

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getHasBeenReportsCount() {
        return hasBeenReportsCount;
    }

    public void setHasBeenReportsCount(int hasBeenReportsCount) {
        this.hasBeenReportsCount = hasBeenReportsCount;
    }
}
