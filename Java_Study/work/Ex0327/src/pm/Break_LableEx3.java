package pm;

public class Break_LableEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//bk 라는 이름으로 바깥쪽 for문에게 명칭을 부여하자
		bk:for(int k=0; k<3; k++) {
			for(int i=0; i<5; i++) {
				System.out.printf("%2d",i+1);
//				(i+1)이 3과 같다면 가장 가까운 반복문 탈출
				if((i+1)%3==0)
					break bk;//bk라는 이름의 반복문 탈출
				
			}
			System.out.println();//줄 바꿈
		}

	}

}
