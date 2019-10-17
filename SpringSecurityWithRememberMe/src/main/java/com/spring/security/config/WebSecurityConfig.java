package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity    
@ComponentScan("com.spring.security.config")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@SuppressWarnings("deprecation")
	@Bean    
	public UserDetailsService userDetailsService() {    
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();    
	    manager.createUser(User.withDefaultPasswordEncoder()  
	    .username("admin")
	    .password("admin123")
	    .roles("ADMIN").build());    
	    return manager;    
	}    
	
	@Override    
	protected void configure(HttpSecurity http) throws Exception {    
	      
	      http.authorizeRequests().  
	      antMatchers("/index", "/user","/").permitAll()  
	      .antMatchers("/admin").authenticated()  
	      .and()  
	      .formLogin()  
	      .loginPage("/login")  
	      .and()  
	      .rememberMe()  
	      .key("rem-me-key")  
	      .rememberMeParameter("remember") // it is name of checkbox at login page  
	      .rememberMeCookieName("rememberlogin") // it is name of the cookie  
	      .tokenValiditySeconds(100) // remember for number of seconds  
	      .and()  
	      .logout()  
	      .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));    
	}    

}
