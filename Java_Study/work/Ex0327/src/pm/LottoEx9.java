package pm;

public class LottoEx9 {

	public static void main(String[] args) {
		// 정수 6개를 저장하는 배열 생성
		int[] lotto = new int[6];
		
		//1~45까지의 수들 중 난수를 발생하여 lotto라는 배열에
		//저장시킨다.단, 중복이 되어서는 안된다.
		System.out.println("로또번호 추첨");	
		
		int i =0;
		
		p:while(i<lotto.length) {
			lotto[i]=(int)(Math.random()*45+1);
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					continue p;
				}
			}
			System.out.printf("%3d",lotto[i]);
			i++;
		}
	}

}
