package com.groupproject.apigateway.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Service
class TokenAuthenticationService {

    @Value("\${auth.expiration}")
    private lateinit var expiration: String

    @Value("\${auth.secret}")
    private lateinit var secret: String

    @Value("\${auth.prefix}")
    private lateinit var prefix: String

    @Value("\${auth.header}")
    private lateinit var header: String

    var token: String? = null

    fun addAuthentication(res: HttpServletResponse, username: String) {
        val jwt = Jwts.builder()
                .setSubject(username)
                .setExpiration(Date(System.currentTimeMillis() + expiration.toLong()))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact()
        token = jwt
        res.writer.write("{ \"token\": \"$jwt\" }")
        res.addHeader("Content-Type", "application/json")
        res.addHeader(header, prefix + " " + jwt)
    }

    fun getAuthentication(request: HttpServletRequest): Authentication? {
        val token = request.getHeader(header)
        if (token != null) {
            // parse the token.
            val user = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.replace(prefix, ""))
                    .body
                    .subject

            return if (user != null) UsernamePasswordAuthenticationToken(user, null, emptyList<GrantedAuthority>()) else null
        }
        return null
    }

}
