package com.templater.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.templater.user.model.entity.UserDto;
import com.templater.user.model.entity.UserEntity;
import com.templater.user.model.request.UserCreateRequest;
import com.templater.user.model.response.UserGetAllResponse;
import com.templater.user.repository.UserRepository;

@Component
@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;
	
	
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
	
//	@Override
//	public UserGetResponse getUser(String loginId){
//		
//		return null;
//	}
	
	@Override
	public UserDto getUserByLoginId(String loginId){
		UserEntity e = userRepository.findByLoginId(loginId);
		
		return new UserDto(e.getLoginId(),e.getPw(),e.getEmail(),e.getCertificated(),e.getCreatedDate(),e.getEditedDate(),e.getWithDraw(),e.getAuth());
	}

	@Override
	public int createUser(UserCreateRequest userCreateRequest){
		UserEntity e = new UserEntity(
				userCreateRequest.getLoginId(),
				BCrypt.hashpw(userCreateRequest.getPw(), BCrypt.gensalt()),
				userCreateRequest.getEmail(),
				"user");

		try{
			userRepository.save(e);
		}catch(Exception ex){
			ex.printStackTrace();
			return -1;
		}
		return HttpStatus.OK.value();
	}
	
//	@Override
//	public UserDto readUser(String loginId){
//		UserEntity userEntity = userRepository.findByLoginId(loginId);
//		
//		return new UserDto();
//		
//	}

}
