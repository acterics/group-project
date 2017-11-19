package com.groupproject.ordering.service;

import com.groupproject.ordering.domain.Cart;
import com.groupproject.ordering.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart getCart(Long userId) {
        return cartRepository.getByUserId(userId);
    }
}
