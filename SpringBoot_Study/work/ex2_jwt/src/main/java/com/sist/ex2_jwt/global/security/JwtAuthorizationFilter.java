package com.sist.ex2_jwt.global.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    // JWT토큰을 가지고 서버에 들어오는 요청을
    // 허용하기 위한 인자(authorization)처리를 하는
    // Filter객체다.
    // 상속을 받아야한다.
    //try~catch로 예외처리를 해야할 것을 
    //명시적으로 예외 처리를 생략할 수 있도록 함 
    @Override
@SneakyThrows
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if(request.getRequestURI().equals("/api/memver/login")|| request.getRequestURI().equals("/api/memver/logout")) {
            filterChain.doFilter(request, response);
            return;
            // 로그인과 로그아웃은 통과~ 
        }
        //accessToken 검증 또는 refreshToken 발급
        String accessToken = "";
        if(!accessToken.isBlank()) {
            //나중에 
            
    }
    filterChain.doFilter(request, response);
    // 실무적으로 응답할때 json으로 해서 map을 주니까 해도 되는데
    // 실전에선 이렇게 안하고 다 응답을 하기 위해 수행하는 json값들이 다를 수 있기 때문에
    //이름 이런거 안에다 지정하고 보내는데 상관없고 아예 객체를 마련해서 모든 개발자가 
    //7명 이 하나의 객체로 보내는거다. 가끔은 문자열로 보낼때가 있는데 map구조에 담아서 보내도 되긴하지만
    // <String, 반환형> 통일되지 않을 뿐더러 무조건 반환 객체를 통일 시킬떄 좋지 않다.
    //그리고 문서 만들 때 나중에 문서화 시키면 반환 값이 다 다르면 별로다
    //그래서 자료형을 하나로 통일시킬때 객체를 하나 만들면 좋다.
    //나중에 바꿔서 보여주겠다.
    
    }
}
