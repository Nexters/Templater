package com.templater.user.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.templater.user.model.entity.UserDto;
import com.templater.user.model.entity.UserEntity;
import com.templater.user.model.request.UserCreateRequest;
import com.templater.user.model.response.UserGetAllResponse;
import com.templater.user.model.response.UserGetResponse;
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
	public UserGetResponse getUserByLoginId(String loginId) {
		UserEntity e = userRepository.findByLoginId(loginId);
		return new UserGetResponse(e.getLoginId(), e.getEmail(), e.getCertificated(), e.getCreatedDate(), e.getEditedDate());
	}
	
	@Override
	public UserDto getUserDetailByLoginId(String loginId){
		UserEntity e = userRepository.findByLoginId(loginId);
		
		return new UserDto(e.getLoginId(),e.getPw(),e.getEmail(),e.getCertificated(),e.getCreatedDate(),e.getEditedDate(),e.getWithDraw(),e.getAuth());
	}

	@Override
	public int createUser(UserCreateRequest userCreateRequest){
		
		String createdDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());;
		
		UserEntity e = new UserEntity(
				userCreateRequest.getLoginId(),
				BCrypt.hashpw(userCreateRequest.getPw(), BCrypt.gensalt()),
				userCreateRequest.getEmail(),
				createdDate,
				"user");

		try{
			userRepository.save(e);
		}catch(Exception ex){
			ex.printStackTrace();
			return -1;
		}
		return HttpStatus.OK.value();
	}
	
	@Override
	public boolean isAuthenticated(){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String loginName = auth.getName();
		System.out.println("user info: "+loginName);
		if(loginName.equals("anonymousUser")){
			System.out.println("is authenticated false");
			
			return false;
		}
		System.out.println("is authenticated true");
		return true;
	}

	@Override
	public long getUserIdByLoginId(String loginId) {
		UserEntity userEntity = userRepository.findByLoginId(loginId);
		if(userEntity==null){
			return 0;
		}
		return userEntity.getUserId();
	}

//	@Override
//	public UserDto readUser(String loginId){
//		UserEntity userEntity = userRepository.findByLoginId(loginId);
//		
//		return new UserDto();
//		
//	}

}
