package com.groupproject.ordering.service;

import com.groupproject.ordering.domain.Cart;
import com.groupproject.ordering.domain.ProductCart;
import com.groupproject.ordering.mapper.CartResponseMapper;
import com.groupproject.ordering.model.response.ActionResponse;
import com.groupproject.ordering.model.response.CartResponse;
import com.groupproject.ordering.repository.CartRepository;
import com.groupproject.ordering.repository.ProductCartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductCartRepository productCartRepository;
    private final CartResponseMapper cartResponseMapper;

    public CartService(CartRepository cartRepository,
                       ProductCartRepository productCartRepository,
                       CartResponseMapper cartResponseMapper) {
        this.cartRepository = cartRepository;
        this.productCartRepository = productCartRepository;
        this.cartResponseMapper = cartResponseMapper;
    }

    public CartResponse getCart(Long userId) {
        return cartResponseMapper.map(cartRepository.getByUserId(userId));
    }

    public ActionResponse addProductToCart(Long userId, Long productItemId) {
        Cart userCart = cartRepository.getByUserId(userId);

        ProductCart productCart =
                productCartRepository.getProductCartByItemIdAndCart(productItemId, userCart);
        if (productCart == null) {
            productCart = new ProductCart();
            productCart.setQuantity(0);
            productCart.setItemId(productItemId);
            productCart.setCart(userCart);
        }
        productCart.increaseQuantity();
        productCart = productCartRepository.save(productCart);
        ActionResponse response = new ActionResponse();
        if (productCart == null) {
            response.setSuccess(false);
            response.setMessage("Can't add product to cart");
        } else {
            response.setSuccess(true);
        }
        return response;
    }

    public ActionResponse deleteProductFromCart(Long userId, Long productItemId) {
        Cart userCart = cartRepository.getByUserId(userId);
        ActionResponse actionResponse = new ActionResponse();
        ProductCart productCart =
                productCartRepository.getProductCartByItemIdAndCart(productItemId, userCart);
        if (productCart == null) {
            actionResponse.setSuccess(false);
            actionResponse.setMessage("Item doesn't exist in user cart");
            return actionResponse;
        }
        if (productCart.getQuantity() == 0) {
            throw new IllegalStateException("Quantity can't be zero");
        }
        productCart.decreaseQuantity();
        if (productCart.getQuantity() == 0) {
            productCartRepository.delete(productCart);
        } else {
            productCartRepository.save(productCart);
        }
        ActionResponse response = new ActionResponse();
        response.setSuccess(true);
        return actionResponse;
    }
}
