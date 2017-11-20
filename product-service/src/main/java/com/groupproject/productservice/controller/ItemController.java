package com.groupproject.productservice.controller;

import com.groupproject.productservice.configuration.ConstantConfiguration;
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

    private final ItemService itemService;
    private final Integer defaultPage;
    private final Integer defaultSize;


    @Autowired
    public ItemController(ItemService itemService,
                          ConstantConfiguration constantConfiguration) {
        this.itemService = itemService;
        this.defaultPage = constantConfiguration.getPage();
        this.defaultSize = constantConfiguration.getSize();
    }

    @RequestMapping(path = "/catalog", method = RequestMethod.GET)
    public @ResponseBody CatalogResponse getCatalog(@RequestParam(value = "page", required = false) Integer page,
                                                    @RequestParam(value = "size", required = false) Integer size) {
        Optional<Integer> pageArg = Optional.ofNullable(page);
        Optional<Integer> sizeArg = Optional.ofNullable(size);
        return itemService.getCatalogPage(pageArg.orElse(defaultPage), sizeArg.orElse(defaultSize));
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public CatalogResponse getProducts(@RequestParam(value = "ids[]") Long[] ids) {
        return itemService.getCatalogByIds(ids);
    }

}
