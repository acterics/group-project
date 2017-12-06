package com.groupproject.apigateway.domain.auth

data class LoginResponse(var token: String = "",
                         var success: Boolean = false,
                         var message: String? = null)