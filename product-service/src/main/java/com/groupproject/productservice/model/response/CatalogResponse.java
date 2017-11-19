package com.groupproject.productservice.model.response;

import lombok.Data;

import java.util.List;

@Data
public class CatalogResponse {
    private List<CatalogEntry> products;
}
