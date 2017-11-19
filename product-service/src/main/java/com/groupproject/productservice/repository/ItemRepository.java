package com.groupproject.productservice.repository;

import com.groupproject.productservice.domain.Category;
import com.groupproject.productservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Integer countByProductCategory(Category category);
}
