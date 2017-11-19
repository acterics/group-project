package com.groupproject.productservice.mapper;


import com.groupproject.productservice.domain.Item;
import com.groupproject.productservice.domain.PropertyValue;
import com.groupproject.productservice.model.response.CatalogEntry;
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

    public CatalogEntry map(Item item) {
        CatalogEntry catalogEntry = new CatalogEntry();
        catalogEntry.setAvailable(item.getQuantity() > 0);
        catalogEntry.setTitle(item.getProduct().getTitle());
        catalogEntry.setDescription(item.getProduct().getDescription());
        catalogEntry.setBrand(item.getProduct().getVendor().getName());
        catalogEntry.setPrice(item.getPrice());
        catalogEntry.setId(item.getId());
        catalogEntry.setCategory(item.getProduct().getCategory());
        catalogEntry.setPhotos(item.getPhotos());

        List<PropertyResponse> properties = new ArrayList<>();
        for (PropertyValue propertyValue: item.getProperties()) {
            properties.add(propertyResponseMapper.map(propertyValue));
        }

        catalogEntry.setProperties(properties);

        return catalogEntry;
    }
}
