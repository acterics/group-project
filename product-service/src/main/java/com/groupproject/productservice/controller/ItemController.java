package com.groupproject.productservice.controller;

import com.groupproject.productservice.domain.Item;
import com.groupproject.productservice.mapper.CatalogResponseMapper;
import com.groupproject.productservice.model.response.CatalogResponse;
import com.groupproject.productservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(path = "/catalog", params = {"page", "size"}, method = RequestMethod.GET)
    public
    @ResponseBody CatalogResponse getCatalog(@RequestParam(name = "page", required = false, defaultValue = "0")
                                                         Integer page,
                                             @RequestParam(name = "size", required = false, defaultValue = "10")
                                                     Integer size) {
        PageRequest pageRequest = new PageRequest(page, size);
        return catalogResponseMapper.map(itemService.getItems(pageRequest));
    }
}
