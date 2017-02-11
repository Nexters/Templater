package com.templater.user.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class AuthenticationToken {
	private String loginId;
	private Collection<?extends GrantedAuthority> authorities;
	private String token;
	
	public AuthenticationToken(String loginId, Collection<? extends GrantedAuthority> authorities, String token) {
		this.loginId = loginId;
		this.authorities = authorities;
		this.token = token;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
