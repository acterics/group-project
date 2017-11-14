package com.groupproject.productservice.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PropertyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long propertyId;
    private Long itemId;
    private String value;

    @ManyToOne(optional = false)
    @JoinColumn(name = "itemId", referencedColumnName = "id")
    private Item item;

    @ManyToOne(optional = false)
    @JoinColumn(name = "propertyId", referencedColumnName = "id")
    private Property property;
}
