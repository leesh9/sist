package com.sist.backend.cotroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.backend.service.EmpService;


@RestController
@RequestMapping("/api")
public class EmpController {
    
    @Autowired
    private EmpService empService;

    @RequestMapping("/all")
    public Map<String, Object> all() {
        Map<String, Object> map = new HashMap<>();
        map.put("ar", empService.getAll());
        
        return map;
    }
    
}
