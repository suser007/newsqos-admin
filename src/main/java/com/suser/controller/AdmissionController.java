package com.suser.controller;

import com.suser.entity.Admission;
import com.suser.interceptor.UserLoginToken;
import com.suser.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@UserLoginToken
@RestController
@EnableAutoConfiguration
@RequestMapping("/admission")
public class AdmissionController {
    @Autowired
    AdmissionService admissionService;
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public List<Admission> getList(Admission admission, HttpServletRequest request, HttpServletResponse response){
        Admission a = admission;
        return admissionService.getList(admission);
    }
}
