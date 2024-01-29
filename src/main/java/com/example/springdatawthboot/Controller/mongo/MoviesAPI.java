package com.example.springdatawthboot.Controller.mongo;

import com.example.springdatawthboot.service.mongo.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Movies")
public class MoviesAPI {

    @Autowired
    private MoviesService service;


    @GetMapping(path = "/{id}")
    public Object getMovies(@PathVariable("id")String id){
        return service.getById(id);
    }
}
