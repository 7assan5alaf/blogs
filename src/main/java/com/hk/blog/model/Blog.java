package com.hk.blog.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid",strategy = "uuid2")
	private String id;
	private String title;
	@Column(columnDefinition = "LONGTEXT")
	private String text;
	@Lob
	private byte []cover;
	private Date date;
	@ManyToOne(cascade =CascadeType.MERGE,fetch = FetchType.EAGER )
	@JoinColumn(columnDefinition = "categoryId",referencedColumnName = "id")
	private Category category;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(columnDefinition = "userId",referencedColumnName = "id")
	private User user;
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(columnDefinition = "reportId",referencedColumnName = "id")
	private Report report;
	public Blog() {
		super();
	}
	public Blog(String title, String text, byte[] cover, Date date, Category category, User user) {
		super();
		this.title = title;
		this.text = text;
		this.cover = cover;
		this.date = date;
		this.category = category;
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public byte[] getCover() {
		return cover;
	}
	public void setCover(byte[] cover) {
		this.cover = cover;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	
	

}
