package com.example.springdatawthboot.facade.tansport;

import com.example.springdatawthboot.entity.transport.Travers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraversIRepository extends JpaRepository<Travers, Long> {
}
