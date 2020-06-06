package com.suser.mapper;

import com.suser.entity.Division;

import java.util.List;

public interface DivisionMapper {
    List<Division> getList(Division division);
    String getDivisionName(String admissioncode);
    String getDivisionCode(String divisionname);
}
