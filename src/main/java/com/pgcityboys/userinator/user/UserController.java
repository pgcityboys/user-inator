package com.pgcityboys.userinator.user;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody CreateUserRequest request) {
		try {
			User user = userService.findUser(request.email());
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		catch (Exception e) {
			userService.saveUser(request.email());
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
	}

}
