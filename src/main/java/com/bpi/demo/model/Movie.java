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
	private Long id;
	
	@Column ( nullable = false )
	private String title;
	
	@Column ( nullable = false )
	private String cast;
	
	@Column ( nullable = false )
	private String director;
	
	@Column ( nullable = false ,
			  columnDefinition = "TIMESTAMP" )
	private Timestamp year;
	
	public Movie () {
		
	}

	public Movie(long id, String title, String cast, String director, Timestamp year) {
		this.id = id;
		this.title = title;
		this.cast = cast;
		this.director = director;
		this.year = year;
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

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Timestamp getYear() {
		return year;
	}

	public void setYear(Timestamp year) {
		this.year = year;
	}
	

}
