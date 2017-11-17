package com.groupproject.productservice.service;


import com.groupproject.productservice.domain.Item;
import com.groupproject.productservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public List<Item> getItems(Pageable pageable) {
        return itemRepository.findAll(pageable).getContent();
    }
}
