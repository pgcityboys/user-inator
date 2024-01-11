package com.pgcityboys.userinator.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User findUser(String email) throws Exception {
		return userRepository.findById(email).orElseThrow(() -> new Exception("Invalid email"));
	}

	public void saveUser(String email) {
		userRepository.save(new User(email));
	}
}
