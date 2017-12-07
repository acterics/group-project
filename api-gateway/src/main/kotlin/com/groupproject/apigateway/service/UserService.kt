package com.groupproject.apigateway.service

import com.groupproject.apigateway.client.UserClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

//@Service
//class UserService
//@Autowired constructor(private val userClient: UserClient): UserDetailsService{
//    override fun loadUserByUsername(username: String?): UserDetails =
//        userClient.getUserByName(username)
//
//}