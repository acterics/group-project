package com.groupproject.apigateway.controller

import com.groupproject.apigateway.domain.auth.AccountCredentials
import com.groupproject.apigateway.domain.auth.LoginResponse
import com.groupproject.apigateway.service.TokenAuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.async.DeferredResult

@RestController
class AuthController
@Autowired constructor(private val tokenAuthenticationService: TokenAuthenticationService){

//    @RequestMapping(value = "/login", method = arrayOf(RequestMethod.POST))
//    @ResponseBody
//    fun login(@RequestBody authCredentials: AccountCredentials): LoginResponse {
//        val currentToken = tokenAuthenticationService.token
//        tokenAuthenticationService.token = null
//        return currentToken?.let { LoginResponse(it, true) } ?: LoginResponse()
//    }




    @RequestMapping(value = "/test_route", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun testget(): String = "TEST GET"

    @RequestMapping(value = "/test_route", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun testpost(): String = "TEST POST"

}