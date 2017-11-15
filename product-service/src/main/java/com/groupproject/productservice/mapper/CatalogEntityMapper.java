package com.groupproject.productservice.mapper;


import com.groupproject.productservice.domain.Item;
import com.groupproject.productservice.domain.PropertyValue;
import com.groupproject.productservice.model.response.CatalogEntity;
import com.groupproject.productservice.model.response.PropertyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatalogEntityMapper {

    private final PropertyResponseMapper propertyResponseMapper;

    @Autowired
    public CatalogEntityMapper(PropertyResponseMapper propertyResponseMapper) {
        this.propertyResponseMapper = propertyResponseMapper;
    }

    public CatalogEntity map(Item item) {
        CatalogEntity catalogEntity = new CatalogEntity();
        catalogEntity.setAvailable(item.getQuantity() > 0);
        catalogEntity.setTitle(item.getProduct().getTitle());
        catalogEntity.setDescription(item.getProduct().getDescription());
        catalogEntity.setBrand(item.getProduct().getVendor().getName());
        catalogEntity.setPrice(item.getPrice());
        catalogEntity.setId(item.getId());

        List<PropertyResponse> properties = new ArrayList<>();
        for (PropertyValue propertyValue: item.getProperties()) {
            properties.add(propertyResponseMapper.map(propertyValue));
        }

        catalogEntity.setProperties(properties);

        return catalogEntity;
    }
}
