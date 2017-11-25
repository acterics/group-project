package com.groupproject.authserver;


import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateCrtKey;


@ComponentScan
@SpringBootApplication
public class AuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }

//    @Configuration
//    @Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
//    protected static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.inMemoryAuthentication()
//                    .withUser("admin").roles("ADMIN").password("admin").and()
//                    .withUser("user").roles("USER").password("user");
//
//        }
//
//        @Override
//        @Bean
//        public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//        }
//    }
//
//
//    @ConfigurationProperties(prefix="credentials")
//    @Configuration
//    @EnableAuthorizationServer
//    protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {
//
//        private static final Logger logger = LoggerFactory.getLogger(OAuth2Config.class);
//        private final AuthenticationManager authenticationManager;
//
//        private String keystorePassword;
//        private String keystoreAlias;
//        private String clientPassword;
//        private String clientId;
//
//        @Autowired
//        public OAuth2Config(@Qualifier("authenticationManagerBean") AuthenticationManager authenticationManager) {
//            this.authenticationManager = authenticationManager;
//        }
//
//        @Bean
//        public JwtAccessTokenConverter jwtAccessTokenConverter() {
//            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//            KeyPair keyPair = new KeyStoreKeyFactory(
//                    new ClassPathResource("keystore.jks"), keystorePassword.toCharArray())
//                    .getKeyPair(keystoreAlias);
//            converter.setKeyPair(keyPair);
//            return converter;
//        }
//
//        @Override
//        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//            clients.inMemory()
//                    .withClient(clientId).secret(clientPassword).authorities("CLIENT")
//                    .authorizedGrantTypes("authorization_code", "refresh_token", "client_credentials", "password")
//                    .scopes("internal", "external");
//        }
//
//        @Override
//        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//            endpoints.authenticationManager(authenticationManager).accessTokenConverter(jwtAccessTokenConverter());
//        }
//
//        @Override
//        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//            oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
//        }
//
//        public void setKeystorePassword(String keystorePassword) {
//            this.keystorePassword = keystorePassword;
//        }
//        public void setKeystoreAlias(String keystoreAlias) {
//            this.keystoreAlias = keystoreAlias;
//        }
//        public void setClientPassword(String clientPassword) {
//            this.clientPassword = clientPassword;
//        }
//        public void setClientId(String clientId) {
//            this.clientId = clientId;
//        }
//    }

}
