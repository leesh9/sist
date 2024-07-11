package ex1.vo;

public class Test3VO {
	private String name;
	private int age;
	private boolean live;
	
	public Test3VO(String name,int age,boolean live) {
		this.name = name;
		this.age = age;
		this.live = live;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
}
