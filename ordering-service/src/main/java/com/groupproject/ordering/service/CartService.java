package com.groupproject.ordering.service;

import com.groupproject.ordering.domain.Cart;
import com.groupproject.ordering.domain.ProductCart;
import com.groupproject.ordering.repository.CartRepository;
import com.groupproject.ordering.repository.ProductCartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductCartRepository productCartRepository;

    public CartService(CartRepository cartRepository,
                       ProductCartRepository productCartRepository) {
        this.cartRepository = cartRepository;
        this.productCartRepository = productCartRepository;
    }

    public Cart getCart(Long userId) {
        return cartRepository.getByUserId(userId);
    }

    public ProductCart addProductToCart(Long userId, Long productItemId) {
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
        return productCartRepository.save(productCart);
    }

    public ProductCart deleteProductFromCart(Long userId, Long productItemId) {
        Cart userCart = cartRepository.getByUserId(userId);
        ProductCart productCart =
                productCartRepository.getProductCartByItemIdAndCart(productItemId, userCart);
        if (productCart == null) {
            return null;
        }
        if (productCart.getQuantity() == 0) {
            return null;
        }
        productCart.decreaseQuantity();
        if (productCart.getQuantity() == 0) {
            productCartRepository.delete(productCart);
        } else {
            productCartRepository.save(productCart);
        }
        return productCart;
    }
}
