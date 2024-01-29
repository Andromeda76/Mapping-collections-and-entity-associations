package com.example.springdatawthboot.entity.totalIdentity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "PersonAddress")
public class PersonAddress {

    @Id
    @GenericGenerator(
            name = "personAddressPrimaryKeyGenerator",
            strategy = "foreign",
            parameters =
                    @Parameter(
                            name = "property", value = "person"
                    )
    )
    @GeneratedValue(generator = "personAddressPrimaryKeyGenerator")
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
//    @JoinTable(
//            name = "ITEM_SHIPMENT",
//            joinColumns =
//            @JoinColumn(name = "SHIPMENT_ID"),
//            inverseJoinColumns =
//            @JoinColumn(name = "ITEM_ID",
//                    nullable = false,
//                    unique = true)
//    )
    private Person person;

    @Column(name = "Street", columnDefinition = "NVARCHAR(50)", nullable = true)
    private String street;

    @Column(name = "ZipCode", columnDefinition = "NVARCHAR(50)", nullable = true)
    private String zipCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
