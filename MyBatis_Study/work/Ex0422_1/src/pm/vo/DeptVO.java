package pm.vo;

import java.util.List;

public class DeptVO {
	private String deptno,dname;
	
	//현 부서에 종사하는 사원들...
	private List<EmpVO> e_list;
	
	//도시정보
	private LocVO lvo;

	public LocVO getLvo() {
		return lvo;
	}

	public void setLvo(LocVO lvo) {
		this.lvo = lvo;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<EmpVO> getE_list() {
		return e_list;
	}

	public void setE_list(List<EmpVO> e_list) {
		this.e_list = e_list;
	}
	
}
