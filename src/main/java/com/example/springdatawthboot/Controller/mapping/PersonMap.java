package com.example.springdatawthboot.Controller.mapping;


import com.example.springdatawthboot.entity.totalIdentity.Person;
import com.example.springdatawthboot.entity.totalIdentity.PersonAddress;
import com.example.springdatawthboot.service.totalIdentity.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/PersonMap")
public class PersonMap {

    private final PersonService service;


    public PersonMap(PersonService service){
        this.service = service;
    }

    @Bean
    public void testOneToOne(){
        Person person = new Person();
        PersonAddress personAddress = new PersonAddress();
        personAddress.setZipCode("745621");
        personAddress.setStreet("foruzanfar");
        personAddress.setPerson(person);
        person.setAddress(personAddress);
        person.setName("ali");

         service.insert(person);

    }

}
