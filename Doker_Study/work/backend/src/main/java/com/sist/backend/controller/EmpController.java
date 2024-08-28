package com.sist.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sist.backend.service.EmpService;
import com.sist.backend.vo.EmpVO;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class EmpController {
    
    @Autowired
    private EmpService empService;

    @RequestMapping("/all")
    public Map<String, Object> all() {
        Map<String, Object> map = new HashMap<>();
        List<EmpVO> list = empService.getAll();
        if(list != null) {
            map.put("length", list.size());
        }
        map.put("ar", list);
        return map;
    }
    
}
