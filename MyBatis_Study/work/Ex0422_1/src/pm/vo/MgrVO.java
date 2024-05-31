package pm.vo;

import java.util.List;

public class MgrVO {
	private String empno,ename,job;
	private List<EmpVO> list ;
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public List<EmpVO> getList() {
		return list;
	}
	public void setList(List<EmpVO> list) {
		this.list = list;
	}
}
