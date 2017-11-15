package com.groupproject.productservice.model.response;

import lombok.Data;

import java.util.List;

@Data
public class CatalogEntity {

    private Long id;
    private Boolean available;
    private String brand;
    private String title;
    private String description;
    private Float price;
    private List<PropertyResponse> properties;

}
