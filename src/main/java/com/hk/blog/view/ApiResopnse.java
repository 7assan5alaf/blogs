package com.hk.blog.view;

public class ApiResopnse {

	private String message;
	private String status;
	public ApiResopnse() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ApiResopnse(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
