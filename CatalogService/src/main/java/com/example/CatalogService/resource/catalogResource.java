package com.example.CatalogService.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.CatalogService.model.catalogItem;
import com.example.CatalogService.model.movieInfo;
import com.example.CatalogService.model.movieRating;
import com.example.CatalogService.model.userMoviesRatings;
import com.example.CatalogService.model.userRating;

@RestController
public class catalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/catalog/{userId}")
	public catalogItem getCatalog(@PathVariable("userId") String userId) {
		
		//userRating userRatings = restTemplate.getForObject("http://localhost:8083/ratings/"+userId, userRating.class);
		//userRating userRatings = restTemplate.getForObject("http://movie-rating-service/ratings/"+userId, userRating.class);
		//System.out.println(userRatings.toString());
		
		userRating userRatings = webClientBuilder.build()
												.get()
												.uri("http://movie-rating-service/ratings/"+userId)
												.retrieve()
												.bodyToMono(userRating.class)
												.block();
		
		catalogItem catalogUserItem = new catalogItem();
		catalogUserItem.setUserId(userId);
		catalogUserItem.setUserName(userRatings.getUserName());
		List<movieRating> movieRatings = userRatings.getRatings();
		
		List<userMoviesRatings> userMoviesRatingsList = movieRatings.stream().map(
				rating -> {
					//movieInfo movieInfos = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), movieInfo.class);
					//movieInfo movieInfos = restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), movieInfo.class);
					movieInfo movieInfos = webClientBuilder.build()
														.get()
														.uri("http://movie-info-service/movies/"+rating.getMovieId())
														.retrieve()
														.bodyToMono(movieInfo.class)
														.block();
					return new userMoviesRatings(movieInfos.getMovieId(), movieInfos.getMovieName(), movieInfos.getMovieDesc(), rating.getRating());
				}
				).collect(Collectors.toList());
		catalogUserItem.setUserMoviesRatings(userMoviesRatingsList);
		return catalogUserItem;
		
//		List<userMoviesRatings> ratings = Arrays.asList(
//				new userMoviesRatings("movie1", "Test Name", "Test Desc", 4),
//				new userMoviesRatings("movie2", "Test Name", "Test Desc", 3));
//		
//		return new catalogItem(userId, "userName", ratings);
		
		
		
	}
}
