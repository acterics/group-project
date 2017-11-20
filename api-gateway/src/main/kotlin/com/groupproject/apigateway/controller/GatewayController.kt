package com.groupproject.apigateway.controller

import com.groupproject.apigateway.component.DeferredResultWrapper
import com.groupproject.apigateway.domain.ProductCartResponse
import com.groupproject.apigateway.domain.product.CatalogResponse
import com.groupproject.apigateway.service.OrderingService
import com.groupproject.apigateway.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.async.DeferredResult
import rx.Observable

@RestController
class GatewayController
    @Autowired constructor(private val orderingService: OrderingService,
                           private val productService: ProductService,
                           private val deferredResultWrapper: DeferredResultWrapper) {

    @RequestMapping(value = "/cart", method = arrayOf(RequestMethod.GET))
    fun getCartProducts(): DeferredResult<ProductCartResponse> =
        orderingService.getCart()
                .map { cartResponse -> cartResponse.items }
                .flatMap { cartItems -> productService.getProducts(cartItems.map { it.itemId })
                        .map { response -> response.products }
                        .map { products -> ProductCartResponse(products, cartItems) }
                }
                .let { observable ->  deferredResultWrapper.toDeferredResult(observable) }

}