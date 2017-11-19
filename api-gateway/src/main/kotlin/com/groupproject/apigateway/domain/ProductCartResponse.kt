package com.groupproject.apigateway.domain

import com.groupproject.apigateway.domain.ordering.CartEntry
import com.groupproject.apigateway.domain.product.CatalogEntry

data class ProductCartResponse(val products: List<CatalogEntry>,
                               val cartProducts: List<CartEntry>)