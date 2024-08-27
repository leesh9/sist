package com.sist.ex2_jwt.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/member/login")
    public Map<String, Object> reg(@RequestBody Member member) {
        String pw = passwordEncoder.encode(member.getMPw());
        member.setMPw(pw);
        

        return null;
    }
}