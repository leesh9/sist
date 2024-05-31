package pm;

public class StaffSys {
	Staff[] staff = new Staff[5];
	
	public StaffSys() {
		init();
	}
	
	public void init() {
		staff[0]=new Staff(120,"일지매","사원","개발1팀");
		staff[1]=new Staff(222,"지매일","대리","기획팀");
		staff[2]=new Staff(50,"홍길동","부장","인사팀");
		staff[3]=new Staff(89,"남기찬","과장","영업2팀");
		staff[4]=new Staff(75,"권성은","대리","인사팀");
			
	}
	
	public String search(String str) {
		
		if(str == null || str.trim().length()==0)
			return null;
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<staff.length;i++) {
			if(staff[i].name.contains(str)) {
				sb.append(staff[i].idx);
				sb.append("|");
				sb.append(staff[i].name);
				sb.append("|");
				sb.append(staff[i].rank);
				sb.append("|");
				sb.append(staff[i].team);
				sb.append("\r\n");
					
			}
		}
			return sb.toString();
	}
	
}
