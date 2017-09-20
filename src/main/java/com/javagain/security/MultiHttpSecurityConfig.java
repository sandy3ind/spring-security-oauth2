package com.javagain.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * This class contains multiple Http Security. 
 * @author Sandeep.Sharma
 *
 */
@Configuration
@EnableWebSecurity
@Import({ AuthorizationServerConfig.class} )
public class MultiHttpSecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sandeep").password("123456").roles("USER");
	}
	
	/*
	@Configuration
	@Order(1)                                                        
	public static class WebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		@Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
		
		protected void configure(HttpSecurity http) throws Exception {
			http
	        .csrf().disable()       
	        .authorizeRequests()        	
	        	.antMatchers("/oauth/token").permitAll();
		}
	}*/
	
	@Configuration
	@EnableResourceServer
	public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
		@Override
	    public void configure(HttpSecurity http) throws Exception {
	        http.
	        anonymous().disable()
	        .requestMatchers().antMatchers("/user/**");
	    }
		
	}
	
	@Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }	
	
}
