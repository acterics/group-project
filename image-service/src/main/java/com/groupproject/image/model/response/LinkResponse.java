package com.groupproject.image.model.response;

import com.groupproject.image.model.ProxiedImage;
import lombok.Data;

import java.util.List;

@Data
public class LinkResponse {

    private List<ProxiedImage> images;

    public LinkResponse(List<ProxiedImage> proxiedImages) {
        this.images = proxiedImages;
    }

}
