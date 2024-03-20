package com.entity;

public class Admin {

	private int id;
	private String adname;
	private String pass;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Admin(int id, String adname, String pass) {
		super();
		this.id = id;
		this.adname = adname;
		this.pass = pass;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
