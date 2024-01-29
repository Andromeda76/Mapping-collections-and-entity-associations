package com.example.springdatawthboot.entity.transport;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Travers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)
    @JoinTable(name = "ShipmentTravers",
        joinColumns =
                @JoinColumn(name = "TraversID"),
            inverseJoinColumns =
                    @JoinColumn(name = "ShipmentID",
                            nullable = false, unique = true))
    private List<Shipment> shipment;

    @Column(name = "TraverDetail", columnDefinition = "NVARCHAR(30)", nullable = true)
    private String traversDetail;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Shipment> getShipment() {
        return shipment;
    }

    public void setShipment(List<Shipment> shipment) {
        this.shipment = shipment;
    }

    public String getTraversDetail() {
        return traversDetail;
    }

    public void setTraversDetail(String traversDetail) {
        this.traversDetail = traversDetail;
    }

}
