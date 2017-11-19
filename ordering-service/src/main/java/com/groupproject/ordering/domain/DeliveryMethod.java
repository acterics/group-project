package com.groupproject.ordering.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class DeliveryMethod {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "deliveryTypeId")
    private DeliveryType type;
}
