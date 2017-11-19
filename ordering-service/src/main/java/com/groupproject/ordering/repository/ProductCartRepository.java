package com.groupproject.ordering.repository;

import com.groupproject.ordering.domain.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
}
