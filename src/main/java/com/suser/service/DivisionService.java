package com.suser.service;

import com.suser.entity.Division;
import com.suser.mapper.DivisionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionService {
    @Autowired
    private DivisionMapper divisionMapper;


    public List<Division> getList(Division division){
        return divisionMapper.getList(division);
    }
}
