package am;

public class Book {
	String name;
	String publisher;
	String location;
	boolean rental;
	
	public void set(String n,String p,String l,boolean r){
		name =n;
		publisher = p;
		location = l;
		rental = r;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setPublisher(String p) {
		publisher =p;
	}
	
	public void setlocation(String l) {
		location = l;
	}
	
	public void setR(boolean b) {
		rental = b;
	}
}
