package com.sist.ex0731_jpa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.ex0731_jpa.service.BbsService;
import com.sist.ex0731_jpa.store.Bbs;

@RestController
public class BbsController {
    @Autowired
    private BbsService bbsService;

    @GetMapping("/api/bbs")
    public Map<String, Object> bbsList(){
        Map<String, Object> map = new HashMap<>();
        map.put("ar", bbsService.all());
        return map;
    }
}
