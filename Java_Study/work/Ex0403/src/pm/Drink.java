package pm;

public class Drink {
	String name;
	int price;
	
	public Drink() {}
	
	public Drink(String n, int p) {
		name=n;
		price=p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
