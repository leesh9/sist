package bbs.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class EditAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String b_idx = request.getParameter("b_idx");
		String bname = request.getParameter("bname");
		int idx=0;
		if(b_idx!=null)
			idx = Integer.parseInt(b_idx);
		BbsVO bvo = BbsDAO.view(idx);
		request.setAttribute("bvo", bvo);
		
		// bname이라는 파라미터 값 받기
		String viewPath = null;
		
		
		String enc_type = request.getContentType();
		if(enc_type == null) {
			viewPath = "/jsp/"+bname+"/edit.jsp";
		}else if(enc_type.startsWith("multipart")) {		
			
			try {
				//첨부된 파일이 저장될 곳을 절대경로로 만들어야 한다.
				ServletContext application = 
						request.getServletContext();
				
				String realPath = 
						application.getRealPath("/upload");
				
				//첨부파일과 다른 파라미터들을 받기 위해
				//MultipartRequest객체를 생성
				MultipartRequest mr = 
					new MultipartRequest(request, 
						realPath, 5*1024*1024, "utf-8",
						new DefaultFileRenamePolicy());
				//이때 이미 첨부파일은 upload라는 폴더에 저장된 상태다.
				
				//나머지 파라미터 값들 받기
				String title = mr.getParameter("title");
				String writer = mr.getParameter("writer");
				String content = mr.getParameter("content");
				String bname2 = mr.getParameter("bname");
				String i = mr.getParameter("b_idx");
				//이미 업로드된 첨부파일이 파일명이 변경됐을 것 같은 느낌...
				File f = mr.getFile("file");
				String fname = null;
				String oname = null;
				
				//만약! 파일첨부하지 않았다면 f에는 null이다.
				if(f != null) {
					fname = f.getName();// 현재 저장된 파일명
					
					//원래 파일명
					oname = mr.getOriginalFileName("file");
				}
				
				// 요청자의 ip
				String ip = request.getRemoteAddr();
				System.out.println(b_idx);
				int cnt = BbsDAO.edit(i,title, writer, content, fname, oname, ip, bname2);
				viewPath="Controller?type=list&bname="+bname2;
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		return viewPath;
	}

}
