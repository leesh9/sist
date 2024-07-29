package mybatis.service;

import org.springframework.stereotype.Service;

import mybatis.vo.EmpVO;

@Service
public interface MyMapper {
	Object[] getList();
	
	Object[] search(String type,String value);
	
}
