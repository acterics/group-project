package com.groupproject.ordering.controller;

import com.groupproject.ordering.mapper.CartResponseMapper;
import com.groupproject.ordering.model.response.CartResponse;
import com.groupproject.ordering.service.CartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    private final CartResponseMapper cartResponseMapper;
    private final CartService cartService;

    public CartController(CartResponseMapper cartResponseMapper,
                          CartService cartService) {
        this.cartResponseMapper = cartResponseMapper;
        this.cartService = cartService;
    }

    //TODO get user info from JWT token
    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    public CartResponse getCart() {
        return cartResponseMapper.map(cartService.getCart(1L));
    }
}
