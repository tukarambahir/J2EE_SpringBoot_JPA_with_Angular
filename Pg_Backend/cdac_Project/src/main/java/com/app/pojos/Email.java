package com.app.pojos;

public class Email {
	private String destEmail;
	private String message;
	private String subject;
	
	public Email() {
	   System.out.println("in Email pojo contructor");
	}
	public String getDestEmail() {
		return destEmail;
	}
	public void setDestEmail(String destEmail) {
		this.destEmail = destEmail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Email [destEmail=" + destEmail + ", message=" + message + ", subject=" + subject + "]";
	}
	
	

}
