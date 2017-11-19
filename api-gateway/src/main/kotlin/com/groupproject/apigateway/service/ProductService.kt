package com.groupproject.apigateway.service

import com.groupproject.apigateway.client.ProductClient
import com.groupproject.apigateway.domain.product.CatalogResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import rx.Observable

@Service
class ProductService
    @Autowired constructor(private val productClient: ProductClient) {

    fun getProducts(ids: List<Long>): Observable<CatalogResponse> =
            Observable.just(productClient.getCatalog(ids.toLongArray()))
}