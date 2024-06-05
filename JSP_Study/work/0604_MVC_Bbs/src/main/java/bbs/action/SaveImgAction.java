package bbs.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class SaveImgAction implements Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 첨부파일 즉, 이미지 파일은 MultipartRequest라는 객체를
		// 생성하면 업로드가 된다. 그렇다면 우린 MultipartRequest를
		// 어떻게 만드는지만 알고 있으면 된다. 이때 인자 5개짜리 생성자를
		// 호출하여 생성한다. 가장 중요한 부분은 이미지파일이 저장될
		// 경로(editor_img)가 절대경로로 미리 준비되어야 한다.
		ServletContext application =request.getServletContext();
		 
		String realPath = application.getRealPath("/editor_img");
		
		try {
			MultipartRequest mr = new MultipartRequest(request, realPath,5*1024*1024,"utf-8", new DefaultFileRenamePolicy());
			File f = mr.getFile("upload");
			String f_name = null;
			if(f!=null)
				f_name = f.getName();//저장된 파일명
			request.setAttribute("f_name", f_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/bbs/saveImg.jsp";
	}
}
