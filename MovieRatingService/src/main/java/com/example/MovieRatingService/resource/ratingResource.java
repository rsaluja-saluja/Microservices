package com.example.MovieRatingService.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieRatingService.model.movieRating;
import com.example.MovieRatingService.model.userRating;

@RestController
public class ratingResource {

	@RequestMapping("/ratings/{userId}")
	public userRating getUserRatings(@PathVariable("userId") String userId) {
		List<movieRating> ratings = Arrays.asList(
				new movieRating("movie1",4),
				new movieRating("movie2",3),
				new movieRating("movie3",5));
		return new userRating(userId, userId+" User Name", ratings);
	}
}
