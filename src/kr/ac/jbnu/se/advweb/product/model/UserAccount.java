package kr.ac.jbnu.se.advweb.product.model;

import java.sql.Date;

public class UserAccount {


	
	private String id;
	private String password;
	private String name;
	private Date birth;
	private String gender;
	private int contact;
	private String email;
	private String address;

	public UserAccount() {

	}
	
	public UserAccount(String id, String password, String name, Date birth, String gender, int contact, String email, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.contact = contact;
		this.email = email;
		this.address = address;
	}

	public UserAccount(String password, int contact, String email, String address) {
		// TODO Auto-generated constructor stub
		this.password = password;
		this.contact = contact;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String checkGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
}