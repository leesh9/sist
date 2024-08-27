package com.sist.ex1_jwt.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class jwtProvider {
    @Value("${custom.jwt.secretKey}")
    private String secretKeyCode;
 
    private SecretKey secretKey;

    public SecretKey getSecretKey() {
        System.out.println("secretKeyCode : " + secretKeyCode);
        if (secretKey == null) {
            String encoding = Base64.getEncoder().encodeToString(secretKeyCode.getBytes());
            secretKey = Keys.hmacShaKeyFor(encoding.getBytes());
        }
        return secretKey;
    }

    public String genToken(Map<String, Object> map,int seconds) {
        //현재시간
        long now = new Date().getTime();
        Date accessTokenExpiresIn = new Date(now + 1000 * seconds);

        JwtBuilder jwtBuilder = Jwts.builder()
                                .subject("okj")
                                .expiration(accessTokenExpiresIn);
        Set<String> keys = map.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Object value = map.get(key);
            jwtBuilder.claim(key, value);
        }
        return jwtBuilder.signWith(getSecretKey()).compact();
    }

    //토큰 유효기간 확인
    public boolean verify(String token){
        boolean value = true;

        try{
            Jwts.parser().verifyWith(getSecretKey())
                        .build()
                        .parseSignedClaims(token);//기간만료시 예외발생!!
        }catch(Exception e){
            value = false;
        }
        return value;
    }

    //토큰에 담긴 사용자정보(claims)를 반환
    public Map<String, Object> getClaims(String token){
        return Jwts.parser().verifyWith(getSecretKey())
                        .build()
                        .parseSignedClaims(token)
                        .getBody();
    }
}
