package com.suser.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suser.entity.User;
import com.suser.entity.Users;
import com.suser.interceptor.UserLoginToken;
import com.suser.service.RolesService;
import com.suser.service.TokenService;
import com.suser.service.UserService;
import com.suser.service.UsersService;
import com.suser.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class Login {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    @Autowired
    UsersService usersService;
    @Autowired
    RolesService rolesService;
    private Logger logger = LoggerFactory.getLogger(Login.class);

//    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
//    public Object login(User user, HttpServletResponse response){
//        logger.info("login be run");
//        JSONObject jsonObject = new JSONObject();
//        /** 查询，存储对象到userForBase **/
//        User userForBase = new User();
//        userForBase.setId(userService.findByUser(user).getId());
//        userForBase.setUsername(userService.findByUser(user).getUsername());
//        userForBase.setPassword(userService.findByUser(user).getPassword());
//        userForBase.setName(userService.findByUser(user).getName());
//        /** **  ********************  **/
//        if (!userForBase.getPassword().equals(user.getPassword())){
//            jsonObject.put("message","login fail,again~~~");
//            return jsonObject;
//        }else {
//            String token = tokenService.getToken(userForBase);
//            jsonObject.put("message","login success,again~~~");
//            jsonObject.put("token",token);
//            jsonObject.put("name",userForBase.getName());
//            Cookie cookie = new Cookie("token",token);
//            cookie.setPath("/");
//            response.addCookie(cookie);
//            return jsonObject;
//        }
//    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(Users user, HttpServletRequest request,HttpServletResponse response){
        System.out.println("login be run");
        JSONObject jsonObject = new JSONObject();
        Users userBase = new Users();
//        验证用户存在性
        if(usersService.getUserByUsername(user.getUsername()) == null){
            jsonObject.put("message","The password or username is error!");
            return jsonObject;
        }else{
            userBase = usersService.getUserByUsername(user.getUsername());
        }
        //验证密码正确性
        if(!userBase.getPassword().equals(user.getPassword())){
            jsonObject.put("message","The password or username is error!");
        }else {
            String token = tokenService.getToken(userBase);
            jsonObject.put("success","Login success and please away you token!");
            jsonObject.put("token",token);
        }
//        生成Token
        return jsonObject;
    }

//    @UserLoginToken
//    @RequestMapping(value = "/info",method = RequestMethod.GET)
//    public Object getInfo(HttpServletRequest request,HttpServletResponse response){
//        JSONObject jsonObject = new JSONObject();
//        String username = TokenUtil.getTokenUsername();
//        Users user = usersService.getUserByUsername(username);
//        jsonObject.put("introduction",user.getIntroduction());
//        jsonObject.put("avatar",user.getAvatar());
//        jsonObject.put("name",user.getName());
//        //根据username role
//        List<String> roles = new ArrayList<>();
//        if(rolesService.getRoles(username).size() == 0){
//            logger.error("存在用户没分配基础权限:"+username);
//        }else {
//            roles = rolesService.getRoles(username);
//            String[] rolesArr = new String[roles.size()];
//            for (int i = 0; i < roles.size(); i++) {
//                rolesArr[i] = roles.get(i);
//            }
//            jsonObject.put("roles",rolesArr);
//        }
//        return jsonObject;
//    }
////    @UserLoginToken
//    @RequestMapping(value = "/logout",method = RequestMethod.POST)
//    public Object logout(HttpServletRequest request,HttpServletResponse response){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("success","You has been logout! Please login in again");
//        return jsonObject;
//    }
//
//    @UserLoginToken
//    @RequestMapping(value = "/getMessage" ,method = RequestMethod.GET)
//    public String getMessage(){
//        System.out.println("Token username: "+TokenUtil.getTokenUsername());
//        return "You have passed the verification";
//    }
}
