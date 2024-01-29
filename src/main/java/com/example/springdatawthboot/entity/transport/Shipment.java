package com.example.springdatawthboot.entity.transport;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Detail", columnDefinition = "NVARCHAR(20)", nullable = true)
    private String detail;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                mappedBy = "shipment")
    private List<Travers> travers;


    public List<Travers> getTravers() {
        return travers;
    }

    public void setTravers(List<Travers> travers) {
        this.travers = travers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
