package com.groupproject.ordering.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_model")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    @OneToOne
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "deliveryId")
    private DeliveryMethod deliveryMethod;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private OrderStatus status;
}
