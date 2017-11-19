package com.groupproject.ordering.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class DeliveryType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
}
