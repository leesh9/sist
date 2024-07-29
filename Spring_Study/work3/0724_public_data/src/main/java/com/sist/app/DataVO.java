package com.sist.app;

public class DataVO {
	private String pm10Value; //미세먼지 농도
	private String pm10Grade; // 미세먼지 등급
	private String coValue; //일산화탄소농도
	private String coGrade; //일산화탄소등급
	private String khaiValue; //통합대기환경수치
	private String khaiGrade;//통합대기환경등급
	public String getPm10Value() {
		return pm10Value;
	}
	public void setPm10Value(String pm10Value) {
		this.pm10Value = pm10Value;
	}
	public String getPm10Grade() {
		return pm10Grade;
	}
	public void setPm10Grade(String pm10Grade) {
		this.pm10Grade = pm10Grade;
	}
	public String getCoValue() {
		return coValue;
	}
	public void setCoValue(String coValue) {
		this.coValue = coValue;
	}
	public String getCoGrade() {
		return coGrade;
	}
	public void setCoGrade(String coGrade) {
		this.coGrade = coGrade;
	}
	public String getKhaiValue() {
		return khaiValue;
	}
	public void setKhaiValue(String khaiValue) {
		this.khaiValue = khaiValue;
	}
	public String getKhaiGrade() {
		return khaiGrade;
	}
	public void setKhaiGrade(String khaiGrade) {
		this.khaiGrade = khaiGrade;
	}

	
}
