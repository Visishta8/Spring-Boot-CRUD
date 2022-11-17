package com.vish.ratings_data_service.service;

//import java.util.Collection;
import java.util.List;
//import java.util.stream.Collectors;
import java.util.Optional;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.vish.ratings_data_service.entity.RatingsData;
import com.vish.ratings_data_service.entity.UserRatings;
//import com.vish.ratings_data_service.entity.UserRatings;
import com.vish.ratings_data_service.repository.RatingsRepository;

import lombok.val;
//import com.vish.ratings_data_service.repository.RatingsRepositoryImpl;

//import lombok.val;

@Service
public class RatingsService {
	@Autowired
    private RatingsRepository ratingsRepository;

    public RatingsService(RatingsRepository ratingsRepository){
        this.ratingsRepository=ratingsRepository;
    }
    
    
    public void addRating(RatingsData ratingsData){
        ratingsRepository.insert(ratingsData);
    }
	
	public void updateRating(@RequestBody RatingsData ratingsData) {
		RatingsData savedRatingsData = ratingsRepository.findByName(ratingsData.getUserName())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find User by Name %s", ratingsData.getUserName())));
		savedRatingsData.setUserName(ratingsData.getUserName());
		savedRatingsData.setRatings(ratingsData.getRatings());

        ratingsRepository.save(savedRatingsData);
	}
	
	public List<RatingsData> getAllRatings(){
        return ratingsRepository.findAll();
    }

	public List<UserRatings> getUserRatings(String userId) {
		List<UserRatings> user = ratingsRepository.findBy(userId);
        return user;
		/*ratingsRepository.findBy(userId).stream().map( ::getRatings).collect(Collectors.toList());*/
    } 
	
    public RatingsData getRatingByName(String userName){
        return ratingsRepository.findById(userName).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find User by Name %s", userName)));
    }

    public void deleteRating(String id){
        ratingsRepository.deleteById(id);
    }

}
