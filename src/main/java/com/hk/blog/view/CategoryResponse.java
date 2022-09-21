package com.hk.blog.view;

public class CategoryResponse {
	
	private String name;
	private byte []cover;
	public CategoryResponse() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getCover() {
		return cover;
	}
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	public CategoryResponse(String name, byte[] cover) {
		super();
		this.name = name;
		this.cover = cover;
	}
	

}
