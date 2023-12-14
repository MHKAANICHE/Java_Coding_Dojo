package com.codingdojo.teammanager.models;

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
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "coaches")
public class Coache {
// Member variables: 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Coache first name is required!.")
	@Size(min = 3, max = 25, message = "Coache first name should be between 3 and 25 characters!.")
	private String firstName;
	@NotEmpty(message = "Coache last name is required!.")
	@Size(min = 3, max = 25, message = "Coache last name should be between 3 and 25 characters!.")
	private String lastName;
	@NotEmpty(message = "Coache age is required!.")
	private Integer age;
	@NotEmpty(message = "Coache role is required!.")
	@Size(min = 3, max = 25, message = "Coache role should be between 3 and 25 characters!.")
	private String role;

// datestamp
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
// realtional 
// coache vs team : ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;

//zero-args constructor
	public Coache() {
	}

// persistent
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}

//Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
