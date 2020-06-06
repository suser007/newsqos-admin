package com.suser.controller;

import com.alibaba.fastjson.JSONObject;
import com.suser.entity.Users;
import com.suser.interceptor.UserLoginToken;
import com.suser.service.RolesService;
import com.suser.service.TokenService;
import com.suser.service.UserService;
import com.suser.service.UsersService;
import com.suser.util.TokenUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/****
 * 职工接口：：：登录 注销
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    @Autowired
    TokenService tokenService;
    @Autowired
    UsersService userService;
    @Autowired
    RolesService roleService;

    @UserLoginToken
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Object getInfo(HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
//        1.token -> username  2.根据username查询User对象 3.根据username查询角色role 4.返回User对象与角色的JSON数据
        String username = TokenUtil.getTokenUsername();
        Users user = userService.getUserByUsername(username);
        jsonObject.put("user",userService.getUserByUsername(username));
        jsonObject.put("roles",roleService.getRolesArrayByUsername(username));
        jsonObject.put("success","获取用户信息成功，当前用户 "+user.getName());
        return jsonObject;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public Object logout(HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success","注销成功");
        return jsonObject;
    }

    @UserLoginToken
    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public Object getMessage(HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", "Token认证成功");
        jsonObject.put("username from token", TokenUtil.getTokenUsername());
        return jsonObject;
    }

    @UserLoginToken
    @GetMapping(value = "/getList")
    public Object getList(Users user,HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userList",userService.getList(user));
        jsonObject.put("success","查询用户成功");
        return jsonObject;
    }

    @UserLoginToken
    @PostMapping("/addUser")
    public Object addUser(Users user,HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        if (userService.judgeExistenceOfUsername(user.getUsername())
                && userService.judgeExistenceOfWorker(user.getWorker())){
            jsonObject.put("error","用户名和员工号已存在，不能同时存在两个相同的用户名");
            return jsonObject;
        }else if(!userService.judgeExistenceOfUsername(user.getUsername())
                && userService.judgeExistenceOfWorker(user.getWorker())){
            jsonObject.put("error","员工号已存在，不能同时存在两个相同的用户名");
            return jsonObject;
        }else if (userService.judgeExistenceOfUsername(user.getUsername())
                && !userService.judgeExistenceOfWorker(user.getWorker())){
            jsonObject.put("error","用户名已存在，不能同时存在两个相同的用户名");
            return jsonObject;
        }else {
            jsonObject.put("success","添加用户成功");
            userService.addUser(user);
            return jsonObject;
        }
    }

    @UserLoginToken
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public Object updateUser(Users user,HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        userService.updateUser(user);
        jsonObject.put("success","成功修改用户信息");
        return jsonObject;
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public Object deleteUser(String worker,HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        userService.deleteUser(worker);
        jsonObject.put("success","删除用户"+worker+"成功");
        return jsonObject;
    }

    @UserLoginToken
    @RequestMapping(value = "/deleteUsers", method = RequestMethod.GET)
    public Object deleteUsers(String workers, HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        String[] workerArray = workers.trim().split(" ");
        userService.deleteUsers(workerArray);
        jsonObject.put("success","批量删除成功");
        return jsonObject;
    }

    /**头像上传调用接口*/
    @UserLoginToken
    @PostMapping("/uploadAvatar")
    public void uploadAvatar(HttpServletRequest request, HttpServletResponse response, @Param("avatar") MultipartFile avatar) throws Exception {
        MultipartFile image = avatar;
        userService.uploadAvatar(image);
    }

    /**服务器返回本地的头像数据 由浏览器发送请求*/
    @RequestMapping(value = "/getAvatar/{username}/{date}",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(@PathVariable String username, @PathVariable String date) throws IOException {
        File file = new File("D:\\lawyers\\avatar\\"+username+"\\"+date+"\\avatar.png");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }

    /**修改密码*/
    @UserLoginToken
    @GetMapping("/changePassword")
    public Object changePassword(String password,HttpServletRequest request,HttpServletResponse response){
        JSONObject jsonObject = new JSONObject();
        userService.changePassword(password);
        jsonObject.put("success","密码已成功修改");
        return jsonObject;
    }
}
