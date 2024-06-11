package bbs.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String fname = request.getParameter("fname");
		String bname = request.getParameter("bname");
		String cPage = request.getParameter("cPage");

		
		ServletContext application =request.getServletContext();
		String realPath = application.getRealPath("/upload/"+fname);
		File f = new File(realPath);
		
		//파일존재확인
		if (f.exists()) {
			byte[] buf = new byte[4096];
			int size = -1;
			
			//서버 입장에서는 실제 존재하는 파일의 내용을 읽기(InputStream)하여
			//요청한 사용자에게 응답으로 보내야(outputStream) 한다.
			// 읽고 쓰기 할 수 있는 스트림들을 준비하자!
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			
			//요청한 곳으로 파일의 내용을 보내주기 위해 필요한 스트림
			ServletOutputStream sos = null;//접속한자에게 응답으로 다운로드를
			//시켜야 한다. 이때 response로 얻을 수 있는 스트림이
			//ServletOutputStream이기 때문에 선언되었다.
			BufferedOutputStream bos = null;

			try {
				response.setContentType("application/x-msdownload");
				response.setHeader("Content-Disposition", "attachment;filename="+new String(fname.getBytes(),"8859_1"));
				fis = new FileInputStream(f);
				bis = new BufferedInputStream(fis);
				sos = response.getOutputStream();
				bos = new BufferedOutputStream(sos);

				


				while((size=bis.read(buf)) != -1) {
					bos.write(buf, 0, size);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if (fis != null) {
						fis.close();
					}
					if (bis != null) {
						bis.close();
					}
					if (sos != null) {
						sos.close();
					}
					if (bos != null) {
						bos.close();
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}


		return "Controller?type=view&bname="+bname+"&cPage="+cPage;
	}


}
