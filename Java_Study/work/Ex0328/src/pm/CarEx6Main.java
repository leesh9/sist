package pm;

public class CarEx6Main {

	public static void main(String[] args) {
		// 자동차 객체 생성
		CarEx6 car1 = new CarEx6();
		
		System.out.println(car1.speed);//0
		car1.speedUp();//속도 증가
		car1.speedUp();//속도 증가
		car1.speedUp();//속도 증가
		car1.speedUp();//속도 증가
		car1.speedUp();//속도 증가
		System.out.println(car1.speed);//5
		
		car1.stop();//정지
		System.out.println(car1.speed);//0
		
		

	}

}
