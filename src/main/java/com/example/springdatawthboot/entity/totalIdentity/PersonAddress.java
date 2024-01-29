package com.example.springdatawthboot.entity.totalIdentity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "PersonAddress")
public class PersonAddress {

    @Id
    @GenericGenerator(name = "personAddressPrimaryKeyGenerator",
            strategy = "enhanced-sequence",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_name",
                            value = "PersonAddress_seq"
                    ),
                    @org.hibernate.annotations.Parameter(
                            name = "initial_value",
                            value = "1"
                    ),
                    @org.hibernate.annotations.Parameter(
                            name = "increment_size",
                            value = "1"
                    )
                    /**
                     * we've also set an initial value for the sequence, which means
                     * the primary key generation will start at 4.
                     */
            })
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
