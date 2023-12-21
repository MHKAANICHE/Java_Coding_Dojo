package com.codingdojo.bookclub.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Title should not be empty")
	private String title;
	@NotEmpty(message = "Author should not be empty")
	private String author;
	@NotEmpty(message = "My Thoughts section should not be empty")
	private String myThought;
// timestamps
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

// relationnel 
// Book may have only One (User) owner
// (User) owner may have many books
@ManyToOne (fetch=FetchType.LAZY)
@JoinColumn(name="owner")
	private User owner;
	
// Book may have only On (User)	borrower
// (User) borrower may have many books
@ManyToOne(fetch=FetchType.LAZY)	
@JoinColumn(name="borrower")
	private User borrower;
	
// zero-args constructor 
	public Book() {
	}

// timestamps methods
	@PrePersist
	private void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	private void onUpdate() {
		this.updatedAt = new Date();
	}

// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMyThought() {
		return myThought;
	}

	public void setMyThought(String myThought) {
		this.myThought = myThought;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getBorrower() {
		return borrower;
	}

	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}
	

	
}
