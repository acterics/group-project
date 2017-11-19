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

import static java.util.OptionalInt.of;

@RestController
public class ItemController {

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 10;

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(path = "/catalog", method = RequestMethod.GET)
    public @ResponseBody CatalogResponse getCatalog(@RequestParam(value = "page", required = false) Integer page,
                                                    @RequestParam(value = "size", required = false) Integer size) {
        Optional<Integer> pageArg = Optional.ofNullable(page);
        Optional<Integer> sizeArg = Optional.ofNullable(size);
        return itemService.getCatalogPage(pageArg.orElse(DEFAULT_PAGE), sizeArg.orElse(DEFAULT_PAGE_SIZE));
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public CatalogResponse getProducts(@RequestParam(value = "ids[]") Long[] ids) {
        return itemService.getCatalogByIds(ids);
    }

}
