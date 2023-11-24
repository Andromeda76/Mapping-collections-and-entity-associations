package com.example.springdatawthboot.API.PersonAPI;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.springdatawthboot.entity.totalIdentity.Person;
import com.example.springdatawthboot.service.totalIdentity.PersonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(@Qualifier("personService")
                            PersonService personService){
        this.personService = personService;
    }

    public Object getPersonByAtt(Integer id){
        return personService.getByAttributes(id);
    }

    public List<Person> getAll(){
        return personService.people();
    }

    public Person saveWithAttribute(){
        Person person = new Person();
        List<byte[]> bytes = new ArrayList<>();
        List<File> files = new ArrayList<>();
        files.add(new File("D:\\Pictures\\snip&sketch\\Capture.PNG"));
        files.add(new File("D:\\Pictures\\snip&sketch\\CaptureOne.PNG"));

        try {
            for (File file: files) {

                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    bytes.add(fileInputStream.readAllBytes());
                }
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }
        person.setName("wazsxedcrfvtgybhunjmik");
        person.setImages(bytes);

        person = personService.insert(person);

        return person;
    }

}
