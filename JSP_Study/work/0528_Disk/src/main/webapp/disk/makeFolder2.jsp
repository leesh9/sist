<%@page import="mybatis.vo.MemVO"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청시 한글처리
	request.setCharacterEncoding("utf-8");

	//파라미터들 받기(cPath, f_name)
	String cPath = request.getParameter("cPath");//위치
	String f_name = request.getParameter("f_name");//폴더명
	
	//절대경로 생성
	String path = application.getRealPath("/members/"+cPath+"/"+f_name);
	
	//절대경로를 가지고 File객체생성
	File f = new File(path);
	
	if(!f.exists()){
		f.mkdir(); //폴더 생성
	}
	
	 //원래 있던 위치(cPath)로 강제 이동
	 

%>

<%
	
	//현재 페이지는 무조건 로그인이 되어 있어야 사용 가능한 페이지다.
	//이쯤에서 로그인 여부를 확인해야 한다.
	Object obj= session.getAttribute("mvo");
	MemVO mvo=null;
	if(obj != null){
		mvo = (MemVO)obj; 
	}
	//현재 사용자가 보고자하는 현재 위치값(cPath)을 파라미터로 받는다.
	String dir = request.getParameter("cPath");
	// index.jsp에서 들어온 경우는 dir에 null을 받는다.
	
	//사용자가 폴더를 선택했을 경우라면 f_name이라는 파라미터도 받는다.
	String fname = request.getParameter("f_name");
	
	//나중에 현재위치 값을 잊어버리지 않기 위해 세션에 저장해 두자!
	session.setAttribute("dir", dir);
	//이것은 나중에 파일올리기 할 때 사용해야 한다.
%>


<%
		if(!dir.equals(mvo.getM_id())){
			// 상위로... 기능을 부여한다.
			// 예를 들어 현재 위치 값(dir)이 "test/abc/a123"라고
			// 가정하면 상위로의 기능은 "test/abc"의 위치를 의미한다.
			// 이렇게 하기 위해서는
			// 현재 위치값에서 가장~~! 뒤에 있는 "/"의 index를
			// 얻어내어 맨 앞에서 그 index까지만 substring하면 된다.
			int idx = dir.lastIndexOf("/");
			String upPath = dir.substring(0,idx);
			
		%>
			<tr>
				<td>↑</td>
				<td colspan="2">
					<a href="javascript:goUp('<%=upPath %>')">
						상위로...
					</a>
				</td>
				
			</tr>
		<%
			} 
			//현재위치의 하위 내용을 출력하기 위해 현재위치 값(dir)을 가지고
			//File객체를 생성해야 한다. 그렇게 하기 위해서는 먼저
			//절대경로가 필요하다.
			String realPath = application.getRealPath("/members/"+dir);
			
			File s_file = new File(realPath);
			//하위 요소들 얻기
			File[] sub_list = s_file.listFiles();//하위 요소들 얻기
			for(File fs : sub_list){
		%>
			
			<tr>
				<td>
				<%if(fs.isFile()){ %>

						<img src="../images/file.png"/>
				<%}else{ %>
						<img src="../images/folder.png"/>
				<%} %>
				</td>
				<td>

					<a href="javascript: gogo('<%=fs.getName() %>')">
						<%=fs.getName() %>
					</a>

					<a href="javascript:down('')">
						
					</a>
				
				</td>
				<td></td>
			</tr>
		<%} %>