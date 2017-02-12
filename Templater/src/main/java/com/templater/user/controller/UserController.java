package com.templater.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.templater.common.domain.ApiResponseBody;
import com.templater.user.model.entity.UserDto;
import com.templater.user.model.entity.UserEntity;
import com.templater.user.model.request.UserCreateRequest;
import com.templater.user.model.response.UserGetAllResponse;
import com.templater.user.security.AuthenticationRequest;
import com.templater.user.security.AuthenticationToken;
import com.templater.user.security.UserDetailsCustom;
import com.templater.user.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/user")
public class UserController{

	
	@Autowired
	UserServiceImpl userServiceImpl;
	
//	@Autowired
//	@Qualifier("authenticationManager")
//	AuthenticationManager authenticationManager;

	// test api
	@RequestMapping(value = "/getAll")
	public ApiResponseBody<List<UserGetAllResponse>> userSelect() {
		List<UserGetAllResponse> userGetAllResponseList = userServiceImpl.userSelectAll();
		return new ApiResponseBody(userGetAllResponseList);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ApiResponseBody createUser(@RequestBody UserCreateRequest userCreateRequest, BindingResult bindingResult) {
		
		System.out.println(userCreateRequest);
		int resultCode = userServiceImpl.createUser(userCreateRequest);
		if (resultCode == -1) {
			return new ApiResponseBody(HttpStatus.UNAUTHORIZED.value(), "회원가입 실패");
		}
		return new ApiResponseBody(HttpStatus.OK);
	}
	
	@RequestMapping(value="/{loginId}", method=RequestMethod.GET)
	public ApiResponseBody getUser(@PathVariable String loginId){
		
		
		
		return null;
//		return new ApiResponseBody();
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public AuthenticationToken login(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session) {
//		String loginId = authenticationRequest.getLoginId();
//		String pw = authenticationRequest.getPw();
//
//		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginId, pw);
//		Authentication authentication = authenticationManager.authenticate(token);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
//				SecurityContextHolder.getContext());
//
//		UserDto userDto = userServiceImpl.getUserByLoginId(loginId);
//		UserDetailsCustom userDetails = new UserDetailsCustom(userDto,0);
//		
//		return new AuthenticationToken(userDetails.getUsername(), userDetails.getAuthorities(), session.getId());
//	}

}
