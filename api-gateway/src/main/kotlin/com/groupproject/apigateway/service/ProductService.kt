package com.groupproject.apigateway.service

import com.groupproject.apigateway.client.ProductClient
import com.groupproject.apigateway.domain.ordering.CartEntry
import com.groupproject.apigateway.domain.product.CatalogEntry
import com.groupproject.apigateway.domain.product.CatalogResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import rx.Observable

@Service
class ProductService
    @Autowired constructor(private val productClient: ProductClient) {


    fun getProductsFromCart(cartItems: List<CartEntry>): Observable<List<CatalogEntry>> =
            Observable.just(productClient.getCatalog(cartItems
                    .map { item -> item.itemId }
                    .toLongArray())
            ).map { response -> response.products }

    fun getCatalogPage(page: Int?, size: Int?): Observable<CatalogResponse> =
            Observable.just(productClient.getCatalogPage(page, size))

    fun getCategoryProducts(categoryId: Long, page: Int?, size: Int?): Observable<CatalogResponse> =
            Observable.just(productClient.getCategoryProductsPage(categoryId, page, size))

}