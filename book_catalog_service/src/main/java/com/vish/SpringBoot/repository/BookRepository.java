package com.vish.SpringBoot.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vish.SpringBoot.entity.Book;

@Repository
public interface BookRepository extends MongoRepository<Book,Integer> {
	@Query("{'name': ?0}")
    Optional<Book> findByName(String name);

}
