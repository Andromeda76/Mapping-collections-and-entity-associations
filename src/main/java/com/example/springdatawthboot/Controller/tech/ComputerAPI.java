package com.example.springdatawthboot.Controller.tech;


import com.example.springdatawthboot.entity.tech.Computer;
import com.example.springdatawthboot.service.tech.ComputerService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputerAPI {


    private final ComputerService service;

    public ComputerAPI(ComputerService service){
        this.service = service;
    }

    @Bean
    public Object saveComputerAPI(){
        Computer computer = new Computer();
        computer.setId(1l);
        computer.setComputerBrand("Apple");
        computer.setComputerDetail("BAD");

        return service.updateComputer(computer);
    }


}
