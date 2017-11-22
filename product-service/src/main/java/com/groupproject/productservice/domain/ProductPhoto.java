package com.groupproject.productservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class ProductPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filename;
    private Integer photoOrder;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productItemId")
    private Item productItem;

}
