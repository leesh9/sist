package ex3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex2.Action;
import ex2.DateAction;
import ex2.GreetAction;

/**
 * Servlet implementation class Controller3
 */
@WebServlet("/Controller3")
public class Controller3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// type이라는 파라미터 받기
				String type = request.getParameter("type");
				
				String viewPath = null;
				ex3.Action action =null;
				if(type==null || type.equalsIgnoreCase("greet")) {
					action = new ex3.GreetAction();
				}else if(type.equalsIgnoreCase("date")){
					action = new ex3.DateAction();
				}else if(type.equals("test")) {
					action = new ex3.Action() {

						@Override
						public String execute(HttpServletRequest request, HttpServletResponse response) {
							request.setAttribute("msg", "테스트 엑션입니다.");
							
							return "ex3/page1.jsp";
						
					}
				};
				}else {
					action = (req,res)-> {

						req.setAttribute("msg", "ㅋㅋ.");
						
						return "ex3/page1.jsp";
					
					};
				}
				viewPath =action.execute(request, response);
				
				//forward시킬 준비
				RequestDispatcher disp = request.getRequestDispatcher(viewPath);
				
				disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
