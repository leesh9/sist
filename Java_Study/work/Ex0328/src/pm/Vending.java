package pm;

import java.util.Scanner;

public class Vending {
	
	Drink[] drink = new Drink[4];
	int money;
	
	
	
	void call() {
		for(int i=0; i<drink.length;i++) {
			drink[i] = new Drink();
		}
		
		
		drink[0].set("레츠비", 500);
		drink[1].set("콜라", 700);
		drink[2].set("사이다", 700);
		drink[3].set("웰치스", 1000);
		
		for(int i=0; i<drink.length;i++) {
			System.out.print(drink[i].name+":"+drink[i].cost+"  ");
		}
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		
		System.out.print("금액: ");
		money = scan.nextInt();
		
		for(int i=0; i<drink.length;i++) {
			if(drink[i].cost<=money) {
				System.out.println(drink[i].getName());
			}
		}
		
	}//초기화 기능의 끝
	
	
}
