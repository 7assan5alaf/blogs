package com.hk.blog.dto;

public class UserSginIn {
	private String email;
	private String password;
	
	public UserSginIn() {
		// TODO Auto-generated constructor stub
	}
	
	public UserSginIn(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
