package com.groupproject.ordering.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long itemId;
    private Integer quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
}
