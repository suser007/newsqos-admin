package com.suser.mapper;

import com.suser.entity.Admission;

import java.util.List;

public interface AdmissionMapper {
    public List<Admission> getList(Admission info);
    public void addOneAdmission(Admission info);
    public String getAdmission(String code);
    public String getCode(String admissionname);
}
