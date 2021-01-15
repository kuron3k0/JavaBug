package com.kuron3k0.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
public class OAuth2ServerConfig {


    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId("app").stateless(false);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().antMatchers("/se")
                    .and()
                    .authorizeRequests()
                    .antMatchers("/se").access("#oauth2.hasScope('read')");

        }


    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {




        @Autowired
        private BCryptPasswordEncoder passwordEncoder;

        @Override
        public void configure(final AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        }

        @Override
        public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient("kuroneko") // clientId, 可以类比为用户名
                    .secret(passwordEncoder.encode("123456")) // secret， 可以类比为密码
                    .authorizedGrantTypes("authorization_code")    // 授权类型，这里选择授权码
                    .scopes("read") // 授权范围
                    .autoApprove(true) // 自动认证
                    .redirectUris("http://localhost:8882/login","http://localhost:8883/login")    // 认证成功重定向URL
                    .accessTokenValiditySeconds(10); // 超时时间，10s
        }

    }
    }
}