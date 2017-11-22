package com.groupproject.productservice.model.request;

import lombok.Data;

import java.util.List;

@Data
public class ImageLinksRequest {

    private List<InputImage> images;
}
