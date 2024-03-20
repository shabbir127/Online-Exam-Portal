package com.entity;

public class Question {
	
	private int qid;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctAnwser;
	private String courseName;
	
	
	//getter N setter...
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getCorrectAnwser() {
		return correctAnwser;
	}
	public void setCorrectAnwser(String correctAnwser) {
		this.correctAnwser = correctAnwser;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	//
	public Question(String question, String option1, String option2, String option3, String option4,
			String correctAnwser, String courseName) {
		super();
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnwser = correctAnwser;
		this.courseName = courseName;
	}
	
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Question(int qid, String question, String option1, String option2, String option3, String option4,
			String correctAnwser, String courseName) {
		super();
		this.qid = qid;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnwser = correctAnwser;
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Question [qid=" + qid + ", question=" + question + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", correctAnwser=" + correctAnwser + ", courseName="
				+ courseName + "]";
	}
	public Question(int qid, String courseName) {
		super();
		this.qid = qid;
		this.courseName = courseName;
	}
	
	
	
	
	

}
