package com.sist.jwt_mem.global.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

// JWT토큰을 가지고 서버에 들어오는 요청을 허용하기 위한 인가(authorization)처리를 하는 filter객체

@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

  @Override
  @SneakyThrows // try ~ catch로 예외처리를 해야할 것을 명시적 예외처리를 생략할 수 있도록 해주는 어노테이션
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    if (request.getRequestURI().equals("/api/member/login") || request.getRequestURI().equals("/api/member/logout")) {
      filterChain.doFilter(request, response);
      return;
    } // login, loout은 통과

    // accessToken검증 또는 refreashToken 발급
    String accessToken = "";
    if (!accessToken.isBlank()) {
      // 검증 (나중에 하자)
    }

    filterChain.doFilter(request, response);
  }

}
