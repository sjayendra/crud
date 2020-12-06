package com.jay.crud1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.crud1.User;
import com.jay.crud1.UserRepository;

@SpringBootApplication
public class Crud1Application {

	public static void main(String[] args) {
		SpringApplication.run(Crud1Application.class, args);
	}


	@RequestMapping("/")
	public String index() {
		return "Greetings from Heroku !";
	}

	@RestController
	@RequestMapping("/user")
	public class UserController {
		@Autowired
		private UserRepository userRepository;

		@GetMapping
		public Iterable<User> getUser() {
			return this.userRepository.findAll();
		}
	}
}