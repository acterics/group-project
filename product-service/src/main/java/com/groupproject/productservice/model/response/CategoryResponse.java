package com.groupproject.productservice.model.response;

import lombok.Data;

@Data
public class CategoryResponse {

    private Integer itemCount;
    private Long id;
    private String name;
    private String title;
    private String description;
}
