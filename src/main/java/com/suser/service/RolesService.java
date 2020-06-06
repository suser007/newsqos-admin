package com.suser.service;

import com.suser.entity.Roles;
import com.suser.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesService {
    @Autowired
    private RolesMapper rolesMapper;
    public List<String> getRoles(String username){
        return rolesMapper.getRoles(username);
    }

    public List<Roles> getRolesByUsername(String username){
        return rolesMapper.getRolesByUsername(username);
    }
    public String[] getRolesArrayByUsername(String username){
        List<Roles> roleResult = rolesMapper.getRolesByUsername(username);
        String[] roleArray = new String[roleResult.size()];
        for (int i = 0; i < roleResult.size(); i++) {
            roleArray[i] = roleResult.get(i).getRole();
        }
        return roleArray;
    }
    public List<Roles> getList(Roles role){
        return rolesMapper.getList(role);
    }
    public void addRole(Roles role){
        String[] roleA = role.getRole().trim().split(" ");
        for (int i = 0; i < roleA.length; i++) {
            Roles roleObject = new Roles();
            roleObject.setUsername(role.getUsername());
            roleObject.setRole(roleA[i]);
            if(roleObject.getRole().equals("root")){
                roleObject.setRoleName("系统管理员");
            }else if(roleObject.getRole().equals("finance")){
                roleObject.setRoleName("财务处");
            }else if(roleObject.getRole().equals("dormitory")){
                roleObject.setRoleName("宿管");
            }else if(roleObject.getRole().equals("department")){
                roleObject.setRoleName("院系用户");
            }else if(roleObject.getRole().equals("deans")){
                roleObject.setRoleName("教务处");
            }else{ }
            rolesMapper.addRole(roleObject);
        }
    }
}
