package com.javagain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.javagain.security.SecurityConfig;

/**
 * 
 * @author Sandeep.Sharma
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan({ "com.javagain.*", "com.javagain.security*" })
//@Import({ SecurityConfig.class })
public class AppConfig {

}
