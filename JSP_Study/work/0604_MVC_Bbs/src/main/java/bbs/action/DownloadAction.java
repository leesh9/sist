package bbs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setCharacterEncoding("utf-8");
		String fname = request.getParameter("fname");

		String realPath = request.getServletContext().getRealPath("/upload/"+fname);
		


		
		return null;
	}

	
}
