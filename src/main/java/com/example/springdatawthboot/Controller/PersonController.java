package com.example.springdatawthboot.Controller;


import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.example.springdatawthboot.config.Config;
import com.example.springdatawthboot.entity.totalIdentity.Contact;
import com.example.springdatawthboot.entity.totalIdentity.Person;
import com.example.springdatawthboot.entity.totalIdentity.PersonAddress;
import com.example.springdatawthboot.service.totalIdentity.ContactService;
import com.example.springdatawthboot.service.totalIdentity.PersonService;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.ByteArrayPropertyEditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.http.*;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/Person")
public class PersonController extends ByteArrayPropertyEditor {

    private final PersonService service;
    private final ContactService contactService;

    private final TaskScheduler taskScheduler;

    public PersonController(PersonService service,
                            ContactService contactService,
                           @Qualifier("taskScheduler") TaskScheduler taskScheduler){
        this.service = service;
        this.contactService = contactService;
        this.taskScheduler = taskScheduler;
    }


    @GetMapping(path = "/getALLByResponseEntity/{family}")
    public Object getAllPerson(@PathVariable("family")String family){
        HttpEntity<?> http =
                new HttpEntity<>(service.findByFamilyOrName(family, "").get(0).getFamily());

        ResponseEntity<?> responseEntity = new ResponseEntity<>(http, HttpStatus.OK);

        return responseEntity;
    }



    @GetMapping(path = "/serverRequest")
    @Scheduled(timeUnit = TimeUnit.HOURS, fixedDelay = 1)
    public Object getServerRequest() {
        List<Person> list = service.findByFamilyOrName("EmadKhatar", null);

//        Flux<ServerResponse> personFlux = Flux.fromIterable(list).flatMap(
//                x -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(Person.class));



        return list.get(0).getContacts();
    }


    //    @Bean
//    public Object savePerson() throws IOException {
//        Person person = new Person();
//        PersonAddress personAddress = new PersonAddress();
//        List<Contact> contacts = new ArrayList<>();
//        Contact contact = new Contact();
//        Map<byte[], String> map = new HashMap<>();
//        String parentDirectory = "D:\\Pictures\\Sapce\\Edited";
//        for (String directory : fileNames(parentDirectory)){
//            try(FileInputStream fileInputStream = new FileInputStream(parentDirectory + "\\" + directory)) {
//                map.put(fileInputStream.readAllBytes(), directory);
//            }
//        }
//
//        personAddress.setStreet("Foruzanfar");
//        personAddress.setZipCode("845652316");
//        person.setAddress(personAddress);
//        contact.setContactDetail("09301827194");
//        contacts.add(contact);
//        person.setName("EmadKhatar");
//        person.setImages(map);
//        contact.setPerson(person);
//        personAddress.setPerson(person);
//        person.setContacts(contacts);
//        Object o = service.insert(person);
//
//
//        return o;
//    }

    private List<String> fileNames(String fileDirectory){
        File file = new File(fileDirectory);
        List<String> list = new ArrayList<>();
        if (file.isFile()){
            list.add(file.getName());
            return list;
        }else {

            for (File file1 : Objects.requireNonNull(file.listFiles())) {
                list.add(file1.getName());
            }
        }
        return list;
    }

    @Override
    public void setAsText(String text) {
        super.setAsText(text);
    }


    @Override
    public String getAsText() {
        return super.getAsText();
    }

}
