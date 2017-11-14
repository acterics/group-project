package com.groupproject.apigateway.service

import com.groupproject.apigateway.client.ProductClient
import com.groupproject.apigateway.domain.Product
import io.reactivex.Single
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    @Autowired
    lateinit var productClient: ProductClient

    fun getProducts(): Single<List<Product>> = Single.just(productClient.getProducts())
}