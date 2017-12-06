package com.groupproject.apigateway.client

import com.groupproject.apigateway.domain.auth.User
import com.groupproject.apigateway.domain.product.CatalogResponse
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(serviceId = "user-service")
interface UserClient {
    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/user/")
    fun getUserByName(@RequestParam(value = "username") username: String?): User
}