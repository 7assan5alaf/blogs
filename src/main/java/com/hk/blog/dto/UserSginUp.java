package com.hk.blog.dto;

public class UserSginUp {
	
	private String fullName;
	private String email;
	private String onePassword;
	private String towPassword;
	private String phone;
	private String address;
	public UserSginUp() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserSginUp(String fullName, String email, String onePassword, String towPassword, String phone,
			String address) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.onePassword = onePassword;
		this.towPassword = towPassword;
		this.phone = phone;
		this.address = address;
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
	public String getOnePassword() {
		return onePassword;
	}
	public void setOnePassword(String onePassword) {
		this.onePassword = onePassword;
	}
	public String getTowPassword() {
		return towPassword;
	}
	public void setTowPassword(String towPassword) {
		this.towPassword = towPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
