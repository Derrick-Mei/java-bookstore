package com.lambdaschool.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/sections/**").access("hasAnyRole('ROLE_MGR', 'ROLE_USER', 'ROLE_DATA')")
                .antMatchers("/authors/**").access("hasAnyRole('ROLE_MGR', 'ROLE_USER', 'ROLE_DATA')")
                .antMatchers("/books/**").access("hasAnyRole('ROLE_MGR', 'ROLE_USER', 'ROLE_DATA')")
                .antMatchers("/users/**").access("hasAnyRole('ROLE_MGR')")
                .antMatchers("/data/**").access("hasAnyRole('ROLE_DATA')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
