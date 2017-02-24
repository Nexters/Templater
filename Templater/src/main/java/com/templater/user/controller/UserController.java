package com.templater.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.templater.common.domain.ApiResponse;
import com.templater.user.model.entity.UserDto;
import com.templater.user.model.request.UserCreateRequest;
import com.templater.user.model.response.UserGetAllResponse;
import com.templater.user.model.response.UserGetResponse;
import com.templater.user.security.AuthenticationRequest;
import com.templater.user.security.AuthenticationToken;
import com.templater.user.security.UserDetailsCustom;
import com.templater.user.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/user")
public class UserController{

	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	@Qualifier("org.springframework.security.authenticationManager")
	AuthenticationManager authenticationManager;

	// test api
	@RequestMapping(value = "/getAll")
	public ApiResponse<List<UserGetAllResponse>> userSelect() {
		List<UserGetAllResponse> userGetAllResponseList = userServiceImpl.userSelectAll();
		return new ApiResponse(userGetAllResponseList);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ApiResponse createUser(@RequestBody UserCreateRequest userCreateRequest, BindingResult bindingResult) {
		
		System.out.println(userCreateRequest);
		int resultCode = userServiceImpl.createUser(userCreateRequest);
		if (resultCode == -1) {
			return new ApiResponse(HttpStatus.UNAUTHORIZED.value(), "회원가입 실패");
		}
		return new ApiResponse(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase());
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ApiResponse getUser(){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String loginId = auth.getName();
		try{
			UserGetResponse userResponse = userServiceImpl.getUserByLoginId(loginId);
			return new ApiResponse(userResponse);
		}catch(Exception e){
			e.printStackTrace();
			return new ApiResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		}
	}
	
	@RequestMapping(value="/{loginIdParam}", method=RequestMethod.GET)
	public ApiResponse getUser(@PathVariable String loginIdParam){
		
		String loginId = loginIdParam; 
		System.out.println(loginId);
		
		try{
			UserGetResponse userResponse = userServiceImpl.getUserByLoginId(loginId);
			return new ApiResponse(userResponse);
		}catch(Exception e){
			e.printStackTrace();
			return new ApiResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AuthenticationToken login(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session) {
		String loginId = authenticationRequest.getLoginId();
		String pw = authenticationRequest.getPw();

		
		System.out.println(loginId+"/"+pw);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginId, pw);
		
		System.out.println(token);
		Authentication authentication = authenticationManager.authenticate(token);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());

		UserDto userDto = userServiceImpl.getUserDetailByLoginId(loginId);
		UserDetailsCustom userDetails = new UserDetailsCustom(userDto,0);
		
		return new AuthenticationToken(userDetails.getUsername(), userDetails.getAuthorities(), session.getId());
	}
	
	@RequestMapping(value="/auth")
	public ApiResponse isAuthentication(){
		Map<String,Object> map = new HashMap<String,Object>();
		if(userServiceImpl.isAuthenticated()){
			map.put("isAuthenticated", true);
			return new ApiResponse<Map<String,Object>>(map);
		}else{
			map.put("isAuthenticated", false);
			return new ApiResponse<Map<String,Object>>(map);
		}
	}

}
