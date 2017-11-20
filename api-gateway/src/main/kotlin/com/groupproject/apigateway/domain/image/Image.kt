package com.groupproject.apigateway.domain.image

data class Image(var url: String = "",
                 var width: Int = 0,
                 var height: Int = 0,
                 var resizingType: String = "fit",
                 var gravity: String = "ce",
                 var enlarge: Int = 0,
                 var extension: String = "webp")