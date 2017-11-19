package com.groupproject.ordering.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order orderModel;

    @ManyToOne
    @JoinColumn(name = "paymentMethodId")
    private PaymentMethod paymentMethod;

}
