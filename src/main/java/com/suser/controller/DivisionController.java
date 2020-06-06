package com.suser.controller;

import com.suser.entity.Division;
import com.suser.interceptor.UserLoginToken;
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
@RequestMapping(value = "/division",method = RequestMethod.GET)
public class DivisionController {
    @Autowired
    DivisionService divisionService;
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public List<Division> getList(Division division, HttpServletRequest request, HttpServletResponse response){
        return divisionService.getList(division);
    }
}
