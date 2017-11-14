package com.groupproject.productservice.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PropertyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;

    @ManyToOne(optional = false)
    @JoinColumn(name = "propertyId")
    private Property property;
}
