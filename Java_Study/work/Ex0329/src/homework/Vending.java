package homework;

import java.util.Scanner;

public class Vending {

	Drink[] ar = new Drink[4];
	int money;
	
	public void init(){
		for(int i=0; i<ar.length;i++) {
			ar[i] = new Drink();
		}
		
		ar[0].setName("레츠비");
		ar[0].setPrice(500);
		
		ar[1].setName("사이다");
		ar[1].setPrice(700);
		
		ar[2].setName("콜라");
		ar[2].setPrice(700);
		
		ar[3].setName("웰치스");
		ar[3].setPrice(1000);
	}
	
	// 금액을 받아서 해당 금액에 선택가능한
	// 을료의 이름을 전달하는 기능
		
	public String insertCoin(int money) {		
		
//		String str="";
//		
//		for(int i=0; i<ar.length;i++) {
//			if(ar[i].price<=money) {
//				str.concat(ar[i].name+",");
//			}
//		}
//		
//		return str;
//		
//		이렇게 하면 리소스가 많아져서 속도가 느려진다.
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<ar.length;i++) {
			if(ar[i].price<=money) {
				sb.append(ar[i].name);
				sb.append(",");
			}
		}//for의 끝
		
		// 마지막에 있는 ","를 삭제
		// 그렇다면 마지막에 있는 ","의 위치값(index)을 알아내야 한다.
		// 위치 알아내는 기능 : indexOf(",") : 검색 기준이 왼쪽부터
//						   lastIndexOf(",") : 검색 기준이 오른쪽
		int idx = sb.lastIndexOf(",");
		
		//sb의 0번지부터 idx전까지 문자열 추출
		String msg = sb.substring(0,idx);
		return msg;
		
	}

}
