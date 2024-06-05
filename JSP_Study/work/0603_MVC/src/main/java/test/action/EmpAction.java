package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.EmpDao;
import mybatis.vo.EmpVO;

public class EmpAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 사원 목록을 EmpDAO에서 가져오긴
		EmpVO[] ar = EmpDao.getList();
		
		// 위에서 얻어낸 사원들의 목록을 request에 "emp"라는 이름으로
		// 저장하면된다.
		request.setAttribute("emp", ar);
		
		return "emp.jsp";//뷰페이지의 경로를 반환한다.
	}

}
