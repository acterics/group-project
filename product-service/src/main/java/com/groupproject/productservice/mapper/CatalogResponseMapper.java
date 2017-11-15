package com.groupproject.productservice.mapper;


import com.groupproject.productservice.domain.Item;
import com.groupproject.productservice.model.response.CatalogEntity;
import com.groupproject.productservice.model.response.CatalogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatalogResponseMapper {

    private final CatalogEntityMapper catalogEntityMapper;

    @Autowired
    public CatalogResponseMapper(CatalogEntityMapper catalogEntityMapper) {
        this.catalogEntityMapper = catalogEntityMapper;
    }

    public CatalogResponse map(List<Item> items) {
        CatalogResponse catalog = new CatalogResponse();
        List<CatalogEntity> catalogEntities = new ArrayList<>();
        for (Item item: items) {
            catalogEntities.add(catalogEntityMapper.map(item));
        }
        catalog.setProducts(catalogEntities);
        return catalog;
    }
}
