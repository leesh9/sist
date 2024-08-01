package com.sist.jpa_ex1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.jpa_ex1.store.ProductJPO;

@Repository
public interface ProductRepository extends JpaRepository<ProductJPO, Long> {
    
}
