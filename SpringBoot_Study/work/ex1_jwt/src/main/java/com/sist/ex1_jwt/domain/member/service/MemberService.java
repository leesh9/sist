package com.sist.ex2_jwt.domain.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.sist.ex2_jwt.domain.member.entity.Member;
import com.sist.ex2_jwt.domain.member.repository.MemberRepository;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }
}
