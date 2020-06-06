package com.suser.controller;

import com.alibaba.fastjson.JSONObject;
import com.suser.entity.Admission;
import com.suser.entity.Division;
import com.suser.interceptor.UserLoginToken;
import com.suser.mapper.ClassesMapper;
import com.suser.pojo.ClassesPojo;
import com.suser.service.AdmissionService;
import com.suser.service.ClassesService;
import com.suser.service.DivisionService;
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
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    ClassesService classesService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    AdmissionService admissionService;
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Object query(ClassesPojo classesPojo, HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("admissionsList",admissionService.getList(new Admission()));
        jsonObject.put("divisionsList",divisionService.getList(new Division()));
        jsonObject.put("studentInfo",classesService.getClassesInfo(classesPojo));
        return jsonObject;
    }
    @RequestMapping(value = "/divideClasses",method = RequestMethod.POST)
    public void divideClasses(HttpServletRequest request, HttpServletResponse response){
        classesService.divideClasses();
    }
}
