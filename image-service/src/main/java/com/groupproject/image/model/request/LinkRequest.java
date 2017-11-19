package com.groupproject.image.model.request;

import com.groupproject.image.model.Image;
import lombok.Data;

import java.util.List;

@Data
public class LinkRequest {

    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }
}
