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

    private final ItemService itemService;
    private final CatalogResponseMapper catalogResponseMapper;

    @Autowired
    public ItemController(ItemService itemService,
                          CatalogResponseMapper catalogResponseMapper) {
        this.itemService = itemService;
        this.catalogResponseMapper = catalogResponseMapper;
    }

    @RequestMapping(path = "/catalog", method = RequestMethod.GET)
    public @ResponseBody CatalogResponse getCatalog(@RequestParam(value = "page", required = false)
                                                                Integer page,
                                                    @RequestParam(value = "size", required = false)
                                                            Integer size,
                                                    @RequestParam(value = "ids[]", required = false)
                                                            Long[] ids) {
        List<Item> items;
        if (ids != null) {
            items = itemService.getItems(ids);
        } else {
            Optional<Integer> pageArg = Optional.ofNullable(page);
            Optional<Integer> sizeArg = Optional.ofNullable(size);
            PageRequest pageRequest = new PageRequest(pageArg.orElse(0), sizeArg.orElse(10));
            items = itemService.getItems(pageRequest);
        }

        return catalogResponseMapper.map(items);
    }
}
