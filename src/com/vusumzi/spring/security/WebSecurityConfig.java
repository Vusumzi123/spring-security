package com.vusumzi.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan("com.vusumzi.spring.security.controller")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public UserDetailsService userDetailsService(){  
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();  
        manager.createUser(User
        		.withDefaultPasswordEncoder()
        		.username("javatpoint")
        		.password("java123")
        		.roles("ADMIN")
        		.build()
        );  
        return manager;  
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {  
		
        http.authorizeRequests()
	        .antMatchers("/index", "/user","/").permitAll()
	        .antMatchers("/admin").authenticated() 
	        .and()  
	        .formLogin()  
	        .loginPage("/login")  
	        .and()  
	        .logout()  
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));    
    }
}
