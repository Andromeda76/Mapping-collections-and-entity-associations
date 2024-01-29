package com.example.springdatawthboot.entity.tech;

import jakarta.persistence.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

@Entity
@DynamicUpdate
@DynamicInsert
public class Computer {
    @Id
    @GeneratedValue(generator = "computer-seq-generator")
    @GenericGenerator(name = "computer-seq-generator",
            strategy = "enhanced-sequence",
            parameters = {
            @Parameter(
                    name = "sequence_name",
                    value = "Computer_seq"
            ),
            @Parameter(
                    name = "initial_value",
                    value = "1"
            ),
            @Parameter(
                    name = "increment_size",
                    value = "1"
            )})
    private Long id;


    @Column(name = "ComputerBrand", columnDefinition = "VARCHAR(50)", nullable = false)
    private String computerBrand;


    @Version
    @Column(name = "VERSION", columnDefinition = "BigInt", nullable = false)
    private long version;


    @Column(name = "ComputerDetail", columnDefinition = "NVARCHAR(100)", nullable = true)
    @OptimisticLock(excluded = true)
    private String computerDetail;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComputerBrand() {
        return computerBrand;
    }

    public void setComputerBrand(String computerBrand) {
        this.computerBrand = computerBrand;
    }

    public long getVersion() {
        return version;
    }

    public String getComputerDetail() {
        return computerDetail;
    }

    public void setComputerDetail(String computerDetail) {
        this.computerDetail = computerDetail;
    }

}
