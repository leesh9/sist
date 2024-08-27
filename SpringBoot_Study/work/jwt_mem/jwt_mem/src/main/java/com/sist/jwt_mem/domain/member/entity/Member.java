    package com.sist.jwt_mem.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_idx")
    private long mIdx; // m_idx

    @Column(name = "m_id")
    private String mId;

    // 비밀번호는 외부로 가는 json에 담기지 않는 것이 보안상 좋기 때문에 다음과 같이
    // 정의 하여 방출을 방지한다.
    @JsonIgnore
    private String mPw;

    @Column(name = "m_name")
    private String mName;

    @Column(name = "access_token", length = 1024)
    private String accessToken; // 로그인할 때

    @Column(name = "refresh_token", length = 1024)
    private String refreshToken; // 가입할 때

}
