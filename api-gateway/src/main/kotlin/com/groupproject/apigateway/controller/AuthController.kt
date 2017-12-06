package com.groupproject.apigateway.controller

import com.groupproject.apigateway.domain.auth.AccountCredentials
import com.groupproject.apigateway.domain.auth.LoginResponse
import org.springframework.web.bind.annotation.*
import org.springframework.web.context.request.async.DeferredResult

@RestController
class AuthController {

    @RequestMapping(value = "/login", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun login(@RequestBody authCredentials: AccountCredentials): String = "Hello world"

    @RequestMapping(value = "/test_route", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun testget(): String = "TEST GET"

    @RequestMapping(value = "/test_route", method = arrayOf(RequestMethod.POST))
    @ResponseBody
    fun testpost(): String = "TEST POST"

}