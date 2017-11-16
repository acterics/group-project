package com.groupproject.productservice.model.response;

import com.groupproject.productservice.domain.Category;
import com.groupproject.productservice.domain.Photo;
import lombok.Data;

import java.util.List;

@Data
public class CatalogEntity {

    private Long id;
    private Boolean available;
    private String brand;
    private String title;
    private String description;
    private Category category;
    private Float price;
    private List<PropertyResponse> properties;
    private List<Photo> photos;

}
