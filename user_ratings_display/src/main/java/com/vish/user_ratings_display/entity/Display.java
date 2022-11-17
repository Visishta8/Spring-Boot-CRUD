package com.vish.user_ratings_display.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Display {
	
	public Display() {
		// TODO Auto-generated constructor stub
	}
	@Field("Book Name")
	private String name;
	@Field("Book Price")
	private double price;
	@Field("User Rating")
	private float bookRating; 

}
