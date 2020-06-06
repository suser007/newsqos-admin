package com.suser.controller;

import com.alibaba.fastjson.JSONObject;
import com.suser.entity.Admission;
import com.suser.entity.Division;
import com.suser.entity.ResourceInfo;
import com.suser.interceptor.UserLoginToken;
import com.suser.pojo.ResourceInfoPojo;
import com.suser.service.AdmissionService;
import com.suser.service.DivisionService;
import com.suser.service.ResourceInfoService;
import org.apache.ibatis.annotations.Param;
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
@RequestMapping("/resource")
public class QueryController {
    @Autowired
    ResourceInfoService resourceInfoService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    AdmissionService admissionService;
    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public Object getList(ResourceInfoPojo pojo, HttpServletRequest request, HttpServletResponse response){
        //1.创建JSONObject
        JSONObject jsonObject = new JSONObject();
        //2.请求处理
        List<ResourceInfoPojo> infoList = resourceInfoService.getList(pojo);
        List<Admission> admissionsList = admissionService.getList(new Admission());
        List<Division> divisionsList = divisionService.getList(new Division());
        jsonObject.put("infoList",infoList);
        jsonObject.put("admissionsList",admissionsList);
        jsonObject.put("divisionsList",divisionsList);
        return jsonObject;
    }
    @RequestMapping(value = "/getResource",method = RequestMethod.GET)
    public Object getResourceByKsh(String admission,HttpServletRequest request,HttpServletResponse response){
        ResourceInfoPojo resourceInfoPojo = new ResourceInfoPojo();
        resourceInfoPojo.setAdmission(admission);
        JSONObject jsonObject = new JSONObject();
        List<ResourceInfoPojo> infoList = resourceInfoService.getList(resourceInfoPojo);
        jsonObject.put("infoList",infoList);
        return jsonObject;
    }
    /**转专业*/
    @UserLoginToken
    @RequestMapping(value = "/updateAdmission", method = RequestMethod.POST)
    public void update(@Param("ksh") String ksh,
                       @Param("admission") String admission,
                       HttpServletRequest request,
                       HttpServletResponse response){
        resourceInfoService.updateAdmission(ksh,admission);
    }

    @UserLoginToken
    @RequestMapping(value = "/batchToAdmission", method = RequestMethod.POST)
    public void batchToAdmission(
            @Param("selectResourceInfo") String params,
            @Param("currentlySelectedAdmission") String admission,
            HttpServletResponse response,
            HttpServletRequest request){
        System.out.println(params);
        System.out.println(admission);
    }
}
