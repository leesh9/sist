package com.sist.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
 
    @GetMapping("/")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
}