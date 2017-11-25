package com.groupproject.authserver.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth.default-user}")
    private String defaultUser;

    @Value("${auth.default-password}")
    private String defaultPassword;



//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                // We filter the api/login requests
//                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
//                        UsernamePasswordAuthenticationFilter.class)
//                // And filter other requests to check the presence of JWT in header
//                .addFilterBefore(new JWTAuthenticationFilter(),
//                        UsernamePasswordAuthenticationFilter.class);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(defaultUser)
                .password(defaultPassword)
                .roles("ADMIN");
    }
}
