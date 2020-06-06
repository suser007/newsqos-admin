package com.suser.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.suser.entity.Users;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenService {
    public String getToken(Users user){
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 1000 * 60 * 30;//0.5小时有效时间
        Date end = new Date(currentTime);
        Map<String,Object> headerClaims = new HashMap<>();
        headerClaims.put("owner",user.getUsername());
        /** 生成Token **/
        String token = "";
        token = JWT
                .create()
                .withHeader(headerClaims)
                .withAudience(user.getUsername())
                .withIssuedAt(start)
                .withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
