package com.hk.blog.view;

import java.util.Date;

public class BlogsResponse {
	
	private String title;
	private String text;
	private String categoryName;
	private String username;
	private byte []cover;
	private Date date;
	private String email;
	public BlogsResponse() {
		// TODO Auto-generated constructor stub
	}
	public BlogsResponse(String title,byte[] cover, String text,Date date, String categoryName, String username, 
			String email) {
		super();
		this.title = title;
		this.text = text;
		this.categoryName = categoryName;
		this.username = username;
		this.cover = cover;
		this.date = date;
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public byte[] getCover() {
		return cover;
	}
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	
	public Date getDate() {
		return date;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
