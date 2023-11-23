package com.example.springdatawthboot.entity.totalIdentity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.engine.jdbc.BlobImplementer;
import org.hibernate.type.descriptor.java.BlobJavaType;
import org.hibernate.type.descriptor.jdbc.VarbinaryJdbcType;

import java.io.Serializable;
import java.sql.Blob;


@Entity
@Table(name = "PersonAttribute")
public class PersonAttribute {
    @Id
//    @GenericGenerator(name = "personAttribute_generator",
//            strategy = "enhanced-sequence",
//        parameters = {
//            @Parameter(
//                    name = "sequence_name",
//                    value = "PersonAttribute_seq"
//            ),
//            @Parameter(
//                    name = "initial_value",
//                    value = "1"
//            ),
//            @Parameter(
//                    name = "increment_size",
//                    value = "6"
//            )})
//    @GeneratedValue(generator = "personAttribute_generator")
    private Long id;

    @Column(name = "Image", columnDefinition = "varbinary(max)")
    private byte[] image;

    @Column(name = "PersonId", columnDefinition = "bigint")
    private Long personId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

}
