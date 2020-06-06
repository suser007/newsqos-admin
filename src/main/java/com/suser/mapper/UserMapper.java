package com.suser.mapper;

import com.suser.entity.User;

public interface UserMapper {

    User findByUsername(String username);

    User findUserById(String id);

}
