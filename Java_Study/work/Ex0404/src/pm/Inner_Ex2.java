package pm;

public class Inner_Ex2 {
	
	String str="쌍용교육센터";
	
	class Inner{
		int value = 10;
		
		public void test() {
			System.out.println(str+":"+value);
		}
	}
	
	public static void main(String[] args) {
		// 프로그램 시작
		Inner_Ex2 ex =new Inner_Ex2();
		
		//내부클래스 생성
		//Inner_Ex2.Inner ex2 = new Inner_Ex2().new Inner();
		Inner_Ex2.Inner ex2 = ex.new Inner();
		ex2.test();

	}

}
