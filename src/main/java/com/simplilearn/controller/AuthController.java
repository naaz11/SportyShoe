package com.simplilearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.simplilearn.entity.User;
import com.simplilearn.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;
	
	public String newPwd(String username, String password) {
		String status=userService.updateUser(username, password);
		return status;
	}
	
	@GetMapping("/login")
    public String adminLoginPage(Model model) {
		model.addAttribute("user", new User());
        return "login";
    }
	
	@PostMapping("/login")
	public String validateUsers(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		String reqpass = user.getPassword();
		User user1 = userService.search(user.getName());
		if (reqpass.equals(user1.getPassword())){
				return "dashboard";
		}
		else {
			return "login";
		}
	}
	
	@GetMapping("/change_pwd")
    public String chagePwdip(Model model) {
		model.addAttribute("user", new User());
        return "change_pwd";
    }
	
	@PostMapping("/change_pwd")
	public String changePwdop(@ModelAttribute User user, Model model) {
		model.addAttribute("user", user);
		return newPwd(user.getName(), user.getPassword());
	}
}

