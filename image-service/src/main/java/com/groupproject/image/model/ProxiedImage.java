package com.groupproject.image.model;

import lombok.Data;

@Data
public class ProxiedImage {

    private String url;

    public ProxiedImage(String url) {
        this.url = url;
    }
}
