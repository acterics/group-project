package com.groupproject.ordering.model.response;

import lombok.Data;

@Data
public class CartEntry {

    private Long itemId;
    private Integer quantity;
}
