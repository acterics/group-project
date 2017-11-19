package com.groupproject.ordering.repository;

import com.groupproject.ordering.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart getByUserId(Long userId);
}
