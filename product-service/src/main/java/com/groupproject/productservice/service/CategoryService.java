package com.groupproject.productservice.service;

import com.groupproject.productservice.component.CatalogResponseProxy;
import com.groupproject.productservice.domain.Category;
import com.groupproject.productservice.mapper.CatalogResponseMapper;
import com.groupproject.productservice.mapper.CategoryResponseMapper;
import com.groupproject.productservice.model.response.CatalogResponse;
import com.groupproject.productservice.model.response.CategoryResponse;
import com.groupproject.productservice.repository.CategoryRepository;
import com.groupproject.productservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryResponseMapper categoryResponseMapper;
    private final CatalogResponseMapper catalogResponseMapper;
    private final CatalogResponseProxy catalogResponseProxy;
    private final ItemRepository itemRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository,
                           ItemRepository itemRepository,
                           CategoryResponseMapper categoryResponseMapper,
                           CatalogResponseMapper catalogResponseMapper,
                           CatalogResponseProxy catalogResponseProxy) {
        this.categoryRepository = categoryRepository;
        this.categoryResponseMapper = categoryResponseMapper;
        this.itemRepository = itemRepository;
        this.catalogResponseMapper = catalogResponseMapper;
        this.catalogResponseProxy = catalogResponseProxy;
    }

    public CategoryResponse getCategoryInfo(Long categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        Integer categoryItemCount = itemRepository.countByProductCategoryId(categoryId);
        return categoryResponseMapper.map(category, categoryItemCount);
    }

    public CatalogResponse getCategoryProducts(Long categoryId, Integer page, Integer size) {
        PageRequest pageRequest = new PageRequest(page, size);
        return catalogResponseProxy.proxy(
                catalogResponseMapper.map(
                        itemRepository.getByProductCategoryId(pageRequest, categoryId).getContent()
                )
        );
    }
}
