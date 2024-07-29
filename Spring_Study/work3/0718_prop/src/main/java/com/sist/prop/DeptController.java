package com.sist.prop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.DeptDAO;
import mybatis.vo.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	private DeptDAO d_dao;
	
	@RequestMapping("/dept")
	public ModelAndView dept() {
		ModelAndView mv = new ModelAndView();
		
		//부서목록 가져오기
		DeptVO[] ar = d_dao.total();
		mv.addObject("list",ar);
		mv.setViewName("dept/list");
		
		return mv;
	}
	
	@RequestMapping("/search")
	@ResponseBody()
	public DeptVO[] search(String searchType,String searchValue) {
		ModelAndView mv =new ModelAndView();
		Map<String, String> map = new  HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		DeptVO[] ar = d_dao.search(map);
		return ar;
	};
	
}
