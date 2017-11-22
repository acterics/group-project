package com.groupproject.productservice.repository;

import com.groupproject.productservice.domain.ProductPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<ProductPhoto, Long> {
}
