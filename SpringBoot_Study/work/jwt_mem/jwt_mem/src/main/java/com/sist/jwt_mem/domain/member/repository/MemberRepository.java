package com.sist.jwt_mem.domain.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sist.jwt_mem.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m WHERE m.mId = :mId")
    Optional<Member> findByMId(@Param("mId") String mId);

    @Modifying // 단건처리에는 의미가 없고 다건처리(다량의 데이터)에 넣어주면 보다 안정적이고 효울적인 실행이 된다.
    @Transactional
    @Query("UPDATE Member m SET m.refreshToken = :refreshToken WHERE m.mId = :mId")
    void updateRefreshToken(@Param("mId") String mId, @Param("refreshToken") String refreshToken);

}
