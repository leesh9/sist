package com.sist.jwt_mem.global.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

  @Value("${custom.jwt.secretKey}")
  private String secretKeyCode;

  private SecretKey secretKey;

  public SecretKey getSecretKey() {
    if (secretKey == null) {
      String encoding = Base64.getEncoder().encodeToString(secretKeyCode.getBytes());
      secretKey = Keys.hmacShaKeyFor(encoding.getBytes());
    }

    return secretKey;
  }

  // 토큰 만든는 함수
  private String genToken(Map<String, Object> map, int seconds) {
    // 현재 시간
    long now = new Date().getTime();

    // 토큰의 유효시간
    Date accessTokenExpiresIn = new Date(now + 1000L * seconds);

    JwtBuilder builder = Jwts.builder()
        .subject("내맘대로 토큰이름")
        .expiration(accessTokenExpiresIn);

    Set<String> keys = map.keySet(); // set구조에 있는 키를 효율적으로 찾기위해 커서(이터레이터)로 변환
    Iterator<String> it = keys.iterator();

    // 커서야 커서야 너가 있는 곳의
    // 다음칸에 물건 있는지 파악하거라
    while (it.hasNext()) {
      String key = it.next(); // 있으면 다음칸으로 이동해서 그거 가져오너라
      Object value = map.get(key); // map에 있는 key에 연결된 value가 나옴
      builder.claim(key, value); // 얻어낸 키+값을 저장
    }
    return builder.signWith(getSecretKey()).compact(); // 저장된 데이터로 jwt토큰을 만들어 반환
  }

  public String getAccessToken(Map<String, Object> map) {
    return genToken(map, 60 * 60); // 1시간
  }

  public String getRefreshToken(Map<String, Object> map) {
    return genToken(map, 60 * 60 * 24 * 100); // 100일
  }

  // 토큰의 유효기간 체크
  public boolean verify(String token) {
    boolean chk = true;

    try {
      Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token);
    } catch (Exception e) { // 기간 만료시 예외 발생
      chk = false;
    }
    return chk;
  }

  // 토큰에 담긴 사용자 정보(claims)를 반환
  public Map<String, Object> getClaims(String token) {
    // 이 안에 있는 정보를 map으로 던져준다
    return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload();
  }
}
