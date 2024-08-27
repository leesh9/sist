package com.sist.jwt_mem.global.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApiSecurityConfig {

        // 여기에 무조건 이 객체가 들어와야 한다.
        // 하지만 autoWired가 Configuration보다 느리게 작동할 수도 있으니 상수로 지정한다.
        // RequiredArgsConstructor: 현재 객체(class)를 생성하려면 무조건 jwtAuth..에 넣어줘야 한다.
        private final JwtAuthorizationFilter jwtAuthorizationFilter;

        @Bean
        SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
                http
                                .securityMatcher("/api/**") // 설정된 경로로 들어오는 모든 것을 검사함
                                .authorizeHttpRequests( // 요청에 대한 권한을 지정
                                                authorizeHttpRequests -> authorizeHttpRequests
                                                                .requestMatchers("/api/member/**").permitAll() // /api/member/reg
                                                                                                               // 경로는 허용
                                                                .requestMatchers("/api/bbs/**").permitAll() // 기존 허용 경로
                                                                .requestMatchers(HttpMethod.POST, "/api/member/login", "/api/member/logout")
                                                                .permitAll() // 기존 허용 경로
                                                                .anyRequest().authenticated() // 나머지 모든 요청은 인증이 되어야 함
                                )
                                .csrf(csrf -> csrf.disable()) // CSRF 토큰 비활성화
                                .httpBasic(httpbasic -> httpbasic.disable()) // httpbasic로그인 방식 끄기
                                .formLogin(formlogin -> formlogin.disable()) // formlogin방식 끄기
                                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(
                                                SessionCreationPolicy.STATELESS)) // 세션 끄기
                                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }
}
