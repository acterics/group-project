package com.groupproject.productservice.service;


import com.groupproject.productservice.component.CatalogResponseProxy;
import com.groupproject.productservice.mapper.CatalogResponseMapper;
import com.groupproject.productservice.model.response.CatalogResponse;
import com.groupproject.productservice.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final CatalogResponseMapper catalogResponseMapper;
    private final CatalogResponseProxy catalogResponseProxy;

    @Autowired
    public ItemService(ItemRepository itemRepository,
                       CatalogResponseMapper catalogResponseMapper,
                       CatalogResponseProxy catalogResponseProxy) {
        this.itemRepository = itemRepository;
        this.catalogResponseMapper = catalogResponseMapper;
        this.catalogResponseProxy = catalogResponseProxy;
    }

    public CatalogResponse getCatalogPage(Integer page, Integer size, Integer width, Integer height) {

        PageRequest pageRequest = new PageRequest(page, size);
        return catalogResponseProxy.proxy(
                catalogResponseMapper.map(
                        itemRepository.findAll(pageRequest).getContent()
                )
        );

    }

    public CatalogResponse getCatalogByIds(Long[] ids) {
        return catalogResponseProxy.proxy(
                catalogResponseMapper.map(
                        itemRepository.findAll(Arrays.asList(ids))
                )
        );
    }


}
