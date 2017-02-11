package com.templater.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.templater.user.model.entity.UserDto;
import com.templater.user.model.entity.UserEntity;
import com.templater.user.model.request.UserCreateRequest;
import com.templater.user.model.response.UserGetAllResponse;
import com.templater.user.repository.UserRepository;
import com.templater.user.security.UserDetailsCustom;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<UserGetAllResponse> userSelectAll() {
		
		List<UserGetAllResponse> userGetAllResponseList = new ArrayList<UserGetAllResponse>();
		List<UserEntity> userEntityList = userRepository.findAll();
		for(UserEntity e : userEntityList){
			UserGetAllResponse userGetAllResponse = new UserGetAllResponse(e.getUserId(), e.getLoginId(), e.getPw(), e.getEmail(), e.getCertificated(), e.getCreatedDate(), e.getEditedDate(), e.getWithDraw());
			userGetAllResponseList.add(userGetAllResponse);
		}
		return userGetAllResponseList;
	}

	@Override
	public int createUser(UserCreateRequest userCreateRequest){
		
		
		return 0;
	}
	
//	@Override
//	public UserDto readUser(String loginId){
//		UserEntity userEntity = userRepository.findByLoginId(loginId);
//		
//		return new UserDto();
//		
//	}

}
