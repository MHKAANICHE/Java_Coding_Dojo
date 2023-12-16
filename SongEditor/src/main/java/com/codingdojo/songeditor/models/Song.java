package com.codingdojo.songeditor.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Tite is required!.")
//	@Column(unique = true)
	private String title;
	@NotEmpty(message = "Genre is required!.")
	private String genre;
	@NotEmpty(message = "Lyrics are required!.")
	private String lyrics;
// timestamps : 
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date craetedAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

// relational
	//Song has a unique Author : ManyToOne
	//Author has many Songs : OneToMany
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	private User author;


	// Song may have many contribution
	// Contribution has a unique song  
	// it's safe to use cascadeType.ALL in this case (delete song and all contributions associated with)
	@OneToMany(mappedBy = "song", fetch = FetchType.LAZY,cascade = CascadeType.ALL , orphanRemoval = true)
	private List<SongContribution> songContributions;	

// zero-args constructor
	public Song() {
		// initiazation 
		songContributions = new ArrayList<>();
	}

	@PrePersist
	public void onCrate() {
		this.craetedAt = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.craetedAt = new Date();
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	public Date getCraetedAt() {
		return craetedAt;
	}

	public void setCraetedAt(Date craetedAt) {
		this.craetedAt = craetedAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<SongContribution> getSongContributions() {
		return songContributions;
	}

	public void setSongContributions(List<SongContribution> songContributions) {
		this.songContributions = songContributions;
	}




}
