package am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import am.vo.MemVO;

/**
 * Servlet implementation class Ex1_Service
 */
public class Ex1_Service extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1_Service() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 여기는 로그인을 한 회원들만 서비스 하는 곳이다.라고 가정하자!
		// 그럼 요청한 사용자가 로그인을 했는지? 안했는지? 판단을 해야 한다.
		// 그 판단은 요청자의 HttpSession을 얻어 내어 그 안에
		// "mvo"로 저장한 자원이 있다면 로그인을 수행했다고 봐야 한다.
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("mvo");
		MemVO mvo=null;
		if (obj!=null) {
			//로그인을 한 상태
			mvo = (MemVO)obj;
			out.println("<h2>"+mvo.getM_name()+"님 환영!</h2>");
			out.println("<button type='button'");
			out.println("onclick='javascript:location.href=\"Ex1_Logout\"'>");
			out.println("로그아웃</button>");
		}else {
			//로그인을 안한 상태
			out.println("<h2>로그인이 필요합니다.</h2>");
			out.println("<button type='button'");
			out.println("onclick='javascript:location.href=\"ex1_login.html\"'>");
			out.println("로그아웃</button>");
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
