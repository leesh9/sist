package com.sist.ex0725_db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sist.ex0725_db.service.DeptService;
import com.sist.ex0725_db.vo.DeptVO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value="/dept", method=RequestMethod.GET)
    public ModelAndView requestMethodName() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dept");
        DeptVO[] ar = deptService.all();
        mv.addObject("list", ar);
        return mv;
    }
    
}