package com.groupproject.apigateway.client

import com.groupproject.apigateway.domain.ordering.CartResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient(name = "ordering-service")
interface OrderingClient {

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/cart")
    fun getCart(): CartResponse
}