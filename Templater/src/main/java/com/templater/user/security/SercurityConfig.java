package com.templater.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;


import com.templater.user.repository.UserRepository;
import com.templater.user.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired UserRepository userRepository;
	//@Autowired CORSFilter corsFilter;
	@Autowired
	UserServiceImpl userServiceImpl;
//	@Autowired
//	UserServiceCustomImpl userServiceCustomImpl;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        	.csrf().disable()
        		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and()
        		.authorizeRequests()
        			.antMatchers("/**").permitAll()
//            		.antMatchers("/user/login").permitAll()
//            		.antMatchers("/**").hasAuthority("USER")
//            		.antMatchers("/admin").hasAuthority("ADMIN")
            .and()
            	.logout()
            .and()
            	.httpBasic();
    	
    }
	
//    @Bean(name=BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//    	System.out.println("dddd");
//        return super.authenticationManagerBean();
//    }

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	};

	@Bean
	public SecurityContextRepository securityContextRepository() {
		return new HttpSessionSecurityContextRepository();
	}
//	 @Bean
//     public HttpSessionStrategy httpSessionStrategy() {
//               return new HeaderHttpSessionStrategy();
//     }

}
