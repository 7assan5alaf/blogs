package com.hk.blog.view;

import java.util.ArrayList;
import java.util.List;

public class ProfileResponse {
	
	private String email;
	private String fullName;
	private String address;
	private List<BlogsResponse>blogs=new ArrayList<>();
	
	public ProfileResponse() {
		
	}

	public ProfileResponse(String email, String fullName, String address, List<BlogsResponse> blogs) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.address = address;
		this.blogs = blogs;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<BlogsResponse> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<BlogsResponse> blogs) {
		this.blogs = blogs;
	}
	

}
