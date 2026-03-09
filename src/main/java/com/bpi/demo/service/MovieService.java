package com.bpi.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bpi.demo.model.Movie;
import com.bpi.demo.repository.MovieRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovieService {

	private final MovieRepository movieRepo;

	public MovieService(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}

	// ADD MOVIE
	public Movie addMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	// GET MOVIE
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

	public List<Movie> findById(Long id) {
		Movie movie = movieRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Movie ID not found."));
		return List.of(movie);
	}

	// UPDATE MOVIE
	public Movie updateMovie(Long id, Movie update) {
		Movie uMovie = movieRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Movie not found."));
		if (update.getTitle() != null) {
			uMovie.setTitle(update.getTitle());
		}
		if (update.getDirector() != null) {
			uMovie.setDirector(update.getDirector());
		}
		if (update.getCastMembers() != null) {
			uMovie.setCastMembers(update.getCastMembers());
		}
		if (update.getReleaseDate() != null) {
			uMovie.setReleaseDate(update.getReleaseDate());
		}
		return movieRepo.save(uMovie);
	}

	// DELETE MOVIE
	public void deleteMovie(Long id) {
		if (!movieRepo.existsById(id)) {
			throw new IllegalArgumentException("Movie ID not found.");
		}

		movieRepo.deleteById(id);
	}
}
