package pm;

public class DeptVO {
	//dept테이블로 부터 데이터를 가져와서 객체화 시키기 위해 필요한 클래스
	//dept 테이블에서 가져올 컬럼명들을 맴버변수로 선언하자
	private String deptno, dname, loc_code;

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

	public String getLoc_code() {
		return loc_code;
	}

	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}
}
