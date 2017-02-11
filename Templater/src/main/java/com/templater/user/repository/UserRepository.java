package com.templater.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.templater.user.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	
	public UserEntity findByLoginId(String loginId);

}
