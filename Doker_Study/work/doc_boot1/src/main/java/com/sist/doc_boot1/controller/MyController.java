package com.sist.doc_boot1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sist.doc_boot1.vo.DataVO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
public class MyController {
    
    @RequestMapping("ex1")
    @ResponseBody
    public Map<String, Object> ex1() {
        Map<String, Object> map = new HashMap<>();
        DataVO vo= new DataVO(100, "SpringBoot1");
        map.put("vo", vo);
        return map;
    }
    
    @RequestMapping("ex2")
    @ResponseBody
    public Map<String, Object> ex2(String msg) {
        Map<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        boolean isNum = true;
        int num = 0;
        int gen = 0;
        
        for(int i = 0; i < msg.length(); i++) {
            if(msg.charAt(i) < '0' || msg.charAt(i) > '9') {
                isNum = false;
                break;
            }
        }
        if(isNum) {
            num = Integer.parseInt(msg);
            gen = (num / 10) *10;
            sb.append(gen).append("대 입니다.");
        }else {
            sb.append("숫자가 아닙니다.");
        }

        
        
        DataVO vo = new DataVO(100, sb.toString());
        map.put("vo", vo);
        return map;
    }
}
