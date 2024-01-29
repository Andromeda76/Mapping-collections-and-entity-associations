package com.example.springdatawthboot.facade.techRep;

import com.example.springdatawthboot.entity.tech.Computer;
import org.junit.jupiter.api.Nested;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface ComputerIRepository extends JpaRepository<Computer, Long> {

    @Modifying
    @Transactional(propagation = Propagation.NESTED,
            rollbackFor = Exception.class)
    @Query(value = "update Computer p set " +
            "p.computerDetail = :detail where p.id = :id")
    void updateComputer(@Param("detail")String detail,
                        @Param("id")long id);
}
