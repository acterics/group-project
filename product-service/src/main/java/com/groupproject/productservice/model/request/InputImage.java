package com.groupproject.productservice.model.request;

import lombok.Data;

@Data
public class InputImage {
    private String url;
    private Integer width;
    private Integer height;
    private String resizingType = "fit";
    private String gravity = "ce";
    private String extension = "webp";
    private Integer enlarge = 0;
}
