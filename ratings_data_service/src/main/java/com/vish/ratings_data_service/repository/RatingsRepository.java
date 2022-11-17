package com.vish.ratings_data_service.repository;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vish.ratings_data_service.entity.RatingsData;
import com.vish.ratings_data_service.entity.UserRatings;


@Repository
public interface RatingsRepository extends MongoRepository<RatingsData,String>{

	@Autowired
	public MongoTemplate mongoTemplate = null;
	
	@Query("{'User Name': ?0}")
	Optional<RatingsData> findByName(String name);
	
	@Query("{'User Id': ?0}")
	Optional<RatingsData> findById(int userId);
	
	/*@Query(value="{'User Name': ?0}",fields="{'ratings': 0}")
	List<UserRatings> findBy(String name);
	*/
	@Query(value="{'User Id': ?0}", fields="{'Ratings List': 1}")
	List<UserRatings> findBy(String userId);
	
	
	/*public default List<RatingsData> findRatingsListByUserName(String userName) {
        Query query = new Query(Criteria.where("User Name").is(userName));
        query.fields().include("Ratings List");
        return mongoTemplate.find(query, RatingsData.class);
    }*/
	
}
