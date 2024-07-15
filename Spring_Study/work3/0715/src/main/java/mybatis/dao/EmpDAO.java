package mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mybatis.vo.EmpVO;

@Component
public class EmpDAO {
	@Autowired
	private SqlSessionTemplate ss;
	
	// ������� �迭�� ��ȯ�ϴ� ���
	public EmpVO[] getList() {
		EmpVO[] ar = null;
		List<EmpVO> list = ss.selectList("emp.all");
		//list�� null�� �ƴϰ� ������� �ʴٸ� �迭�� ��ȯ
		if(list != null && list.size()>0) {
			ar = new EmpVO[list.size()];
			//list�� ��Ҹ� ����ִ� �迭�� �����Ѵ�.
			list.toArray(ar);
		}
		
		return ar;
	}
	
	public EmpVO[] searchList(String searchType,String searchValue) {
		EmpVO[] ar=null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		List<EmpVO> list = ss.selectList("emp.search",map);
		//list�� null�� �ƴϰ� ������� �ʴٸ� �迭�� ��ȯ
		if(list != null && list.size()>0) {
			ar = new EmpVO[list.size()];
			//list�� ��Ҹ� ����ִ� �迭�� �����Ѵ�.
			list.toArray(ar);
		}
		return ar;
	}
}
