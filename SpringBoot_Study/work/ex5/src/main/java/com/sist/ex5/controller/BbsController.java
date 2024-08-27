package com.sist.ex5.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
    @GetMapping("/api/bbs/{page}")
    public Map<String, Object> bbsList(@PathVariable int page){
        Map<String, Object> map = new HashMap<>();
        map.put("ar", bbsService.findAll(page));
        return map;
    }
}
