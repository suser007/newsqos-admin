package com.suser.service;

import com.suser.config.IpConfig;
import com.suser.entity.Users;
import com.suser.mapper.RolesMapper;
import com.suser.mapper.UsersMapper;
import com.suser.util.DESEncryption;
import com.suser.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    IpConfig ip;
    public Users getUserByUsername(String username) {
        Users result = usersMapper.getUserByUsername(username);
        result.setPassword(DESEncryption.getDecryptString(result.getPassword()));
        return result;
    }

    /***
     * 查询用户信息
     * @param user
     * @return
     */
    public List<Users> getList(Users user){
        return usersMapper.getList(user);
    }

    /***
     * 添加用户
     * @param user
     */
    public void addUser(Users user){
        user.setPassword(DESEncryption.getEncryptString(user.getPassword()));
        user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        usersMapper.addUser(user);
    }

    /***
     * 检测username的存在性
     * @param params
     * @return
     */
    public Boolean judgeExistenceOfUsername(String params){
        Users user = new Users();
        user.setUsername(params);
        List<Users> userList = usersMapper.getList(user);
        if(userList.size() == 0 || userList == null){
            return false;
        }else{
            return true;
        }
    }

    /***
     * 检测worker的存在性
     * @param params
     * @return
     */
    public Boolean judgeExistenceOfWorker(String params){
        Users user = new Users();
        user.setWorker(params);
        List<Users> userList = usersMapper.getList(user);
        if(userList.size() == 0 || userList == null){
            return false;
        }else{
            return true;
        }
    }

    public void updateUser(Users user){
        usersMapper.updateUser(user);
    }

    public void deleteUser(String worker){
        String username = usersMapper.getUsernameByWorker(worker);
        if(username != ""){
            rolesMapper.delRole(username);//先
            usersMapper.deleteUser(worker);//后
        }
    }

    public void deleteUsers(String[] workers){
        for (int i = 0; i < workers.length; i++) {
            String username = usersMapper.getUsernameByWorker(workers[i]);
            rolesMapper.delRole(username);
        }
        usersMapper.deleteUsers(workers);
    }

    public void uploadAvatar(MultipartFile image) throws Exception {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

        File respositry = new File("D:/lawyers/avatar/"+ TokenUtil.getTokenUsername()+"/"+format.format(date));
        if (!respositry.exists()){
            respositry.mkdirs();
        }
        File avatar = new File("D:/lawyers/avatar/"+ TokenUtil.getTokenUsername()+"/"+format.format(date)+"/" + image.getOriginalFilename());
        if(!avatar.exists()){
            avatar.createNewFile();
        }
        //保存到服务器
        image.transferTo(avatar);
        //保存图片地址
        int port = ip.getPort();
        String url = "http://localhost:"+port+"/user/getAvatar/"+TokenUtil.getTokenUsername()+"/"+format.format(date);
        usersMapper.imageUrl(url,TokenUtil.getTokenUsername());
    }

    public void changePassword(String password){
        String pas = DESEncryption.getEncryptString(password);
        usersMapper.changePassword(pas,TokenUtil.getTokenUsername());
    }
}
