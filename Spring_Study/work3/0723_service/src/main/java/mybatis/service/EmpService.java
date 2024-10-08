package mybatis.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

@Service
public class EmpService implements MyMapper{
	
	@Autowired
	private EmpDAO e_dao;
	
	@Override
	public EmpVO[] getList() {
		// TODO Auto-generated method stub
		return e_dao.total();
	}

	@Override
	public EmpVO[] search(String type, String value) {
		EmpVO[] ar=null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", type);
		map.put("searchValue", value);
		System.out.println(map);
		return e_dao.search(map);
	}
	
}
