package com.example.springdatawthboot.service.mongo;


import com.example.springdatawthboot.entity.mongo.Movies;
import com.example.springdatawthboot.facade.mongo.MoviesIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;


@Service
@Transactional(readOnly = true)
public class MoviesService {

    private final MoviesIRepository repository;
    @Autowired
    public MoviesService(MoviesIRepository repository){
        this.repository = repository;
    }

    public Mono<Movies> getById(String id){
        return repository.findById(id);
    }

}
