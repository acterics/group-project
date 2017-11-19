package com.groupproject.image.controller;

import com.groupproject.image.model.request.LinkRequest;
import com.groupproject.image.model.response.LinkResponse;
import com.groupproject.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LinksController {

    private final ImageService imageService;

    @Autowired
    public LinksController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(path = "/links", method = RequestMethod.POST)
    public @ResponseBody
    LinkResponse getLinks(@Valid @RequestBody LinkRequest linksRequest) {
        return imageService.getItems(linksRequest.getImages());
    }
}
