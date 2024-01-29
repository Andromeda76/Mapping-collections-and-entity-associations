package com.example.springdatawthboot.facade.mongo;

import com.example.springdatawthboot.entity.mongo.Movies;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MoviesIRepository extends ReactiveMongoRepository<Movies, String> {

//    Mono<Movies> findById(String id);

}
