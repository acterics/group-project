package com.groupproject.ordering.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;
}
