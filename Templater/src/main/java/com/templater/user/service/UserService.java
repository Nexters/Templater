package com.templater.user.service;

import java.util.List;

import com.templater.user.model.entity.UserDto;
import com.templater.user.model.request.UserCreateRequest;
import com.templater.user.model.response.UserGetAllResponse;
import com.templater.user.model.response.UserGetResponse;

public interface UserService {

	public List<UserGetAllResponse> userSelectAll();
	public int createUser(UserCreateRequest userCreateRequest);
	public UserGetResponse getUserByLoginId(String loginId);
	UserDto getUserDetailByLoginId(String loginId);
	public boolean isAuthenticated();
}
