package com.sist.jwt_mem.domain.member.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.jwt_mem.domain.member.entity.Member;
import com.sist.jwt_mem.domain.member.repository.MemberRepository;
import com.sist.jwt_mem.global.jwt.JwtProvider;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private JwtProvider jProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 가입
    public Member memSave(Member mem) {
        mem.setMPw(passwordEncoder.encode(mem.getMPw())); // 입력한 pw를 암호화해서 저장

        Map<String, Object> map = new HashMap<>();
        map.put("midx", mem.getMIdx());
        map.put("mid", mem.getMId());
        map.put("mpw", mem.getMPw());
        map.put("mname", mem.getMName());

        String refeshToken = jProvider.getRefreshToken(map);

        mem.setRefreshToken(refeshToken);

        return memberRepository.save(mem);
    }

    // 로그인을 위한 인증
    public Member authAndMakeToken(String mId, String mPw) {
        Member member = null;
        try {
            member = memberRepository.findByMId(mId).orElseThrow(() -> new RuntimeException("존재하지 않음"));
            // findByMid(mid)로 입력한 id에 해당되는 정보(id, pw, name..)이 member에 저장된다

            if (passwordEncoder.matches(mPw, member.getMPw())) { // (평문, 암호문)
                Map<String, Object> map = new HashMap<>();

                map.put("mIdx", member.getMIdx());
                map.put("mId", member.getMId());
                map.put("mPw", member.getMPw());
                map.put("mName", member.getMName());

                String accessToken = jProvider.getAccessToken(map);
                String refeshToken = jProvider.getRefreshToken(map);

                member.setAccessToken(accessToken);
                member.setRefreshToken(refeshToken);
            } else { // id와 pw가 일치하지 않는 경우
                member = null;
            }

        } catch (Exception e) {
        }

        return member;
    }

}
