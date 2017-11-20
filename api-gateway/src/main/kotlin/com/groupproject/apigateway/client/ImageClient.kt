package com.groupproject.apigateway.client

import com.groupproject.apigateway.domain.image.ImageLinksRequest
import com.groupproject.apigateway.domain.image.ImageLinksResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@FeignClient(serviceId = "image-service")
interface ImageClient {

    @RequestMapping(method = arrayOf(RequestMethod.POST), value = "/image/links")
    @ResponseBody
    fun getLinks(request: ImageLinksRequest): ImageLinksResponse
}