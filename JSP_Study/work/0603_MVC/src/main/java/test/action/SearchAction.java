package test.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.EmpDao;
import mybatis.vo.EmpVO;

public class SearchAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		Map<String, String> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		EmpVO[] ar = EmpDAO.searchList(map);
		request.setAttribute("ar", ar);
		return "searchEmp.jsp";
	}
}