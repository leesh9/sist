package com.sist.bbs;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.service.BbsService;
import mybatis.service.MemoService;



@Controller
public class BbsController {
	@Autowired
	private BbsService bbsService;

    @Autowired
    private MemoService memoService;

    @RequestMapping("bbs")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("bbs_list");
        mv.addObject("ar", bbsService.getList());
        return mv;
    }

    @RequestMapping("memo")
    public ModelAndView detail() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memo_list");
        mv.addObject("ar", memoService.getList());
        return mv;
    }
}
