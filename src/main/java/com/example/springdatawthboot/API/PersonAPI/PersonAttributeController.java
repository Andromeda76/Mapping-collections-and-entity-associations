package com.example.springdatawthboot.API.PersonAPI;

import com.example.springdatawthboot.entity.totalIdentity.PersonAttribute;
import com.example.springdatawthboot.service.totalIdentity.PersonAttributeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class PersonAttributeController {

    private final PersonAttributeService personAttributeService;

    public PersonAttributeController(@Qualifier("personAttributeService")
                            PersonAttributeService personAttributeService) {
        this.personAttributeService = personAttributeService;
    }



    public Object personAttributeController(){
        FileInputStream fileInputStream;
        PersonAttribute personAttribute = new PersonAttribute();
        File file = new File("D:\\Pictures\\snip&sketch\\Capture.PNG");

        try {
            fileInputStream = new FileInputStream(file);
            personAttribute.setImage(fileInputStream.readAllBytes());
            fileInputStream.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        personAttribute.setPersonId(80l);
        personAttribute = personAttributeService.saveAttribute(personAttribute);

        personAttribute = personAttributeService.getImageById(1);

        try (FileOutputStream fileOutputStream = new FileOutputStream("D:\\Free.Viewer.2.0.1.0\\ali.mp4")){
            fileOutputStream.write(personAttribute.getImage());
            fileOutputStream.flush();

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        return personAttribute;
    }
}
