package com.ss;

public enum EnumColor {
	MALE(0,"ÄĞ"),FEMALE(1,"Å®");
	
	
	
	private Integer gender;
	private String desc;
	private EnumColor(Integer gender, String desc) {
		this.gender = gender;
		this.desc = desc;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
