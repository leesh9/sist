package test.action;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import mybatis.dao.DeptDao;
import mybatis.vo.DeptVO;

public class DeptAction implements Action{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		DeptVO[] ar = DeptDao.getDeptList();
		
		request.setAttribute("dept", ar);
		return "dept.jsp";
	}
}
