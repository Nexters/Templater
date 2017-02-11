package com.templater.user.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.templater.user.model.entity.UserDto;
import com.templater.user.repository.UserRepository;
import com.templater.user.service.UserServiceImpl;

public class UserServiceCustomImpl implements UserDetailsServiceCustom{

	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	public UserServiceCustomImpl(UserRepository userRepository,UserServiceImpl userServiceImpl){
		this.userRepository = userRepository;
		this.userServiceImpl = userServiceImpl;
	}
	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		
		UserDto userDto = userServiceImpl.getUserByLoginId(loginId);
		
		UserDetailsCustom userDetails = new UserDetailsCustom(userDto,0);
		
		return userDetails;
	}

	@Override
	public List<GrantedAuthority> getAuthorities(String loginId) {
		return null;
	}

}
