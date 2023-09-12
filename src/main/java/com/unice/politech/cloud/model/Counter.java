package com.unice.politech.cloud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Counter {
    @Id @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String pageName;
    private Long total;
}
