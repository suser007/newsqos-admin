package com.suser.controller;

import com.alibaba.fastjson.JSONObject;
import com.suser.entity.Roles;
import com.suser.interceptor.UserLoginToken;
import com.suser.service.RolesService;
import com.suser.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    RolesService roleService;
    @UserLoginToken
    @RequestMapping(value = "/getRole",method = RequestMethod.GET)
    public Object getRole(HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
//        1.获取权限列表 2.遍历 3.返回数组
        try{
            List<Roles> roleList = roleService.getRolesByUsername(TokenUtil.getTokenUsername());
            String[] roleArray = new String[roleList.size()];
            for (int i = 0; i < roleArray.length; i++) {
                roleArray[i] = roleList.get(i).getRole();
            }
            jsonObject.put("roleArray",roleArray);
            jsonObject.put("success","已检查角色");
        }catch (NullPointerException n){
            jsonObject.put("error","没有查询到您的角色信息,建议您检查数据库外键");
        }
        return jsonObject;
    }

    @UserLoginToken
    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public Object getList(Roles role,HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("roleList",roleService.getList(role));
        jsonObject.put("success","成功获取用户角色");
        return jsonObject;
    }

    @UserLoginToken
    @PostMapping("/addRole")
    public Object addRole(Roles role,HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        roleService.addRole(role);
        jsonObject.put("success","添加权限成功");
        return jsonObject;
    }
}
