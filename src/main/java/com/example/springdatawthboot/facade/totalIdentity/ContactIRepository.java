package com.example.springdatawthboot.facade.totalIdentity;

import com.example.springdatawthboot.entity.totalIdentity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactIRepository extends JpaRepository<Contact, Long> {

}
