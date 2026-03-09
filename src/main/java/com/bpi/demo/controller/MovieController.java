package com.bpi.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bpi.demo.MoviesApiApplication;
import com.bpi.demo.model.Movie;
import com.bpi.demo.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	private final MovieService movieService;
	
	public MovieController (MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAll(@RequestParam( required = false ) Long id) {
		return ResponseEntity.ok(id == null ? movieService.findAll() : movieService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(movie));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
		movieService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie) {
		return ResponseEntity.ok(movieService.updateById(id, movie));
	}
	
	
}
