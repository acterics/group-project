package com.groupproject.apigateway.client

import com.groupproject.apigateway.domain.product.CatalogResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "product-service")
interface ProductClient {
    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/catalog")
    fun getCatalog(ids: LongArray): CatalogResponse
}