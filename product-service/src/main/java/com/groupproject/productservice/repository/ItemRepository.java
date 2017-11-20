package com.groupproject.productservice.repository;

import com.groupproject.productservice.domain.Category;
import com.groupproject.productservice.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Integer countByProductCategoryId(Long categoryId);
    Page<Item> getByProductCategoryId(Pageable pageable, Long categoryId);
}
