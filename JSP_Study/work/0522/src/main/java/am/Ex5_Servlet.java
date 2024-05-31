package am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Ex5_Servlet
 */
public class Ex5_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex5_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답시 한글처리
		response.setContentType("text/html; cahrset=utf-8"); 
		// 요청시 한글처리
		request.setCharacterEncoding("utf-8");
		
		String[] friends = request.getParameterValues("f_name");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>----친구----</h2>");
		int cnt = 0;
		for(int i=0;i<friends.length;i++) {
			if(friends[i].trim().length()>0) {
				out.println("<h2>"+friends[i]+"</h2>");
				++cnt;
			}
		}
		
		out.println("<h2>친구 "+cnt+"명</h2>");
		out.close();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
