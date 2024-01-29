package com.example.springdatawthboot.service.totalIdentity;


import com.example.springdatawthboot.entity.totalIdentity.Contact;
import com.example.springdatawthboot.facade.totalIdentity.ContactIRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {


    private final ContactIRepository repository;

    public ContactService(ContactIRepository repository){
        this.repository = repository;
    }

    public Contact saveContact(Contact contact){
        return repository.save(contact);
    }

}
