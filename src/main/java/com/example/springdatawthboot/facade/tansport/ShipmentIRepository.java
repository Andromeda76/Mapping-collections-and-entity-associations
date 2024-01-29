package com.example.springdatawthboot.facade.tansport;

import com.example.springdatawthboot.entity.transport.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentIRepository extends JpaRepository<Shipment, Long> {

}
