package com.bpi.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bpi.demo.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	private final MovieService movieService;
	
	public MovieController (MovieService movieService) {
		this.movieService = movieService;
	}
	
	
}
