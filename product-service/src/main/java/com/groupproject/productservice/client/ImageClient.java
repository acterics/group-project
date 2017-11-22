package com.groupproject.productservice.client;


import com.groupproject.productservice.model.request.ImageLinksRequest;
import com.groupproject.productservice.model.response.ImageLinksResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(serviceId = "image-service")
public interface ImageClient {
    @RequestMapping(method = RequestMethod.POST, value = "/image/links")
    @ResponseBody
    ImageLinksResponse getLinks(ImageLinksRequest request);

}
