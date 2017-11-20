package com.groupproject.productservice.controller;

import com.groupproject.productservice.configuration.ConstantConfiguration;
import com.groupproject.productservice.model.response.CatalogResponse;
import com.groupproject.productservice.model.response.CategoryResponse;
import com.groupproject.productservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CategoryController {

    private final CategoryService categoryService;
    private final Integer defaultPage;
    private final Integer defaultSize;

    @Autowired
    public CategoryController(CategoryService categoryService,
                              ConstantConfiguration constantConfiguration) {
        this.categoryService = categoryService;
        this.defaultPage = constantConfiguration.getPage();
        this.defaultSize = constantConfiguration.getSize();
    }

    @RequestMapping(path = "/category/{categoryId}", method = RequestMethod.GET)
    @ResponseBody
    public CategoryResponse getCategory(@PathVariable("categoryId") Long categoryId) {
        return categoryService.getCategoryInfo(categoryId);
    }

    @RequestMapping(path = "/category/{categoryId}/list", method = RequestMethod.GET)
    @ResponseBody
    public CatalogResponse getCategoryProducts(@PathVariable("categoryId") Long categoryId,
                                               @RequestParam(value = "page", required = false) Integer page,
                                               @RequestParam(value = "size", required = false) Integer size) {
        Optional<Integer> pageArg = Optional.ofNullable(page);
        Optional<Integer> sizeArg = Optional.ofNullable(size);
        return categoryService.getCategoryProducts(categoryId,
                pageArg.orElse(defaultPage),
                sizeArg.orElse(defaultSize));

    }


}
