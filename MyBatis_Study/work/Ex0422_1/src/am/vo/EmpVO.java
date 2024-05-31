package am.vo;

public class EmpVO {
	private String empno, ename, job,sal;
	
	private DeptVO dvo;
	
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

	public DeptVO getDvo() {
		return dvo;
	}

	public void setDvo(DeptVO dvo) {
		this.dvo = dvo;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}
}
