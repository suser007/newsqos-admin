package com.suser.entity;

/***
 * 专业代码
 */
public class Admission {
    /**代码*/
    private String admissioncode;
    /**专业名称*/
    private String admissionname;
    /*** 所屬專業 */
    private String belongdivision;

    public String getBelongdivision() {
        return belongdivision;
    }

    public void setBelongdivision(String belongdivision) {
        this.belongdivision = belongdivision;
    }

    public String getAdmissioncode() {
        return admissioncode;
    }

    public void setAdmissioncode(String admissioncode) {
        this.admissioncode = admissioncode;
    }

    public String getAdmissionname() {
        return admissionname;
    }

    public void setAdmissionname(String admissionname) {
        this.admissionname = admissionname;
    }
}
