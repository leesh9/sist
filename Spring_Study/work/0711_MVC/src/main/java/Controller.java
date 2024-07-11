

import javax.servlet.annotation.WebServlet;

import org.springframework.web.servlet.DispatcherServlet;

@WebServlet("*.inc")
public class Controller extends DispatcherServlet {
	//현재 컨트롤러는 WEB-INF/{컨트롤러명}-servlet.xml과 연동되었다.
	
}
