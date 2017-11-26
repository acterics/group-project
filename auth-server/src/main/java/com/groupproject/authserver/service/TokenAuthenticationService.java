package com.groupproject.authserver.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

@Service
@Slf4j
public class TokenAuthenticationService {

    @Value("${auth.expiration}")
    private Long expiration;

    @Value("${auth.secret}")
    private String secret;

    @Value("${auth.prefix}")
    private String prefix;

    @Value("${auth.header}")
    private String header;

    @PostConstruct
    public void initialized() {
        log.warn("secret: " + secret + ", prefix: " + prefix + ", header: " + header);
    }

    public void addAuthentication(HttpServletResponse res, String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        res.addHeader(header, prefix + " " + JWT);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(header);
        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.replace(prefix, ""))
                    .getBody()
                    .getSubject();

            return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
        }
        return null;
    }

}
