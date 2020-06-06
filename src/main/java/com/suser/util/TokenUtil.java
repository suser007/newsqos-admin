package com.suser.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class TokenUtil {
    /*** 从Http请求头中取出userId ***/
    public static String getTokenUsername(){
        String token = getRequest().getHeader("X-Token");
        /**解码token*/
        try{
            DecodedJWT jwt = JWT.decode(token);
            /***Header Claims***/
            String algorithm = jwt.getAlgorithm();
            String type = jwt.getType();
            String contentType = jwt.getContentType();
            String keyId = jwt.getKeyId();
            Claim claim = jwt.getHeaderClaim("owner");
            /***Payload Claims***/
            String issuer = jwt.getIssuer();
            String subject = jwt.getSubject();
            List<String> audience = jwt.getAudience();
            Date expiresAt = jwt.getExpiresAt();
            Date notBefore = jwt.getNotBefore();
            Date issuedAt = jwt.getIssuedAt();
            String id = jwt.getId();
            /********************/
            return JWT.decode(token).getAudience().get(0);
        }catch (JWTDecodeException exc){
            throw new JWTDecodeException("The token has an invalid syntax or the header or payload are not JSONs");
        }
        /***********/
    }
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
