package com.groupproject.ordering.mapper;

import com.groupproject.ordering.domain.Cart;
import com.groupproject.ordering.domain.ProductCart;
import com.groupproject.ordering.model.response.CartEntry;
import com.groupproject.ordering.model.response.CartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartResponseMapper {

    private final CartEntryMapper cartEntryMapper;

    @Autowired
    public CartResponseMapper(CartEntryMapper cartEntryMapper) {
        this.cartEntryMapper = cartEntryMapper;
    }

    public CartResponse map(Cart cart) {
        CartResponse cartResponse = new CartResponse();
        List<CartEntry> cartEntries = new ArrayList<>();
        for (ProductCart productCart: cart.getContent()) {
            cartEntries.add(cartEntryMapper.map(productCart));
        }
        cartResponse.setItems(cartEntries);
        return cartResponse;

    }
}
