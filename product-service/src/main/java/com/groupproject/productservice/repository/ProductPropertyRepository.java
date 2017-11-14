package com.groupproject.productservice.repository;

import com.groupproject.productservice.domain.ProductProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPropertyRepository extends JpaRepository<ProductProperty, Long> {
}
