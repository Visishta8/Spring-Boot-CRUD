package com.vish.ratings_data_service.entity;

//import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ratings_data")
@RedisHash("RatingsData")

public class RatingsData {
	
	@Id
	private String userId;
	@Field("User Name")
	private String userName;
	//private UserRatings ratings;
	@Field("Ratings List")
	private List<UserRatings> ratings;
	
	
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
	public List<UserRatings> getRatings() {
		return ratings;
	}
	public void setRatings(List<UserRatings> ratings) {
		this.ratings = ratings;
	}
	
	
}

