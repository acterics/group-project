package com.groupproject.productservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private String title;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "vendorId")
    private Vendor vendor;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<ProductProperty> productProperties = new ArrayList<>();

}
