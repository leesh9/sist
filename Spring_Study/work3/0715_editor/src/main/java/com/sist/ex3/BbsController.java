package com.sist.ex3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import spring.vo.ImgVO;

@Controller
public class BbsController {
	@Autowired
	private BbsDAO b_dao;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ServletContext application; 
	
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		
		//ǥ���� ��� ��������
		BbsVO[] ar = b_dao.getList("bbs", 1, 10);
		mv.addObject("ar",ar);
		
		mv.setViewName("list");
		return mv;
	}
	
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
	
	@RequestMapping(value = "saveImg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String>saveImg(ImgVO ivo){
		Map<String, String> map = new HashMap<String, String>();
		
		//���޵Ǿ� ���� �̹����� ivo���� �����´�.
		MultipartFile f = ivo.getFile();
		if(f.getSize() > 0) {
			//������ �ִ� ���
			// ������ ������ ��ġ�� �����η� ������!
			String realpath = application.getRealPath("/resources/editor_img");
			
			try {
				f.transferTo(new File(realpath,f.getOriginalFilename()));
				map.put("fname", f.getOriginalFilename());
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		//���� ������ ����� ���� ��θ� ���ڿ��� ������
		// ��)localhost:8080/editor/editor_img/test.png
		String c_path = request.getContextPath();
		map.put("url",c_path+"/resources/editor_img");
		return map;
	}
}
