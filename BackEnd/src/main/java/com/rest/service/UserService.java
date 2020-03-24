package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.domain.User;
import com.rest.exception.ResourceNotFoundException;
import com.rest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	
	public User getUserById(long userId) {
		Optional<User> userDb = userRepository.findById(userId);
		if(userDb.isPresent()) {
			return userDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}
	
	
	
	public User createUser(User user) {
		System.out.println(user.toString());
		return userRepository.save(user);
	}

	public User updateProduct(User user) {
		// Optional : JAVA 8.0 이상부터 Null 처리에 대한 불편함 때문에 사용
		
		Optional<User> userDb = userRepository.findById(user.getId());
		

		// 회원정보 수정은 NickName, Password만 가능하게 함
		if (userDb.isPresent()) {
			User userUpdate = userDb.get();
			userUpdate.setNickName(user.getNickName());
			userUpdate.setPassword(user.getPassword());
			userRepository.save(userUpdate);
			return userUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + user.getId());
		}

	}
	
	public void deleteUser(long userId) {
		Optional<User> userDb = userRepository.findById(userId);
		if(userDb.isPresent()) {
			userRepository.delete(userDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
		
	}

}
