
package com.simplilearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.entity.User;
import com.simplilearn.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers() {
		List<User> users= new ArrayList<User>();
		userRepository.findAll().forEach(user -> users.add(user));
		return users;
	} 
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public User search(String username) {
		return userRepository.findByUsername(username);
	}
	
	public String updateUser(String username, String newPassword) {
		User user = userRepository.findByUsername(username);
		user.setPassword(newPassword);
		//movie1.setName(movie.getName());
		userRepository.save(user);
		String status = "changepwdsuccess";
		return status;
	}
	
	public ModelAndView tabulateUsers() {
		ModelAndView mav = new ModelAndView("user_records");
		mav.addObject("users", userRepository.findAll());
		return mav;
	}
	
}
