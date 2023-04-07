package com.matheusleite.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheusleite.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	// '?0' se refere ao primeiro parametro do metodo
	// 'i' é uma opção do MongoDB para ignorar maiusculas e minusculas
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") 
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
