package com.hk.blog.view;

public class UserResponse {

	private String userId;
	private String fullName;
	private String email;
	private byte []image;
	
	
	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserResponse(String userId, String fullName, String email, byte[] image) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.image = image;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
