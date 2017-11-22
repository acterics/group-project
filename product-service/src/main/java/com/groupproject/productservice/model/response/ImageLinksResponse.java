package com.groupproject.productservice.model.response;


import lombok.Data;

import java.util.List;

@Data
public class ImageLinksResponse {

    private List<OutputImage> images;
}
