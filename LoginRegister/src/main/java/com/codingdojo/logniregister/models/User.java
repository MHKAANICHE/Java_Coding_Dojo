package com.codingdojo.logniregister.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "User name is required!.")
	@Size(min = 3, max = 25, message = "Username should be between 3 to 25 charaters!.")
	private String userName;
	@NotEmpty(message = "Password is required!.")
	// be aware of max (BCrypt produce a hash of 60 characters) 
	@Size(min = 3, max = 128, message = "Password should be between 3 to 25 charaters!.")
	private String password;
	@NotEmpty(message = "email is required!.")
	@Email(message="Please enter a valid email adress!")
	private String email;
// Transient !
	@Transient
	@NotEmpty(message = "Password confirmation is required!.")
	@Size(min = 3, max = 128, message = "Password confirmation should match your password!.")
	private String confirmPW;
		
// Timestamps:
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cratedAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

// relational : 

// zero-args constructor
	public User() {
	}

// Timestamps methods: 
	@PrePersist
	public void onCreate() {
		this.cratedAt = new Date();
	}

	@PreUpdate
	public void onUpdated() {
		this.updatedAt = new Date();
	}

// Getters and Setters 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmPW() {
		return confirmPW;
	}

	public void setConfirmPW(String confirmPW) {
		this.confirmPW = confirmPW;
	}

	public Date getCratedAt() {
		return cratedAt;
	}

	public void setCratedAt(Date cratedAt) {
		this.cratedAt = cratedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




}
