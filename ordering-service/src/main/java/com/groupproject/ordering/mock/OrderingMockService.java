package com.groupproject.ordering.mock;

import com.groupproject.ordering.domain.Cart;
import com.groupproject.ordering.domain.ProductCart;
import com.groupproject.ordering.repository.CartRepository;
import com.groupproject.ordering.repository.ProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OrderingMockService {

    private final CartRepository cartRepository;
    private final ProductCartRepository productCartRepository;

    @Autowired
    public OrderingMockService(CartRepository cartRepository,
                               ProductCartRepository productCartRepository) {
        this.cartRepository = cartRepository;
        this.productCartRepository = productCartRepository;
    }

    @PostConstruct
    public void mockDatabase() {
        Cart cart = getNewPersistedCart(1L);
        for (long itemId = 1; itemId < 5; itemId++) {
            ProductCart productCart = getNewPersistedProductCart(cart, itemId, 1);
        }
    }

    public Cart getNewPersistedCart(Long userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);

        return cartRepository.save(cart);
    }

    public ProductCart getNewPersistedProductCart(Cart cart, Long itemId, Integer quantity) {
        ProductCart productCart = new ProductCart();
        productCart.setCart(cart);
        productCart.setItemId(itemId);
        productCart.setQuantity(quantity);
        return productCartRepository.save(productCart);
    }
}
