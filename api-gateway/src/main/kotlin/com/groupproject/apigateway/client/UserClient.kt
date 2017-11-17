package com.groupproject.apigateway.client

import org.springframework.cloud.netflix.feign.FeignClient

@FeignClient(serviceId = "user-service")
interface UserClient {

}