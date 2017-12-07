package com.groupproject.apigateway.configuration

import com.groupproject.apigateway.filter.JwtAuthenticationFilter
import com.groupproject.apigateway.filter.JwtLoginFilter
import com.groupproject.apigateway.service.TokenAuthenticationService
//import com.groupproject.apigateway.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer



@Configuration
@EnableWebSecurity
open class WebSecurityConfig @Autowired
constructor(private val tokenAuthenticationService: TokenAuthenticationService
            /*,private val userService: UserService*/) : WebSecurityConfigurerAdapter() {

    @Value("\${auth.default-user}")
    lateinit var defaultUser: String

    @Value("\${auth.default-password}")
    lateinit var defaultPassword: String


    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .csrf().disable().authorizeRequests()

                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/products/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/products/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // We filter the api/login requests
                .addFilterBefore(JwtLoginFilter("/login", authenticationManager(), tokenAuthenticationService),
                        UsernamePasswordAuthenticationFilter::class.java)
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(JwtAuthenticationFilter(tokenAuthenticationService),
                        UsernamePasswordAuthenticationFilter::class.java)
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.userDetailsService(userService)
        auth.inMemoryAuthentication()
                .withUser(defaultUser)
                .password(defaultPassword)
                .roles("ADMIN")
    }

    @Bean
    open fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurerAdapter() {
            override fun addCorsMappings(registry: CorsRegistry?) {
                registry!!.addMapping("/**")
                        .allowCredentials(true)
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
                        .allowedOrigins("*")
                        .allowedHeaders("*")
            }
        }
    }
}