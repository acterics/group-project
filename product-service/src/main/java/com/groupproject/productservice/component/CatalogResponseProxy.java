package com.groupproject.productservice.component;

import com.groupproject.productservice.client.ImageClient;
import com.groupproject.productservice.model.request.ImageLinksRequest;
import com.groupproject.productservice.model.request.InputImage;
import com.groupproject.productservice.model.response.CatalogResponse;
import com.groupproject.productservice.model.response.ImageLinksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CatalogResponseProxy {

    private final ImageClient imageClient;

    @Autowired
    public CatalogResponseProxy(ImageClient imageClient) {
        this.imageClient = imageClient;
    }

    public CatalogResponse proxy(CatalogResponse catalogResponse) {
        List<InputImage> inputImages = catalogResponse.getProducts()
                .stream()
                .flatMap(catalogEntry -> catalogEntry.getPhotos().stream())
                .map(photo -> {
                    InputImage inputImage = new InputImage();
                    inputImage.setUrl(photo.getFilename());
                    inputImage.setWidth(100);
                    inputImage.setHeight(100);
                    return inputImage;
                })
                .collect(Collectors.toList());

        ImageLinksRequest request = new ImageLinksRequest();
        request.setImages(inputImages);

        ImageLinksResponse response = imageClient.getLinks(request);
        Iterator<String> iterator = response.getImages()
                .stream()
                .map(outputImage -> "/imgproxy" + outputImage.getUrl())
                .iterator();
        catalogResponse.getProducts()
                .stream()
                .flatMap(catalogEntry -> catalogEntry.getPhotos().stream())
                .forEachOrdered(photo -> photo.setFilename(iterator.next()));
        return catalogResponse;
    }
}
