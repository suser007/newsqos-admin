package com.suser.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.suser.entity.Users;
import com.suser.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/***
 * 拦截器拦截所有的请求，检查Token
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UsersService usersService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object object){
        String myTokenString = httpServletRequest.getHeader("X-Token");
        //如果不是映射方法，直接跳过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passToken注释，有则跳过认证
        if(method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()){
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)){
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()){
                /**** 执行认证 ****/
                if(myTokenString == null){
                    throw new RuntimeException("null token ,please again");
                }
                /**** 获取token => username ****/
                String myUsernameString;
                try {
                    myUsernameString = JWT.decode(myTokenString).getAudience().get(0);
                }catch (JWTDecodeException j){
                    throw new RuntimeException("username = JWT.decode(myTokenString).getAudience().get(0);");
                }
                Users user = usersService.getUserByUsername(myUsernameString);
                if(user == null){
                    throw new RuntimeException("user is null");
                }
                /**** 验证token *****/
                JWTVerifier jwtVerifier =
                        JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try{
                    jwtVerifier.verify(myTokenString);
                }catch (JWTVerificationException e){
                    throw new RuntimeException("jwtVerifier.verify(myTokenString); fail");
                }
                /***************/
                return true;
            }
        }
        return true;
    }
}
