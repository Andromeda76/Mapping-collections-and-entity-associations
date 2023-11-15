package com.example.springdatawthboot.service.totalIdentity;

import com.example.springdatawthboot.entity.totalIdentity.PersonAttribute;
import com.example.springdatawthboot.facade.totalIdentity.PersonAttributeIRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonAttributeService {

    private final PersonAttributeIRepository personAttributeRepository;

    public PersonAttributeService(@Qualifier("personAttributeIRepository")
                                  PersonAttributeIRepository personAttributeRepository){
        this.personAttributeRepository = personAttributeRepository;
    }

    public PersonAttribute saveAttribute(PersonAttribute personAttribute){
        return personAttributeRepository.save(personAttribute);
    }

    public PersonAttribute getImageById(Integer id){
        return personAttributeRepository.getById(id);
    }

}
