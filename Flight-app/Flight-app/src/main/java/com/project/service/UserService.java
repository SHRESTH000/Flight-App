package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDao;
import com.project.model.User;
import com.project.request.UserRequest;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User saveUser(UserRequest InputUser) {
		
		User user=new User();
		
		user.setUserName(InputUser.getUsername());
		user.setPassword(InputUser.getPassword());
		
		User savedUser=userDao.save(user);
		if(savedUser==null) {
			throw new RuntimeException("Some Error Occur During saving");
		}	
		
		return savedUser;
		
	}
	
	public User FindUserByUserName(String username) {
		
		User user=userDao.getUserByUserName(username);
		
		if(user==null) {
			throw new RuntimeException("No User Found of That UserName");
		}
		return user;
		
	}
	
	public String logincheckUserDetails(UserRequest inputRequest) {
		
		User userData=FindUserByUserName(inputRequest.getUsername());
		
		if(userData!=null) {
			if(inputRequest.getPassword().equals(userData.getPassword())) {
				
				String reString="Login Sucessful";
				return reString;
			}else {
				
				return "Password Wrong";
			}
		}else {
			return "No UserName is found Of that name";
		}
		
		
	}
	
	public List<User> getAllUser() {
		
		List<User> allUsers=userDao.findAll();
		if(allUsers.isEmpty()) {
			throw new RuntimeException("No user Found");
		}
		
		return allUsers;
	}

}
