package com.groupproject.productservice.repository;


import com.groupproject.productservice.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
