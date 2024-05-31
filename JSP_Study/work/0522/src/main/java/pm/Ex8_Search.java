package pm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pm.vo.EmpVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Servlet implementation class Ex8_Search
 */
public class Ex8_Search extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex8_Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Reader r = Resources.getResourceAsReader("pm/config/config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession ss = factory.openSession();
		
		
		String type = request.getParameter("s_type");
		String str = request.getParameter("s_txt");
		
		List<EmpVO> list = ss.selectList("emp.search_"+type,str);
		
		StringBuffer sb = new StringBuffer();
				sb.append("<ol>");
		for(int i=0;i<list.size();i++) {
			//list에서 하나의 EmpVO객체를 얻어낸다.
			EmpVO vo = list.get(i);
			sb.append("<li>");
			sb.append(vo.getEmpno());
			sb.append("/");
			sb.append(vo.getEname());
			sb.append("/");
			sb.append(vo.getJob());
			sb.append("</li>");
		}
		sb.append("</ol>");
		
		PrintWriter out = response.getWriter();
		
		//응답 시작
		out.println("<h1>사원목록</h1>");
		out.println(sb.toString());//ol태그
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
