package com.example.springdatawthboot.service.tech;


import com.example.springdatawthboot.entity.tech.Computer;
import com.example.springdatawthboot.facade.techRep.ComputerIRepository;
import org.springframework.stereotype.Service;


@Service
public class ComputerService {


    private final ComputerIRepository repository;


    public ComputerService(ComputerIRepository repository){
        this.repository = repository;
    }


    public Computer saveComputer(Computer computer){
        return repository.save(computer);
    }

    public Computer updateComputer(Computer computer){
         repository.updateComputer(
                computer.getComputerDetail(), computer.getId());
        return repository.findById(computer.getId()).get();
    }

}
