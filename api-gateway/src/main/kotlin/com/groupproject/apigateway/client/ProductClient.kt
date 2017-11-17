package com.groupproject.apigateway.client

import com.groupproject.apigateway.domain.Product
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "product-service")
interface ProductClient {
}