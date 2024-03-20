package com.entity;

public class Result {
	
	private int id;
	private String name;
	private String course;
	private double score;
	private int totalQuestions;
	private int ObtainMark;
	
	public int getObtainMark() {
		return ObtainMark;
	}
	public void setObtainMark(int obtainMark) {
		ObtainMark = obtainMark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public Result(String name, String course, double score, int totalQuestions) {
		super();
		this.name = name;
		this.course = course;
		this.score = score;
		this.totalQuestions = totalQuestions;
	}
	
	public Result(String name, String course, double score, int totalQuestions, int obtainMark) {
		super();
		this.name = name;
		this.course = course;
		this.score = score;
		this.totalQuestions = totalQuestions;
		ObtainMark = obtainMark;
	}
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
