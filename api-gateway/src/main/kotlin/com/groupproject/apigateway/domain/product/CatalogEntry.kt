package com.groupproject.apigateway.domain.product

data class CatalogEntry(val id: Long,
                        val available: Boolean,
                        val brand: String,
                        val title: String,
                        val description: String,
                        val category: Category,
                        val price: Float,
                        val properties: List<PropertyResponse>,
                        val photos: List<Photo>)