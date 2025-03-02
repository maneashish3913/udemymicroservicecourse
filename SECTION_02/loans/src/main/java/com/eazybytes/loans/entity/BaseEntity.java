package com.eazybytes.loans.entity;


import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@MappedSuperclass
@Data
@AllArgsConstructor
public class BaseEntity {
    private LocalDate CreatedAt;
    private String CreatedBy;
    private LocalDate UpdatedAt;
    private String UpdatedBy;

}
