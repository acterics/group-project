package com.groupproject.apigateway.component

import org.springframework.stereotype.Component
import org.springframework.web.context.request.async.DeferredResult
import rx.Observable


@Component
class DeferredResultWrapper {

    fun <T>toDeferredResult(observable: Observable<T>): DeferredResult<T> {
        val deferredResult = DeferredResult<T>()
        observable.subscribe(
                { result -> deferredResult.setResult(result) }
        )
        return deferredResult
    }
}