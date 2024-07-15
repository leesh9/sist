package ex1.action;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ex1.vo.ParamVO;

@Controller
public class Test4Action {
	@RequestMapping("/ex4.inc")
	public ModelAndView exe() {
		ModelAndView mv = new ModelAndView();
		
        mv.addObject("msg", "연습입니다.");
        
		mv.setViewName("ex4");
		return mv;
	}
	
	@RequestMapping("/ex5.inc")
	public ModelAndView exe2() {
		ModelAndView mv = new ModelAndView();
		
        LocalDate now = LocalDate.now();
        mv.addObject("now",now.toString());
        
		mv.setViewName("ex5");
		return mv;
	}
	
	@RequestMapping("ex6.inc")
	public String exe3() {//단순 jsp로 이동하고자 할 때
		return "ex6";
	}
	
	@RequestMapping("/ex7.inc")
	public ModelAndView exe4(String id, String pw) {
		ModelAndView mv = new ModelAndView();
		System.out.println("gg");
		mv.addObject("m_id",id);
		mv.addObject("m_pw",pw);
		
		mv.setViewName("ex7");
		return mv;
	}
	
	@RequestMapping("/ex8.inc")
	public String exe5() {
		
		
		return "ex8";
	}
	
	@RequestMapping("/ex9.inc")
	public ModelAndView exe(String c_idx,String u_name,String unit,String[] hobby) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("c_idx", c_idx);
		mv.addObject("u_name", u_name);
		mv.addObject("unit", unit);
		mv.addObject("hobby", hobby);
		
		mv.setViewName("ex9");
		
		return mv;
	}
	
	@RequestMapping("/ex10.inc")
	public ModelAndView exe7(ParamVO pvo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo",pvo);
		
		mv.setViewName("ex10");
		
		return mv;
	}
}
