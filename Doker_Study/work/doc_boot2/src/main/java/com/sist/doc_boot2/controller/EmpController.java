package com.sist.doc_boot2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.doc_boot2.service.EmpService;
import com.sist.doc_boot2.vo.EmpVO;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping("/emp")
    public Map<String, Object> emp() {
        Map<String, Object> map = new HashMap<>();
        EmpVO[] ar = empService.getTotal();
        map.put("ar", ar);
        map.put("count", ar.length);
        return map;
    }
}