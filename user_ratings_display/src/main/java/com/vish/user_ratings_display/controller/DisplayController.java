package com.vish.user_ratings_display.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vish.user_ratings_display.entity.Book;
import com.vish.user_ratings_display.entity.Display;
import com.vish.user_ratings_display.entity.RatingsData;
import com.vish.user_ratings_display.entity.UserRatings;

@ResponseBody
@RestController
public class DisplayController {
	
	/*@GetMapping("/{userName}")
	public List<Display> getDisplayByUserName(@RequestBody RatingsData ratingsData) {
		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<RatingsData> entity = new HttpEntity<RatingsData>(ratingsData,headers);
	      
	    List<UserRatings> ratings= restTemplate.exchange("http://localhost:8181/ratingsList", HttpMethod.GET, entity, List.class).getBody();
	    
	    return ratings.stream().map(rating -> {
	    	Book book=restTemplate.getForObject("http://localhost:9191/books/"+rating.getBookId(), Book.class);
	    	new Display(book.getName(),book.getPrice(),rating.getBookRating());
	    });
	}
	*/
	
	@GetMapping("/{userName}")
	public String getDisplayByUserName() {
		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
	      
	    String ratings= restTemplate.exchange("http://localhost:8181/ratings", HttpMethod.GET, entity, String.class).getBody();
	    String book= restTemplate.exchange("http://localhost:9191/books", HttpMethod.GET, entity, String.class).getBody();
	    
	    return ratings;
	}
	/*
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody RatingsData ratingsData) {
		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON));
	    Display obj = new Display();
	    Display.put("id", 1);
	    personJsonObject.put("name", "John");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
	      
	    return restTemplate.exchange("http://localhost:8181/saveRatingsData", HttpMethod.POST, entity, String.class).getBody();
	    
	    
	}
	*/

}
