package com.groupproject.apigateway.controller

import com.groupproject.apigateway.domain.ProductCartResponse
import com.groupproject.apigateway.domain.product.CatalogResponse
import com.groupproject.apigateway.service.OrderingService
import com.groupproject.apigateway.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import rx.Observable

@RestController
class GatewayController
    @Autowired constructor(private val orderingService: OrderingService,
                           private val productService: ProductService) {

    @RequestMapping(value = "/cart", method = arrayOf(RequestMethod.GET))
    fun getCartProducts(): Observable<ProductCartResponse> =
        orderingService.getCart()
                .map { cartResponse -> cartResponse.items }
                .flatMap { cartItems -> productService.getProducts(cartItems.map { it.itemId })
                        .map { it.products }
                        .map { products -> ProductCartResponse(products, cartItems) }
                }
}