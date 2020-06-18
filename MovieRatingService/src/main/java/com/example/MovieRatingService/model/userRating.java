package com.example.MovieRatingService.model;

import java.util.List;

public class userRating {

	private String userID;
	private String userName;
	List<movieRating> ratings;
	
	public userRating() {}
	
	public userRating(String userID, String userName, List<movieRating> ratings) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.ratings = ratings;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<movieRating> getRatings() {
		return ratings;
	}

	public void setRatings(List<movieRating> ratings) {
		this.ratings = ratings;
	}
	
	
	
}
