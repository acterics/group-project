package com.groupproject.productservice.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;
    private Long propertyId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "propertyId", referencedColumnName = "id")
    private Property property;

}
