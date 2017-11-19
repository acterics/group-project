package com.groupproject.image.controller;

import com.groupproject.image.mapper.LinkResponseMapper;
import com.groupproject.image.model.request.LinkRequest;
import com.groupproject.image.model.response.LinkResponse;
import com.groupproject.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinksController {

    private final ImageService imageService;
    private final LinkResponseMapper linkResponseMapper;

    @Autowired
    public LinksController(ImageService imageService,
                           LinkResponseMapper linkResponseMapper) {
        this.imageService = imageService;
        this.linkResponseMapper = linkResponseMapper;
    }

    @RequestMapping(path = "/links", method = RequestMethod.POST)
    public @ResponseBody
    LinkResponse getLinks(@RequestBody LinkRequest linksRequest) {
        return linkResponseMapper.map(imageService.getItems(linksRequest.getImages()));
    }
}
