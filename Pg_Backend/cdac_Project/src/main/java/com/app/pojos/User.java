package com.app.pojos;
import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name = "users_tbl")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@Column(length = 20,unique = true)
	private String email;
	private int age;
	@Lob
	private byte[] image;
	@Column(length = 30)
	private String imageContentType;

	public User() {
		// TODO Auto-generated constructor stub
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", age=" + age + ", image=" + Arrays.toString(image)
				+ "]";
	}	
	
}
