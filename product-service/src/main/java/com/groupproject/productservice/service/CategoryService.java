package com.groupproject.productservice.service;

import com.groupproject.productservice.domain.Category;
import com.groupproject.productservice.mapper.CategoryResponseMapper;
import com.groupproject.productservice.model.response.CategoryResponse;
import com.groupproject.productservice.repository.CategoryRepository;
import com.groupproject.productservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryResponseMapper categoryResponseMapper;
    private final ItemRepository itemRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository,
                           ItemRepository itemRepository,
                           CategoryResponseMapper categoryResponseMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryResponseMapper = categoryResponseMapper;
        this.itemRepository = itemRepository;
    }

    public CategoryResponse getCategoryInfo(Long categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        Integer categoryItemCount = itemRepository.countByProductCategory(category);
        return categoryResponseMapper.map(category, categoryItemCount);
    }
}
