package kr.ac.jbnu.se.advweb.product.model;

import java.sql.Date;

public class StaticData {
	private String gender ;
	private Date birth;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
