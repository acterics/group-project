package com.groupproject.productservice.controller;

import com.groupproject.productservice.domain.Item;
import com.groupproject.productservice.mapper.CatalogResponseMapper;
import com.groupproject.productservice.model.response.CatalogResponse;
import com.groupproject.productservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;
    private final CatalogResponseMapper catalogResponseMapper;

    @Autowired
    public ItemController(ItemService itemService,
                          CatalogResponseMapper catalogResponseMapper) {
        this.itemService = itemService;
        this.catalogResponseMapper = catalogResponseMapper;
    }

    @RequestMapping(path = "/catalog", method = RequestMethod.GET)
    public CatalogResponse getCatalog() {
        return catalogResponseMapper.map(itemService.getItems());
    }
}
