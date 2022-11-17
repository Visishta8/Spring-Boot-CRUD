package com.vish.ratings_data_service.controller;

import java.util.Arrays;
import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vish.ratings_data_service.entity.RatingsData;
import com.vish.ratings_data_service.entity.UserRatings;
//import com.vish.ratings_data_service.entity.UserRatings;
import com.vish.ratings_data_service.service.RatingsService;

@ResponseBody
@RestController
public class RatingsController {
	
	@Autowired
	private final RatingsService ratingsService;

    public RatingsController(RatingsService ratingsService){
        this.ratingsService=ratingsService;
    }
    
    @PostMapping("/saveRatingsData")
    public ResponseEntity addRating(@RequestBody RatingsData ratingsData) {
        ratingsService.addRating(ratingsData);
        System.out.println("User "+ratingsData.getUserId()+" Created...");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/saveRatingsData")
    public ResponseEntity updateRating(@RequestBody RatingsData ratingsData) {
        ratingsService.updateRating(ratingsData);
        System.out.println("User "+ratingsData.getUserName()+" Updated...");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<RatingsData>> getAllRatings() {
        return ResponseEntity.ok(ratingsService.getAllRatings());
    }
    
    @GetMapping("/ratingsList/{userId}")
    public ResponseEntity<List<UserRatings>> getUserRatings(@PathVariable String userId) {
        return ResponseEntity.ok(ratingsService.getUserRatings(userId));
    }

    @GetMapping("/{name}")
    public ResponseEntity getRatingByName(@PathVariable String name) {
        return ResponseEntity.ok(ratingsService.getRatingByName(name));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteRating(@PathVariable String userId) {
        ratingsService.deleteRating(userId);
        System.out.println("Book "+userId+" Deleted...");
        return ResponseEntity.noContent().build();
    }

}
