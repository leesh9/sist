package com.sist.ex0725_db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sist.ex0725_db.service.EmpService;
import com.sist.ex0725_db.vo.EmpVO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmpController {
    
    @Autowired
    private EmpService e_service;

    @RequestMapping(value="/emp", method=RequestMethod.GET)
    public ModelAndView all() {
        ModelAndView mv = new ModelAndView();
        EmpVO[] ar = e_service.getAll();
        mv.addObject("list", ar);
        mv.setViewName("all");
        return mv;
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView list( String begin, String end){
        ModelAndView mv = new ModelAndView();
        EmpVO[] ar = e_service.between(begin, end);
        mv.addObject("list", ar);
        mv.setViewName("all");
        return mv;
    }

    @RequestMapping(value="/search", method=RequestMethod.POST)
    public ModelAndView search(String type, String value){
        ModelAndView mv = new ModelAndView();
        EmpVO[] ar = e_service.search(type, value);
        mv.addObject("list", ar);
        mv.setViewName("all");
        return mv;
    }
    
}
