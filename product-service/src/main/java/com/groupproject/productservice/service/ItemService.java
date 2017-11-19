package com.groupproject.productservice.service;


import com.groupproject.productservice.domain.Category;
import com.groupproject.productservice.domain.Item;
import com.groupproject.productservice.mapper.CatalogResponseMapper;
import com.groupproject.productservice.model.response.CatalogResponse;
import com.groupproject.productservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final CatalogResponseMapper catalogResponseMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository,
                       CatalogResponseMapper catalogResponseMapper) {
        this.itemRepository = itemRepository;
        this.catalogResponseMapper = catalogResponseMapper;
    }


    public CatalogResponse getCatalogPage(Integer page, Integer size) {
        PageRequest pageRequest = new PageRequest(page, size);
        return catalogResponseMapper.map(itemRepository.findAll(pageRequest).getContent());
    }

    public CatalogResponse getCatalogByIds(Long[] ids) {
        return catalogResponseMapper.map(itemRepository.findAll(Arrays.asList(ids)));
    }


}
