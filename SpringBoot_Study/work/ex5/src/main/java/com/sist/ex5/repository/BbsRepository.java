package com.sist.ex5.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.ex5.store.Bbs;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Long> {
    Page<Bbs> findAll(Pageable pageable);
}
