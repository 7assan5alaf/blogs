package com.hk.blog.view;

public class ForgetResponse {
	private String message;
	private String link;
	public ForgetResponse() {
		// TODO Auto-generated constructor stub
	}
	public ForgetResponse(String message, String link) {
		super();
		this.message = message;
		this.link = link;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	

}
