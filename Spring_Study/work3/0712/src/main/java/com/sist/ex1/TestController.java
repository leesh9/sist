package com.sist.ex1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.dao.MemDAO;
import mybatis.vo.EmpVO;
import mybatis.vo.MemVO;

@Controller
public class TestController {
	
	@Autowired
	private MemDAO m_dao;
	
	@Autowired
	private EmpDAO e_dao;
	
	//DAO 들은 톰켓이 구동될때 미리 생성되므로 현재 객체가 
	// 만들어 질때는 이미 생성 되어 있기 때문에 여기서 Autowired로 자동 주입이된다.
	
	@RequestMapping("/t1")
	public ModelAndView test1() {
		ModelAndView mv = new ModelAndView();
		
		// 뷰 페이지에서 표현할 자원들을 mv 에 저장하자!
		mv.addObject("str","Spring MVC 테스트");
		mv.setViewName("test1");
		// WEB-INF/views/test1.jsp를 의미함
		
		return mv;
	}
	
	@RequestMapping("/login")
	public String test2() {
		return "ex6";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView test (String id, String pw) {
		//사용자가 jsp에서 입력한 아이디와 비밀번호를 인자로 받는다.
		// DAO를 활용하여 DB로부터 검증하자!
		MemVO mvo = m_dao.login(id, pw);
		
		ModelAndView mv = new ModelAndView();
		if(mvo != null)
			mv.addObject("mvo",mvo);
		mv.setViewName("login_res");
		return mv;
	}
	
	@RequestMapping("/emp")
	public ModelAndView emp(){
		List<EmpVO> arr = e_dao.all();
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp",arr);
		mv.setViewName("emp");
		
		return mv;
	}
	
}
