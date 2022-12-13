package src.com.coffee.domain.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import src.com.coffee.domain.user.domain.User;
import src.com.coffee.domain.user.dto.MyUserDetail;
import src.com.coffee.domain.user.repository.UserRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	
	@Transactional
	public void joinUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.saveUser(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//여기서 받은 유저 패스워드와 비교하여 로그인 인증
		User user = userRepository.findUserByEmail(email);
		return new MyUserDetail(user);
	}
}
