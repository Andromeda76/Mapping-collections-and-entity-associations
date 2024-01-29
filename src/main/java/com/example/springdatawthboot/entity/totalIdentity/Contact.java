package com.example.springdatawthboot.entity.totalIdentity;


import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "ContactInfo")
public class Contact {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(name = "sequence-generator",
            strategy = "enhanced-sequence",
            parameters = {
            @Parameter(
                    name = "sequence_name",
                    value = "Person_seq"
            ),
             @Parameter(
                     name = "initial_value",
                     value = "4"
             ),
              @Parameter(
                      name = "increment_size",
                      value = "1"
              )})
    private Long id;


    @Column(name = "ContactDetail", columnDefinition = "NVARCHAR(255)")
    private String contactDetail;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PersonId", columnDefinition = "long",
//            insertable = false, unique = false, this means that we can not insert or update
            //data in Contact, we can just fetch data from it
            nullable = false)
    private Person person;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
