package com.bpi.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column ( nullable = false )
	private String title;
	
	@Column ( nullable = false )
	private String castMembers;
	
	@Column ( nullable = false )
	private String director;
	
	@Column ( nullable = false ,
			  columnDefinition = "TIMESTAMP" )
	private String releaseDate;
	
	public Movie () {
		
	}

	public Movie(Long id, String title, String cast, String director, String releaseDate) {
		this.id = id;
		this.title = title;
		this.castMembers = cast;
		this.director = director;
		this.releaseDate = releaseDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCastMembers() {
		return castMembers;
	}

	public void setCastMembers(String castMembers) {
		this.castMembers = castMembers;
	}

	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}


	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
