package com.bpi.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bpi.demo.model.*;

import com.bpi.demo.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	private final MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping
	public List<Movie> getMovies(@RequestParam(required = false) String movie){
		return movieService.getAllMovies();
	}
	
	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return movieService.addMovie(movie);
	}
	
	@PutMapping("/{id}")
	public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie){
		return movieService.updateMovie(id, movie);
	}
	
	@DeleteMapping("/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return "Movie Succesfully deleted";
	}
	
}
