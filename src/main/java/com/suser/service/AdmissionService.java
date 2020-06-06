package com.suser.service;

import com.suser.entity.Admission;
import com.suser.mapper.AdmissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {
    @Autowired
    private AdmissionMapper admissionMapper;
    public List<Admission> getList(Admission admission){
        return admissionMapper.getList(admission);
    }
}
