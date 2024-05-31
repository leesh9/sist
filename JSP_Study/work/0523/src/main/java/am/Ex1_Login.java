package am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import am.vo.MemVO;

/**
 * Servlet implementation class Ex1_Login
 */
public class Ex1_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 보통 로그인을 수행할 때 아이디와 비밀번호를 한글로 하지 않으므로
		// 요청시 한글처리는 생략!
		//1.파라미터들(mid,mpw) 받기
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		//DB로부터 인증받기 위해 login맵퍼를 호출해야 한다.
		Map<String, String> map = new HashMap<>();
		map.put("mid", mid);
		map.put("mpw", mpw);
		
		Reader r = Resources.getResourceAsReader("am/config/config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		r.close();
		//-----------------------------------------------------------------
		SqlSession ss = factory.openSession();
		
		MemVO mvo = ss.selectOne("member.login",map);
		if(mvo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("mvo", mvo);
			response.sendRedirect("Ex1_Service");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
