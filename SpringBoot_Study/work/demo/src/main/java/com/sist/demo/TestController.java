package com.sist.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import test.vo.DataVO;
import test.vo.TestVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class TestController {
    //@RestController = @ResponseBody + @Controller
    
    private String msg;

    @Value("${global.guestId}")
    private String guestId;
    @Value("${global.siteName}")
    private String siteName;

    @GetMapping("/test")
    public String test() {
        return "Hello, World!";
    }
    @GetMapping("/test2/{var}")
    // public String varTest(@PathVariable("var") String var) {
    public String varTest(@PathVariable String var) {
        return var;
    }
    @GetMapping("/req")
    public String getReq( String name, String email) {
        //파라미터 받는 방법은 Spring과 같다
        return name + "/" + email;
    }

    @GetMapping("/req2")
    public String getReq2(@RequestParam String name,String email) {
        return name + "/" + email+"/"+guestId;
    }

    @GetMapping("/req3")
    public String getReq3() {
        TestVO vo = new TestVO();
        vo.setId(guestId);
        vo.setName(siteName);
        return vo.getId()+"/"+vo.getName();
    }

    @GetMapping("/req4")
    public String getReq4() {
        DataVO dvo = new DataVO();
        dvo.setMsg("반갑습니다!");
        return dvo.getMsg();
    }
    
    
}
