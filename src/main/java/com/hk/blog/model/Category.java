package com.hk.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Category {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid",strategy = "uuid2")
	private String id;
	private String name;
	@Lob
	private byte []image;
    
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	
	public Category(String name, byte[] image) {
		super();
		this.name = name;
		this.image = image;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	
}
