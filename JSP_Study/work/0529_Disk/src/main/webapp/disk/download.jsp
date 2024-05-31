<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");

	//전달되어 오는 파라미터들 받기(f_name,cPath)
	String cPath =request.getParameter("cPath");//파일위치
	String fname =request.getParameter("f_name");//파일명
	
	//위의 값들을 연결하여 절대 경로로 만든다.(서버의 특정 위치)
	String realpath = application.getRealPath("/members"+cPath+"/"+fname);
	File f = new File(realpath);
	
	//존재여부 확인
	if(f.exists()){
		byte[] buf = new byte[4069];
		int size = -1;
		
		//다운로드에 필요한 스트림들 준비
		BufferedInputStream bis = null;
		FileInputStream fis = null;
		
		BufferedOutputStream bos = null;
		ServletOutputStream sos = null;//응답을 하는 것이
		//접속자 PC로 다운로드를 시켜야 하기 때문에 response를 통해
		//스트림을 생성해야 한다.
		//즉, response로부터 얻어지는 OutputStream이 바로
		// ServletOutPutStream이다.
		
		try{
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename="+new String(fname.getBytes(),"8859_1"));
			
			
			// 다운로드할 File과 연결되는 스트림 생성
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);
			
			//response를 통해 이미 out이라는 스트림이 존재하므로
			//오류가 발생한다. 이것을 잠시 없앤다.
			out.clear();
			out = pageContext.pushBody();
			
			sos = response.getOutputStream();//***
			bos = new BufferedOutputStream(sos);
			
			//스트림이 모두 준비 완료 되었으니 읽기한 후 바로 쓰기를 하여
			//요청한 곳으로 부터 다운이 되도록 한다.
			while((size = bis.read(buf))!=-1){
				//읽은 자원은 buf가 가지고 있으며, 읽은 바이트 수는
				//size가 기억한다.
				bos.write(buf,0,size);
				bos.flush();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fis != null)
					fis.close();
				if(bis != null)
					bis.close();
				if(sos != null)
					sos.close();
				if(bos != null)
					bos.close();
				
			}catch(Exception e){
				
			}
		}
		response.sendRedirect("myDisk.jsp");
		
	}
%>