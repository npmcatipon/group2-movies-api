package com.bpi.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.bpi.demo.model.Movie;
import com.bpi.demo.repository.MovieRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class MovieService {
	
	private final MovieRepository movieRepository;
	
	public MovieService (MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public Movie create(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public void deleteById(Long id) {
		if (!movieRepository.existsById(id)) {
			throw new IllegalArgumentException("Movie ID not found.");
		}
		
		movieRepository.deleteById(id);
	}
	
	public List<Movie> findById(Long id) {
		Movie movie = movieRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Movie ID not found."));
		return List.of(movie);
	}
	
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	public Movie updateById(Long id, Movie movie) {
		Movie updatedMovie = movieRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Movie ID not found."));
		
		updatedMovie.setTitle(movie.getTitle());
		updatedMovie.setDirector(movie.getDirector());
		updatedMovie.setCast(movie.getCast());
		updatedMovie.setYear(movie.getYear());
		
		return movieRepository.save(updatedMovie);
		
	}

}
