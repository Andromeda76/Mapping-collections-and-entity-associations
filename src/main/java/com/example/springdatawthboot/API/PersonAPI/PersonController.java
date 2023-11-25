package com.example.springdatawthboot.API.PersonAPI;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

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
        Map<byte[], String> bytes = new HashMap<>();
        List<File> files = new ArrayList<>();
        files.add(new File("D:\\Pictures\\snip&sketch\\Capture.PNG"));
        files.add(new File("D:\\Pictures\\snip&sketch\\CaptureOne.PNG"));

        try {
            for (File file: files) {

                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    bytes.put(fileInputStream.readAllBytes(),
                            Arrays.asList(file.getName().split("\\.", 0)).get(1));
                }
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }
        person.setName("alloooooo");
        person.setImages(bytes);

        person = personService.insert(person);

        return person;
    }

}
