package com.hk.blog.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Report {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
	private String id;
    
    @Column(columnDefinition = "LONGTEXT")
    private String body;
    @OneToOne(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(columnDefinition = "userId",referencedColumnName = "id")
    private User user;
    
    
    
    public Report() {
		// TODO Auto-generated constructor stub
	}

	public Report(String body, User user) {
		super();
		this.body = body;
		this.user=user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
    

}
