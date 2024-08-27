package com.sist.ex2_jwt.domain.member.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import com.sist.ex2_jwt.domain.member.entity.Member;
import com.sist.ex2_jwt.domain.member.repository.MemberRepository;
import com.sist.ex2_jwt.jwt.JwtProvider;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private JwtProvider jwtProvider;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public Optional<Member> findByMId(String mId) {
        return memberRepository.findByMId(mId);
    }

    public String authAndMakeToken(String mId) {
        Member member =null;
        try {
            member = findByMId(mId).orElseThrow(() -> new Exception("회원 없음"));
            Map<String,Object> map = new HashMap<>();
            map.put("mid", member.getMId());
            map.put("midx", member.getMIdx());
            map.put("mname", member.getMName());
            map.put("mpw", member.getMPw());

            String accessToken = jwtProvider.genToken(map, 60*60*2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
