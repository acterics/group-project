package com.groupproject.apigateway.client

import com.groupproject.apigateway.domain.product.CatalogResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "product-service")
interface ProductClient {
    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/products/catalog")
    fun getCatalog(@RequestParam(value = "ids[]") ids: LongArray): CatalogResponse

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/products/catalog")
    fun getCatalogPage(@RequestParam(value = "page", required = false) page: Int?,
                       @RequestParam(value = "size", required = false) size: Int?): CatalogResponse

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/products/category/{categoryId}/list")
    fun getCategoryProductsPage(@PathVariable("categoryId") categoryId: Long,
                                @RequestParam(value = "page", required = false) page: Int?,
                                @RequestParam(value = "size", required = false) size: Int?): CatalogResponse
}