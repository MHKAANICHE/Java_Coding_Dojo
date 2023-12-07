package com.codingdojo.bookstoremvc.models;



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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotNull
@Size(min=5, max =25)
private String title;
@NotNull
@Size(min=5, max=25)
private String author;
@NotNull
@Size(min=5,max =200)
private String description;
@NotNull
@NotNull
@Size(min=2,max=15)
private String language;
@Min(100)
private Integer numberOfPages;
// Timestamp
@Column(updatable=false)
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date createdAt;
@DateTimeFormat(pattern = "yyyy-MM-dd")
private Date updatedAt;

// No args Constructor
public Book() {}
// Full args Contructor
public Book(String title, String author, String description,String language,Integer numberOfPages) {
	super();
	this.title = title;
	this.author = author;
	this.description = description;
	this.numberOfPages = numberOfPages;
	this.language = language;
}

@PrePersist
protected void onCreate() {
this.createdAt = new Date();	
}

@PreUpdate
protected void onUpdate() {
this.updatedAt = new Date();
}
// Getters and Setters

public Long getId() {
	return id;
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

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Integer getNumberOfPages() {
	return numberOfPages;
}

public void setNumberOfPages(Integer numberOfPages) {
	this.numberOfPages = numberOfPages;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

public Date getCreatedAt() {
	return createdAt;
}


public Date getUpdatedAt() {
	return updatedAt;
}



}
