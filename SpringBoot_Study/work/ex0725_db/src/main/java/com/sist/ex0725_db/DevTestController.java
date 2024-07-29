package com.sist.ex0725_db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DevTestController {
    @Value("${global.siteName}")
    private String siteName;
    
    
    @GetMapping
    public String test(){
        return siteName;
    }
}
