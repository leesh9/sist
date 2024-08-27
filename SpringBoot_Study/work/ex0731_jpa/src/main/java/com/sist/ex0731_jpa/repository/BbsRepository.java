package com.sist.ex0731_jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.ex0731_jpa.store.Bbs;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, String> {
    
}
