package com.example.springdatawthboot.service.travers;

import com.example.springdatawthboot.entity.transport.Shipment;
import com.example.springdatawthboot.entity.transport.Travers;
import com.example.springdatawthboot.facade.tansport.ShipmentIRepository;
import com.example.springdatawthboot.facade.tansport.TraversIRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentIRepository repository;

    private final TraversIRepository traversRepository;

    public ShipmentService(ShipmentIRepository repository,
                           TraversIRepository traversIRepository){
        this.repository = repository;
        this.traversRepository = traversIRepository;
    }


    public Object saveShipment(Shipment shipment, Travers travers){
        List<Object> list = new ArrayList<>();
        if (travers != null) {
            list.add(traversRepository.save(travers));
        }
        if (shipment != null) {
            list.add(repository.save(shipment));
        }
        return list;
    }


}
