package com.sist.ex4;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bbs.util.FileRenameUtil;
import bbs.util.Paging2;
import mybatis.dao.BbsDAO;
import mybatis.dao.CommDao;
import mybatis.vo.BbsVO;
import mybatis.vo.CommVO;

@Controller
public class BbsController {
	
	@Autowired
	private BbsDAO b_dao;
	
	@Autowired
	private CommDao c_dao;
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;
	
	private String editor_img = "/resources/editor_img";
	
	private String upload= "/resources/upload";
	
	int nowPage;
	int blockList = 7;
	int blockPage = 5;
	int totalRecord;
	
	@RequestMapping("/list")
	public ModelAndView list(String cPage, String bname) {
		ModelAndView mv = new ModelAndView();
		int nowPage=1;
		
		if(bname ==null)
			bname = "bbs";
		if(cPage != null) {
			nowPage = Integer.parseInt(cPage);
		}
		totalRecord = b_dao.getCount(bname);
		Paging2 page = new Paging2(nowPage,totalRecord,blockList,blockPage);
		
		int begin =page.getBegin();
		int end = page.getEnd();
		
		BbsVO[] ar = b_dao.getList(bname,begin, end);
		
		mv.addObject("ar",ar);
		mv.addObject("totalRecord",totalRecord);
		mv.addObject("nowPage", nowPage);
		mv.addObject("bname",bname);
		mv.addObject("numperPage",blockList);
		mv.addObject("pagePerBlock",blockPage);
		mv.addObject("pageCode",page.getSb().toString());
		
		mv.setViewName(bname+"/list");
		return mv;
	}
	
