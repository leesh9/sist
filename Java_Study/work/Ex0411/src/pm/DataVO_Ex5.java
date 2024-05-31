package pm;

import java.io.Serializable;

public class DataVO_Ex5 implements Serializable{
	String num;
	String name;
	String team;
	String pos;
	String date;
	
	public DataVO_Ex5(String i,String n,String t,String p,String d){
		this.num =i;
		this.name = n;
		this.team = t;
		this.pos = p;
		this.date = d;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
