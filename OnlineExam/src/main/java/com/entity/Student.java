package com.entity;

public class Student {
	
	private String sid;
	private String name;
	private String email;
	private String pass;
	private String dob;
	private String gender;
	private String address;
	private String contact;
	
	//getter and setter
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
	public Student(String sid, String name, String email, String pass, String dob, String gender, String address,
			String contact) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.contact = contact;
	}
	
	
	
	
	public Student(String sid, String name, String email, String dob, String gender, String address, String contact) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.contact = contact;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
