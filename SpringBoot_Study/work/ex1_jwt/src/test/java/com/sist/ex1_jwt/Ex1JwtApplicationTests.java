package com.sist.ex1_jwt;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.sist.ex1_jwt.jwt.jwtProvider;

import io.jsonwebtoken.security.Keys;

@SpringBootTest
class Ex1JwtApplicationTests {

	@Autowired
	private jwtProvider jwtProvider;

	@Value("${custom.jwt.secretKey}")
	private String secretKey;
	
	@Test
	@DisplayName("시크릿키 체크")
	void loadSecretKey() {
		assertThat(secretKey).isNotNull();
	}

	@Test
	@DisplayName("암호화알고리즘으로 시크릿키 암호화")
	void genBase64() {
		String encoding = Base64.getEncoder().encodeToString(secretKey.getBytes());
		SecretKey key = Keys.hmacShaKeyFor(encoding.getBytes());
		assertThat(key).isNotNull();
	}

	@Test
	@DisplayName("프로바이더를 통한 시크릿 암호화")
	void jwtProvider() {
		SecretKey secretKey = jwtProvider.getSecretKey();
		assertThat(secretKey).isNotNull();
	}

	@Test
	@DisplayName("동일한 secetKey인지 확인")
	void secretKey() {
		SecretKey secretKey1 = jwtProvider.getSecretKey();
		SecretKey secretKey2 = jwtProvider.getSecretKey();
		assertThat(secretKey1).isEqualTo(secretKey2);
	}

	@Test
	@DisplayName("accessToken 발급")
	void createToken() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 1L);
		map.put("m_name", "홍길동");
		map.put("m_email", "hong@gmail.com");
		String token = jwtProvider.genToken(map, 60*60*2);
		assertThat(token).isNotNull();
	}

	@Test
	@DisplayName("토큰에서 사용자정보 추출")
	void getClaims() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 100L);
		map.put("m_name", "마루치");
		map.put("m_email", "maru@gmail.com");
		String token = jwtProvider.genToken(map, 60*60*2);
		assertThat(token).isNotNull();
		Map<String, Object> claims = jwtProvider.getClaims(token);
		assertThat(claims).isNotNull();
		System.out.println("claims : " + claims);
		assertThat(claims.get("id")).isEqualTo(100);
		assertThat(claims.get("m_name")).isEqualTo("마루치");
		assertThat(claims.get("m_email")).isEqualTo("maru@gmail.com");
	}
}