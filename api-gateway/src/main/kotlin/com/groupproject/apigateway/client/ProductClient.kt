package com.groupproject.apigateway.client

import com.groupproject.apigateway.domain.product.CatalogResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "product-service")
interface ProductClient {
    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/products/catalog")
    fun getCatalog(@RequestParam(value = "ids[]") ids: LongArray): CatalogResponse
}