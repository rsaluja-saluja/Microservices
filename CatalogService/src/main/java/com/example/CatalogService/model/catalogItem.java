package com.example.CatalogService.model;

import java.util.List;

public class catalogItem {

	private String userId;
	private String userName;
	List<userMoviesRatings> userMoviesRatings;
	
	public catalogItem() {}
	
	public catalogItem(String userId, String userName,
			List<com.example.CatalogService.model.userMoviesRatings> userMoviesRatings) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMoviesRatings = userMoviesRatings;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<userMoviesRatings> getUserMoviesRatings() {
		return userMoviesRatings;
	}
	public void setUserMoviesRatings(List<userMoviesRatings> userMoviesRatings) {
		this.userMoviesRatings = userMoviesRatings;
	}
	
	
}
