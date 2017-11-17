package com.groupproject.productservice.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String propertyType;
    private String title;
    private String name;
}
