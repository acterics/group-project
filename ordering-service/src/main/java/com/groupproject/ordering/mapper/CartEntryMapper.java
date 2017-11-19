package com.groupproject.ordering.mapper;

import com.groupproject.ordering.domain.ProductCart;
import com.groupproject.ordering.model.response.CartEntry;
import org.springframework.stereotype.Component;

@Component
public class CartEntryMapper {

    public CartEntry map(ProductCart productCart) {
        CartEntry cartEntry = new CartEntry();
        cartEntry.setItemId(productCart.getItemId());
        cartEntry.setQuantity(productCart.getQuantity());
        return cartEntry;
    }
}
