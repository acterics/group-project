package com.groupproject.apigateway.controller

import com.groupproject.apigateway.component.DeferredResultWrapper
import com.groupproject.apigateway.domain.ProductCartResponse
import com.groupproject.apigateway.domain.product.CatalogResponse
import com.groupproject.apigateway.service.ImageService
import com.groupproject.apigateway.service.OrderingService
import com.groupproject.apigateway.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.async.DeferredResult


@RestController
class GatewayController
    @Autowired constructor(private val orderingService: OrderingService,
                           private val productService: ProductService,
                           private val imageService: ImageService,
                           private val deferredResultWrapper: DeferredResultWrapper) {

    companion object {
        const val DEFAULT_WIDTH = 500
        const val DEFAULT_HEIGHT = 500
    }

    @RequestMapping(value = "/cart", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getCartProducts(@RequestParam(value = "width", required = false) width: Int?,
                        @RequestParam(value = "height", required = false) height: Int?): DeferredResult<ProductCartResponse> =
        orderingService.getCart()
                .map { cartResponse -> cartResponse.items }
                .flatMap(
                        { items -> productService.getProductsFromCart(items) },
                        { items, products -> ProductCartResponse(products, items)})
                .flatMap(
                        { response -> imageService.getImagesFromProducts(response.products,
                                width ?: DEFAULT_WIDTH, height ?: DEFAULT_HEIGHT)},
                        { response, images -> response.apply { imageService.proxyProductsImages(products, images) } })
                .let { observable -> deferredResultWrapper.toDeferredResult(observable) }


    @RequestMapping(value = "/catalog", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getCatalogPage(@RequestParam(value = "page", required = false) page: Int?,
                   @RequestParam(value = "size", required = false) size: Int?,
                   @RequestParam(value = "width", required = false) width: Int?,
                   @RequestParam(value = "height", required = false) height: Int?): DeferredResult<CatalogResponse> =
        productService.getCatalogPage(page, size)
                .flatMap(
                        { response -> imageService.getImagesFromProducts(response.products,
                                width ?: DEFAULT_WIDTH, height ?: DEFAULT_HEIGHT) },
                        { response, images -> response.apply { imageService.proxyProductsImages(products, images) } } )
                .let { observable -> deferredResultWrapper.toDeferredResult(observable) }

    @RequestMapping(value = "/category/{categoryId}/list")
    @ResponseBody
    fun getCategoryProductsPage(@PathVariable("categoryId") categoryId: Long,
                                @RequestParam(value = "page", required = false) page: Int?,
                                @RequestParam(value = "size", required = false) size: Int?,
                                @RequestParam(value = "width", required = false) width: Int?,
                                @RequestParam(value = "height", required = false) height: Int?): DeferredResult<CatalogResponse> =
            productService.getCategoryProducts(categoryId, page, size)
                    .flatMap(
                            { response -> imageService.getImagesFromProducts(response.products,
                                    width ?: DEFAULT_WIDTH, height ?: DEFAULT_HEIGHT) },
                            { response, images -> response.apply { imageService.proxyProductsImages(products, images) } } )
                    .let { observable -> deferredResultWrapper.toDeferredResult(observable) }


}