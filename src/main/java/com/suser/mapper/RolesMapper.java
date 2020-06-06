package com.suser.mapper;

import com.suser.entity.Roles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolesMapper {
    List<String> getRoles(@Param("username") String username);
    /***
     * 通过用户名获取权限
     * @param username
     * @return
     */
    List<Roles> getRolesByUsername(String username);

    /***
     * 获取权限列表
     * @param role
     * @return
     */
    List<Roles> getList(Roles role);

    /***
     * 添加权限记录
     * @param role
     */
    void addRole(Roles role);

    void delRole(String username);
}
