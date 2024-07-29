package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.service.EmpService;
import mybatis.vo.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService mapper1;// 자료형을 MyMapper로 해도 된다.
	
	@RequestMapping("emp_list")
	public ModelAndView empList() {
		ModelAndView mv = new ModelAndView();
		
		EmpVO[] ar = mapper1.getList();
		
		String str1 ="aaa";
		String str2 ="aaa";
		System.out.println(str1==str2);
		
		mv.addObject("ar", ar);
		mv.setViewName("emp_list");
		return mv;
	}
	
	@RequestMapping("emp_search")
	public ModelAndView empSearch(String type, String value) {
		ModelAndView mv = new ModelAndView();
		
		EmpVO[] ar = mapper1.search(type, value);
		
		mv.addObject("ar", ar);
		mv.setViewName("emp_list");
		return mv;
	}
}
