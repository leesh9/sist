package com.sist.ex2_jwt.domain.member.entity;

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

@Entity(name = "member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Member {
    @Id
    @Column(name = "m_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mIdx;
    
    @Column(name = "m_id")
    private String mId;
    @Column(name = "m_pw")
    private String mPw;
    @Column(name = "m_name")
    private String mName;
    @Column(name = "m_email")
    private String mEmail;
    @Column(name = "m_phone")
    private String mPhone;
    @Column(name = "write_date")
    private String writeDate;
}