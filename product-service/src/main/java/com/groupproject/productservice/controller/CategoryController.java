package com.groupproject.productservice.controller;

import com.groupproject.productservice.model.response.CategoryResponse;
import com.groupproject.productservice.service.CategoryService;
import com.groupproject.productservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(path = "/category/{categoryId}", method = RequestMethod.GET)
    @ResponseBody
    public CategoryResponse getCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.getCategoryInfo(categoryId);
    }



}
