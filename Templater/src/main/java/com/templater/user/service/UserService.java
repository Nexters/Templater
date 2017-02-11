package com.templater.user.service;

import java.util.List;

import com.templater.user.model.entity.UserEntity;
import com.templater.user.model.request.UserCreateRequest;
import com.templater.user.model.response.UserGetAllResponse;

public interface UserService {

	public List<UserGetAllResponse> userSelectAll();
	public int createUser(UserCreateRequest userCreateRequest);
	//public UserEntity readUser(String loinId);
	
}
