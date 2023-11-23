package com.example.springdatawthboot.facade.totalIdentity;


import com.example.springdatawthboot.entity.totalIdentity.PersonAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface PersonAttributeIRepository extends JpaRepository<PersonAttribute, Long> {

    PersonAttribute getById(Integer id);

}
