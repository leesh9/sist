package mybatis.vo;

public class EmpVO {
	//emp테이블로부터 자원들을 가져오기 위한 클래스다.
	// 그래서 emp테이블에서 필요한 컬럼들을 맴버변수로 선언
	private String empno, ename,job,hiredate,deptno;

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

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
}
