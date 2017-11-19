package com.groupproject.productservice.mapper;

import com.groupproject.productservice.domain.Category;
import com.groupproject.productservice.model.response.CatalogResponse;
import com.groupproject.productservice.model.response.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseMapper {
    public CategoryResponse map(Category category, Integer itemsCount) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setTitle(category.getTitle());
        categoryResponse.setName(category.getName());
        categoryResponse.setDescription(category.getDescription());
        categoryResponse.setItemCount(itemsCount);
        return categoryResponse;
    }
}
