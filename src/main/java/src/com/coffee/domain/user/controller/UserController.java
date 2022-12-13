package src.com.coffee.domain.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import src.com.coffee.domain.user.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/joinForm")
	public String joinForm() {
		System.out.println("@@@ /joinForm 호출 성공 @@@");
		
		return "joinForm";
	}
	
}
