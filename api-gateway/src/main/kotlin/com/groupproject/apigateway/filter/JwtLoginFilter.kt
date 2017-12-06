package com.groupproject.apigateway.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.groupproject.apigateway.domain.auth.AccountCredentials
import com.groupproject.apigateway.service.TokenAuthenticationService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class JwtLoginFilter(url: String,
                     authManager: AuthenticationManager,
                     private val tokenAuthenticationService: TokenAuthenticationService) : AbstractAuthenticationProcessingFilter(AntPathRequestMatcher(url)) {

    init {
        authenticationManager = authManager
    }

    @Throws(AuthenticationException::class, IOException::class, ServletException::class)
    override fun attemptAuthentication(req: HttpServletRequest,
                                       res: HttpServletResponse): Authentication? {

        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        res.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, Authorization");
        res.addHeader("Access-Control-Max-Age", "3600");
        if (req.method != "POST") {

            return null
        }
        val creds = ObjectMapper()
                .readValue<AccountCredentials>(req.inputStream, AccountCredentials::class.java)
        return authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        creds.username,
                        creds.password,
                        emptyList<GrantedAuthority>()
                )
        )
    }

    @Throws(IOException::class, ServletException::class)
    override fun successfulAuthentication(req: HttpServletRequest,
                                          res: HttpServletResponse,
                                          chain: FilterChain?, auth: Authentication) {

        tokenAuthenticationService.addAuthentication(res, auth.name)
    }
}
