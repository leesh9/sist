package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.service.DeptService;
import mybatis.vo.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	private DeptService service;
	
	@RequestMapping("dept")
	public ModelAndView dept() {
		ModelAndView mv = new ModelAndView();
		
		DeptVO[] ar = service.getList();
		mv.addObject("ar",ar);
		mv.setViewName("dept_list");
		
		return mv;
	}
}
