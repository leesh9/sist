package am;

public class EmpVO {
	// emp 라는 테이블로 부터 자원을 가져와서 객체화 시키는 클래스
	// 테이블로 부터 가지고올 컬럼명들을 맴버변수로 선언해야한다.
	private String empno, ename, job;

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
