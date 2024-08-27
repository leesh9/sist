package com.sist.jwt_mem.domain.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.jwt_mem.domain.member.entity.Member;
import com.sist.jwt_mem.domain.member.service.MemberService;
import com.sist.jwt_mem.domain.result.ResultData;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/member")
public class ApiMemberController {

  @Autowired
  private MemberService mService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  // =========================

  @PostMapping("/reg")
  public Map<String, Object> reg(Member member) {
    Map<String, Object> map = new HashMap<>();

    if (member.getMId() != null) {
      // 사용자가 입력한 비밀번호를 암호화 시킨다.
      // String pw = passwordEncoder.encode(member.getMPw());
      Member m = mService.memSave(member);
      map.put("mvo", m);
    }

    return map;
  }

  @PostMapping("/login")
  public ResultData<Member> login(String mId, String mPw, HttpServletResponse res) {
    //Map<String, Object> map = new HashMap<>();
    // 파라미터로 전달된 member의 mId값을 가지고 검색한다.
    Member m = mService.authAndMakeToken(mId, mPw);
    // m이 null이 아니면 해당 id로 회원정보가 있다는 뜻이며 해당 m안에
    // 암호화된 비밀번호가 존재한다.
    // 이미 서비스안에서 비밀번호 매칭 검사도 모두 수행한 상태이다.
    // 잘못되었다면 m == null 이다.
    if (m != null) {
      ResponseCookie cookie = ResponseCookie.from("accessToken", m.getAccessToken())
          .path("/").sameSite("None").httpOnly(false).secure(true).build();

      res.addHeader("Set-Cookie", cookie.toString()); // 쿠키가 담기는 키값은 정해져있다.(Set-Cookie)

      cookie = ResponseCookie.from("refreshToken", m.getRefreshToken())
          .path("/").sameSite("None").httpOnly(true).secure(true).build();
      res.addHeader("Set-Cookie", cookie.toString());

      //map.put("mvo", m);
      return ResultData.of(1, "로그인 성공", m);

    }
    return ResultData.of(0, "로그인 실패");
  }

  @PostMapping("/logout")
  public ResultData<Member> logout(String accessToken, HttpServletResponse res) {
    //쿠키에서 accessToken, refreshToken 삭제하여
    // 클라이언트에게 보낸다.
    ResponseCookie cookie = ResponseCookie
      .from("accessToken", null)
      .path("/")
      .sameSite("None")
      .httpOnly(true)
      .secure(true)
      .maxAge(0)
      .build();

    res.addHeader("Set-Cookie", cookie.toString());

    cookie = ResponseCookie
      .from("refreshToken", null)
      .path("/")
      .sameSite("None")
      .httpOnly(true)
      .secure(true)
      .maxAge(0)
      .build();

    res.addHeader("Set-Cookie", cookie.toString());
    return ResultData.of(1, "로그아웃");
  }

  @PostMapping("/kakao")
  public ResultData<Member> kakao(String code, HttpServletResponse res) {
    System.out.println("code : " + code);
    return ResultData.of(1, "카카오 로그인 성공");
  }

}
