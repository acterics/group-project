package com.groupproject.image.mapper;

import com.groupproject.image.model.ProxiedImage;
import com.groupproject.image.model.response.LinkResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class LinkResponseMapper {

    @Autowired
    LinkResponseMapper() {

    }

    public LinkResponse map(List<ProxiedImage> images) {

        return new LinkResponse(images);
    }
}
