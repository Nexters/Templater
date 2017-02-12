package com.templater.user.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailsServiceCustom extends UserDetailsService{

	   List<GrantedAuthority> getAuthorities(String username);
	
}
