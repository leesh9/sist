package com.sist.ex2_jwt;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sist.ex2_jwt.domain.member.entity.Member;
import com.sist.ex2_jwt.domain.member.service.MemberService;

@SpringBootTest
class Ex2JwtApplicationTests {

	@Autowired
	private MemberService memberService;
	
	public void test1() {
		Member member = memberService.authAndMakeToken("admin");
		assertThat(member).isNotNull();
	}

}
