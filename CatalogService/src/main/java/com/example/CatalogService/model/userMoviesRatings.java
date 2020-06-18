package com.example.CatalogService.model;

public class userMoviesRatings {

	private String movieId;
	private String movieName;
	private String movieDesc;
	private int movieRating;
	public userMoviesRatings(String movieId, String movieName, String movieDesc, int movieRating) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDesc = movieDesc;
		this.movieRating = movieRating;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDesc() {
		return movieDesc;
	}
	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}
	public int getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}
	
	
}
