package com.hk.blog.view;


public class ReportResponse {
	private String reportId;
	private String userId;
	private String username;
	private String body;
	public ReportResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportResponse(String reportId, String userId,String username, String body) {
		super();
		this.reportId = reportId;
		this.userId=userId;
		this.username=username;
		this.body = body;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
