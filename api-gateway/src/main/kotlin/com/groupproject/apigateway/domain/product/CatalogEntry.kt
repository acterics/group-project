package com.groupproject.apigateway.domain.product

data class CatalogEntry(var id: Long = 0,
                        var available: Boolean = false,
                        var brand: String = "",
                        var title: String = "",
                        var description: String = "",
                        var category: Category = Category(),
                        var price: Int = 0,
                        var properties: List<PropertyResponse> = listOf(),
                        var photos: List<Photo> = listOf())