package com.groupproject.ordering.model.response;

import lombok.Data;

import java.util.List;

@Data
public class CartResponse {

    private List<CartEntry> items;
}
