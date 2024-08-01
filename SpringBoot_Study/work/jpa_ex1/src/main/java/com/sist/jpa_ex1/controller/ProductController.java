package com.sist.jpa_ex1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.jpa_ex1.repository.ProductRepository;
import com.sist.jpa_ex1.store.ProductJPO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping ("/test")
    public String test() {
        ProductJPO p1 = ProductJPO.builder()
            .pNum(100L)
            .pName("빈센트 아몬드나무")
            .pCompany("Art company")
            .build();
        
        productRepository.save(p1);//저장!
        return "test";
    }
    @GetMapping("list")
    public String getList() {
        List<ProductJPO> list = productRepository.findAll();
        StringBuilder sb = new StringBuilder();
        for (ProductJPO p : list) {
            sb.append(p.getPNum())
                .append("/")
                .append(p.getPName())
                .append("/")
                .append(p.getCjpo1().getCName())
                .append("/")
                .append(p.getCjpo1().getCDesc())
                .append("\n");
        }
        return sb.toString();
    }
}