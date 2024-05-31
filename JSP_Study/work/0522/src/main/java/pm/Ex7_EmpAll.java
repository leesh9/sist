package pm;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pm.vo.EmpVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Servlet implementation class Ex7_EmpAll
 */
public class Ex7_EmpAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex7_EmpAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// myBatis를 활용하기 위해
		// mybatis-3.x.x.jar 와 mysql-connector-j-X-X.jar파일들을
		// webapp/WEB-INF/lib에 넣어야한다.
		
		//vo객체 정의한 후, mapper파일 생성 그리고 환경설정 파일
		// config.xml생성
		
		//이제 환경설정파일을 연결하는 스트림 생성
		Reader r = Resources.getResourceAsReader("pm/config/config.xml");
		
		//준비된 Reader를 활용해서 SqlSessionFactory를 생성하자
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		r.close();
		//---------- 한번만 수행하면 좋은 내용
		SqlSession ss = factory.openSession();
		
		List<EmpVO> list = ss.selectList("emp.all");
		StringBuffer sb = new StringBuffer();//결과를 문자열로 편집하기위해 필요함
		
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
		
		//응답시 한글처리
		response.setContentType("text/html; charset=utf-8");
		
		//응답을 위해 스트림 준비
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
