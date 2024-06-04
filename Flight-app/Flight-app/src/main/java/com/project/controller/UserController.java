package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.request.UserRequest;
import com.project.service.UserService;

@RestController
@RequestMapping("/flight/app/user/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/signup")
	@ResponseBody
	public String getLogin(@RequestBody User user) {
		System.out.println("INput: "+user);
		return "done";
	} 
	
	@PostMapping(value = "/save")
	public ResponseEntity<?> createuser(@RequestBody UserRequest userRequest) {
		
		try {
			
			User user = userService.saveUser(userRequest);
			return ResponseEntity.ok().body(user);
			
		} catch (Exception e) {
			
			return ResponseEntity.internalServerError().body("Some Error Occur During Saving");
			
		}
				
	}
	
	@GetMapping(value ="/FindUserByUserName")
	public ResponseEntity<?> FindUser(@RequestParam("username") String username) {
		
		try {
			
			User user=userService.FindUserByUserName(username);
			return ResponseEntity.ok().body(user);
			
		} catch (Exception e) {
			
			return ResponseEntity.internalServerError().body("User of This  name is not Found");
		}		
	}
	
	@PostMapping(value = "/login")
	public String loginProcess(@RequestBody UserRequest userRequest) {
		
		try {
			String result=userService.logincheckUserDetails(userRequest);
			return result;
			
		} catch (Exception e) {
			return "Some Erroe occur";

		}
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<?> findAllUser(){
		
		try {
			List<User> allUsers=userService.getAllUser();
			
			return ResponseEntity.ok().body(allUsers);
			
		} catch (Exception e) {
			
			return ResponseEntity.internalServerError().body("Some Error occur During Finding User");
		}
		
	}
	

}
