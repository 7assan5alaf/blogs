package com.hk.blog.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
	 
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid",strategy = "uuid2")
	private String id;
	private String fullName;
	private String email;
	private String password;
	@Column(name = "address")
	private String address;
	@Lob
    private byte []image;
	private boolean enable=true; 
	private String role="";
	private String phone;
	private String bio;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String fullName, String bio,String email, String password, String address, byte[] image,String phone) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.image = image;
		this.phone=phone;
		this.bio=bio;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
         
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	
	 public String getRole() {
		return role;
	}
	 public void setRole(String role) {
		 this.role=role;
	 }
	public List<String> getListOfRoles() {
			
			if(this.role.length()>0) {
				return Arrays.asList(this.role.split(","));
			}
			return new ArrayList<String>();
		}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
		
}
