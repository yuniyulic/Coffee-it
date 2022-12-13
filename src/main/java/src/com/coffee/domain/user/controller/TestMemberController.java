package src.com.coffee.domain.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import src.com.coffee.domain.user.repository.TestMemberRepository;

@Controller
public class TestMemberController {
	@Autowired
	private TestMemberRepository memberDao;
	
	@GetMapping("/test")
	public String index() {
		System.out.println("@@@@@ /test 호출 성공 @@@@@");
		//memberDao.save(new TestMember("m002", "1234", "test@gmail.com"));
		
		return "test";
	}
	
}
