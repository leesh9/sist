package am;

public class Library {
	Book[] ar = new Book[4];
	
	public void init() {
		for(int i=0;i<ar.length;i++) {
			ar[i]=new Book();
		}
		
		ar[0].set("이것이 자바다", "한빛 미디어", "A-102", false);
		ar[1].set("자바 바이블", "한빛 아카데미", "A-07", true);
		ar[2].set("어린왕자", "어쩌구 출판사", "B-85", false);
		ar[3].set("노인과 바다", "저쩌구 출판사", "C-45", true);
	}
	
	public String search(String n) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<ar.length;i++) {
			if(ar[i].name.contains(n)) {
				sb.append(ar[i].name);
				sb.append("|");
				sb.append(ar[i].publisher);
				sb.append("|");
				sb.append(ar[i].location);
				sb.append("|");
				if(ar[i].rental) 
					sb.append("대여중");
				else 
					sb.append("대여가능");
				sb.append("\r\n");
			}
			
			
		}
		return sb.toString();
		
	}
}
