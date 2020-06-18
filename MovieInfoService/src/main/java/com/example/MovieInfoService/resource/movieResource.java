package com.example.MovieInfoService.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieInfoService.model.Movie;

@RestController
public class movieResource {

	@RequestMapping("/movies/{movieId}")
	public Movie getMovieDetails(@PathVariable("movieId") String movieId) {
		System.out.println("MovieInfoSrevice: "+movieId);
		return new Movie(movieId, movieId+" movie name", movieId+" movie Desc");
	}
}
