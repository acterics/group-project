package com.groupproject.productservice.domain;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer price;
    private Integer quantity;

    @OneToMany(mappedBy = "item")
    private List<PropertyValue> properties = new ArrayList<>();

    @OneToMany(mappedBy = "productItem")
    private List<ProductPhoto> photos = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;



}
