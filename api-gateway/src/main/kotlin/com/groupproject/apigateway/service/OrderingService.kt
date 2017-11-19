package com.groupproject.apigateway.service

import com.groupproject.apigateway.client.OrderingClient
import com.groupproject.apigateway.domain.ordering.CartResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import rx.Observable

@Service
class OrderingService
    @Autowired constructor(private val orderingClient: OrderingClient) {

    fun getCart(): Observable<CartResponse> =
            Observable.just(orderingClient.getCart())
}