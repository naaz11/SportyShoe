package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entity.User;
import com.simplilearn.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getUsers();
	}
	
	
	@PostMapping("/users")
	public int saveUsers(@RequestBody User user) {
		userService.saveUser(user);
		return user.getId();
	}
	
	@GetMapping("/users/search")
	public User find(@RequestParam("username") String username){
		return userService.search(username);
	}
	
	@GetMapping({"/user_records"})
	public ModelAndView tabulateUsers() {
		ModelAndView mav1 = userService.tabulateUsers();
		return mav1;
	}
	
}

