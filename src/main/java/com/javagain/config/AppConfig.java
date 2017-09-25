package com.javagain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author Sandeep.Sharma
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan({ "com.javagain.web*", "com.javagain.security*" })
public class AppConfig {

}
