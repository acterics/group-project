package com.groupproject.ordering.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer code;
    private String title;
}
