package com.sist.ex2_jwt.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.sist.ex2_jwt.jwt.JwtProvider;
import com.sist.ex2_jwt.domain.member.entity.Member;
import com.sist.ex2_jwt.domain.member.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ApiMemberController {
    
    @Autowired
    private MemberService memberService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;
    
    @PostMapping("/reg")
    public Map<String, Object> reg(Member member) {
        if(member.getMId() != null) {
            // 사용자가 입력한 비밀번호를 암호화 시킨다.
            String pw = passwordEncoder.encode(member.getMPw());
            member.setMPw(pw);
        }
        memberService.save(member);
        Map<String, Object> map = new HashMap<>();
        map.put("mvo", member);
        return map;
    }

    //로그인을 위한 인증
    public Map<String, Object> authAndMakeToken(Member member) {
        Map<String, Object> map = new HashMap<>();

        //파라미터로 전달된 member의 mId값을 가지고 검색한다.
        Optional<Member> m = memberService.findByMId(member.getMId());
        if(m != null) {
           if(passwordEncoder.matches(member.getMPw(), m.get().getMPw())) {
            //jwt 토큰생성
            
            String accessToken = jwtProvider.genToken();
           }
        }
        return map;
    }
}