	@RequestMapping(value = "write")
	public String write (String bname) {
		return bname+"/write";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add (String title,String writer,String content,MultipartFile file,String bname) {
		//폼양식에서 첨부 파일이 전달될 때 enctype이 지정된다.
		String c_type = request.getContentType();
		String oname=null;
		String fname=null;
		if(file.getSize() > 0 && c_type.startsWith("multipart") && file != null) {
			String realpath = application.getRealPath(upload);
			oname = file.getOriginalFilename();
			fname = file.getOriginalFilename();
			fname = FileRenameUtil.checkSameFileName(fname, realpath);
			try {
				file.transferTo(new File(realpath,fname));
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String ip = request.getRemoteAddr();
		bname ="bbs";
		b_dao.add(title, writer, content, fname, oname, ip, bname);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redircect:/list?bname="+bname);
		return mv;
	}
	
	@RequestMapping(value = "saveImg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> saveImg(MultipartFile f) {
		Map<String, String> map = new HashMap<String, String>();
		if(f.getSize() > 0 && f!=null) {
			String realpath = application.getRealPath(editor_img);
			// 파일명 얻기
			String fname = f.getOriginalFilename();
			
			// 파일명이 이미 있다면 파일명을 변경하야 한다.
			fname = FileRenameUtil.checkSameFileName(fname, realpath);
			try {
				f.transferTo(new File(realpath,fname));
				map.put("fname",fname );
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		String c_path = request.getContextPath();
		map.put("url",c_path+"/resources/editor_img");
		return map;// JSON표기법으로 변환되어 write.jsp의
				// sendImage의 함수의 done영역으로 보내진다.
	}
	
	@RequestMapping("/view")
	public ModelAndView view(String idx,String bname,int cPage) {
		ModelAndView mv = new ModelAndView();
		
		Object obj = session.getAttribute("hit_list");
		
		if(obj==null) {
			List<String> list = new ArrayList<String>();
			list.add(idx);
			session.setAttribute("hit_list", list);
			b_dao.hit(idx);
		}else {
			List<String> list = (ArrayList<String>)obj;
			if(!list.contains(idx)) {
				list.add(idx);
				b_dao.hit(idx);
			}
		}
		
		BbsVO vo = b_dao.view(idx);
		if (vo!=null) {
			mv.addObject("vo",vo);
		}
		mv.setViewName(bname+"/view");
		
		return mv;
	}
	@RequestMapping("/comm_write")
	public ModelAndView comm_write(CommVO cvo,String bname,String cPage) {
		ModelAndView mv = new ModelAndView();
		c_dao.add(cvo);
		mv.setViewName("redirect:/view?bname="+bname+"&cPage="+cPage+"&idx="+cvo.getB_idx());
		return mv;
	}
//	@RequestMapping(value = "edit", method = RequestMethod.GET)
//	public ModelAndView edit(String b_idx,String bname,String cPage) {
//		ModelAndView mv = new ModelAndView();
//		
//		//어떤 JSP에서 호출했는지? 구별하기 위해 contentType을 받아둔다.
//		String c_type = request.getContentType();
//		
//		
//		BbsVO vo = b_dao.view(b_idx);
//		mv.addObject("vo",vo);
//		mv.addObject("cPage", cPage);
//		mv.setViewName(bname+"/edit");
//		return mv;
//	}
//	@RequestMapping(value = "edit", method = RequestMethod.POST)
//	public ModelAndView edit_write(BbsVO vo,String cPage) {
//		ModelAndView mv = new ModelAndView();
//		MultipartFile file = vo.getFile();
//		String c_type = request.getContentType();
//		String oname=null;
//		String fname=null;
//		if(file.getSize() > 0 && c_type.startsWith("multipart") && file != null) {
//			String realpath = application.getRealPath(upload);
//			oname = file.getOriginalFilename();
//			fname = file.getOriginalFilename();
//			fname = FileRenameUtil.checkSameFileName(fname, realpath);
//			vo.setOri_name(oname);
//			vo.setFile_name(fname);
//			try {
//				file.transferTo(new File(realpath,fname));
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		b_dao.edit(vo);
//		mv.setViewName("redirect:/view?bname="+vo.getBname()+"&cPage="+cPage+"&idx="+vo.getB_idx());
//		return mv;
//	}
	@RequestMapping("/edit")
	public ModelAndView edit(BbsVO vo,String cPage) {
		ModelAndView mv = new ModelAndView();
		
		//어떤 JSP에서 호출했는지? 구별하기 위해 contentType을 받아둔다.
		String c_type = request.getContentType();
		// 일반 post방식의 form에서 호출 하면 ""application..."
		// get방식의 form에서 호출되었다면 "null"
		// 파일이 첨부된 form 에서 호출되었다면 c_type은"mulltupart..."
		if (c_type.startsWith("app")) {
			//수정 화면인 edit.jsp 로 가도록 해야함
			//a먼저 화면에 보여질 게시물 객체를 찾아서 mv에 저장하자!
			BbsVO bvo = b_dao.view(vo.getB_idx());
			System.out.println(bvo);
			mv.addObject("vo",bvo);
			mv.setViewName(vo.getBname()+"/edit");
		}else if(c_type.startsWith("multi")) {
			MultipartFile file = vo.getFile();
			String oname=null;
			String fname=null;
			if(file.getSize() > 0 && file != null) {
				String realpath = application.getRealPath(upload);
				oname = file.getOriginalFilename();
				fname = file.getOriginalFilename();
				fname = FileRenameUtil.checkSameFileName(fname, realpath);
				vo.setOri_name(oname);
				vo.setFile_name(fname);
				try {
					file.transferTo(new File(realpath,fname));
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			b_dao.edit(vo);
			mv.setViewName("redirect:/view?bname="+vo.getBname()+"&cPage="+cPage+"&idx="+vo.getB_idx());
		}
		return mv;
	}
	
	@RequestMapping(value = "del", method = RequestMethod.POST)
	public ModelAndView del(BbsVO vo) {
		ModelAndView mv = new ModelAndView();
		
		b_dao.delete(vo.getB_idx());
		
		mv.setViewName("redircect:/list?bname="+vo.getBname());
		return mv;
	}
}
