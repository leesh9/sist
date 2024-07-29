package com.sist.prop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.vo.DeptVO;
import mybatis.vo.EmpVO;

@Controller

public class EmpController {
	@Autowired
	EmpDAO e_dao;
	
	@RequestMapping("/emp")
	ModelAndView emp() {
		ModelAndView mv = new ModelAndView();
		
		EmpVO[] ar = e_dao.total();
		
		mv.addObject("list",ar);
		
		mv.setViewName("emp/list");
		
		return mv;
	}
	
	@RequestMapping("/emp_search")
	@ResponseBody()
	public EmpVO[] search(String searchType,String searchValue) {
		ModelAndView mv =new ModelAndView();
		Map<String, String> map = new  HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		System.out.println(searchType+searchValue);
		EmpVO[] ar = e_dao.search(map); 
		return ar;
	};
	
	@RequestMapping("/emp_detail")
	ModelAndView detail(EmpVO vo) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("vo",vo);
		
		mv.setViewName("emp/detail");
		
		return mv;
	}
}
