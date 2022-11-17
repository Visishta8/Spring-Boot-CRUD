package com.vish.user_ratings_display.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserRatings {
	
	@Id
	private int bookId;
	@Field("Book Rating")
	private float bookRating;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public float getBookRating() {
		return bookRating;
	}
	public void setBookRating(float bookRating) {
		this.bookRating = bookRating;
	}
	
}
