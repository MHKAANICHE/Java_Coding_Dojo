package com.codingdojo.burgertracker1.models;


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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class Burger {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;
@NotNull(message ="Input should not be blank")
@Size(min=3 , max=15, message="Should be 3 characters at least and 15 characters at max.")
private String name;
@NotNull(message ="Input should not be blank")
@Size(min=3 , max=15, message="Should be 3 characters at least and 15 characters at max.")
private String restaurant;
@NotNull(message ="Input should not be blank")
@Min(value = 0 ,message="Value should be between 0 and 5.")
@Max(value= 5 ,message="Value should be between 0 and 5.")
private Integer rating;

//TimeStamp Attributes
@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAT;

public Burger() {}
public Burger(String name, String restaurant, Integer rating) {
super();
this.name = name;
this.restaurant = restaurant;
this.rating = rating;
}

//TimeStamp methods
@PrePersist
private void onCreated() {
this.createdAt= new Date();
}
@PreUpdate
private void onUpdate() {
this.updatedAT = new Date();
}

//Getters and setters
public Long getId() {
	return id;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRestaurant() {
	return restaurant;
}
public void setRestaurant(String restaurant) {
	this.restaurant = restaurant;
}
public Integer getRating() {
	return rating;
}
public void setRating(Integer rating) {
	this.rating = rating;
}
public Date getCreatedAt() {
	return createdAt;
}

public Date getUpdatedAT() {
	return updatedAT;
}


}
