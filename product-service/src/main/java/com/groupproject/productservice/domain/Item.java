package com.groupproject.productservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Float price;
    private Integer quantity;

    @OneToMany(mappedBy = "item")
    private List<PropertyValue> properties = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;



}