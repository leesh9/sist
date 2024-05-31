package am.vo;

public class DeptVO {
	private String deptno, dname;
	private LocVO lvo;

	public String getDeptno() {
		return deptno;
	}

	public LocVO getLvo() {
		return lvo;
	}

	public void setLvo(LocVO lvo) {
		this.lvo = lvo;
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
}
