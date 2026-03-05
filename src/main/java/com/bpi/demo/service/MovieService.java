package com.bpi.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bpi.demo.model.Movie;
import com.bpi.demo.repository.MovieRepository;


@Service
public class MovieService {

	private final MovieRepository movieRepo;
	
	public MovieService(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}
	
	//ADD MOVIE
	public Movie addMovie(Movie movie) {
		return movieRepo.save(movie);
	}
	
	//GET MOVIE
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}
	
	//UPDATE MOVIE
	
	//DELETE MOVIE
	public void deleteMovie(Long id) {
		movieRepo.deleteById(id);
	}
}
