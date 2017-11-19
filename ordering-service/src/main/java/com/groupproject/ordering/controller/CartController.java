package com.groupproject.ordering.controller;

import com.groupproject.ordering.domain.ProductCart;
import com.groupproject.ordering.mapper.CartResponseMapper;
import com.groupproject.ordering.model.request.ChangeCartProductsRequest;
import com.groupproject.ordering.model.response.ActionResponse;
import com.groupproject.ordering.model.response.CartResponse;
import com.groupproject.ordering.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //TODO get user info from JWT token
    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    @ResponseBody
    public CartResponse getCart() {
        return cartService.getCart(1L);
    }

    //TODO get user info from JWT token
    @RequestMapping(path = "/cart", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ActionResponse addProductToCart(@RequestBody ChangeCartProductsRequest request) {
        return cartService.addProductToCart(1L, request.getProductItemId());
    }


    //TODO get user info from JWT token
    @RequestMapping(path = "/cart", method = RequestMethod.DELETE, consumes = "application/json")
    @ResponseBody
    public ActionResponse deleteProductFromCart(@RequestBody ChangeCartProductsRequest request) {
        return cartService.deleteProductFromCart(1L, request.getProductItemId());
    }
}
