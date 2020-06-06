package com.suser.mapper;

import com.suser.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    /**验证用户*/
    public Users getUserByUsername(String username);

    /***
     * 查询用户信息
     * @param user
     * @return
     */
    public List<Users> getList(Users user);

    /***
     * 添加一个用户
     * @param user
     * @return
     */
    public void addUser(Users user);

    /***
     * 根据worker修改User信息
     * @param user
     */
    public void updateUser(Users user);

    /***
     * 根据worker删除User
     * @param worker
     */
    public void deleteUser(String worker);

    /***
     * 批量删除
     * @param workers
     */
    public void deleteUsers(String[] workers);

    /***
     * 保存图片地址
     * @param url
     */
    public void imageUrl(
            @Param("url") String url,
            @Param("username") String username);

    /***
     * 修改密码
     * @param password
     */
    public void changePassword(
            @Param("password") String password,
            @Param("username") String username);

    public String getUsernameByWorker(String worker);
}
