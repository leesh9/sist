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
	
	//DAO ���� ������ �����ɶ� �̸� �����ǹǷ� ���� ��ü�� 
	// ����� ������ �̹� ���� �Ǿ� �ֱ� ������ ���⼭ Autowired�� �ڵ� �����̵ȴ�.
	
	@RequestMapping("/t1")
	public ModelAndView test1() {
		ModelAndView mv = new ModelAndView();
		
		// �� ���������� ǥ���� �ڿ����� mv �� ��������!
		mv.addObject("str","Spring MVC �׽�Ʈ");
		mv.setViewName("test1");
		// WEB-INF/views/test1.jsp�� �ǹ���
		
		return mv;
	}
	
	@RequestMapping("/login")
	public String test2() {
		return "ex6";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView test (String id, String pw) {
		//����ڰ� jsp���� �Է��� ���̵�� ��й�ȣ�� ���ڷ� �޴´�.
		// DAO�� Ȱ���Ͽ� DB�κ��� ��������!
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
