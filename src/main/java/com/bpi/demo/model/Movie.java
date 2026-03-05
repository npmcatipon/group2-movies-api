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
	private String cast;
	
	@Column ( nullable = false )
	private String director;
	
	@Column ( nullable = false ,
			  columnDefinition = "TIMESTAMP" )
	private Timestamp year;

}
