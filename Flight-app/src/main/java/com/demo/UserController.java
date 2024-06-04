package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class UserController {

	@PostMapping("/users/signup")
	@ResponseBody
	public String getLogin(@RequestBody User user) {
		System.out.println("INput: "+user);
		return "done";
	} 
	
}
