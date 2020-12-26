package com.jay.crud1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.ui.Model;
import org.springframework.data.repository.query.Param;
import java.util.List;

@SpringBootApplication
public class Crud1Application {

	public static void main(String[] args) {
		SpringApplication.run(Crud1Application.class, args);
	}

	@Autowired
	private UserService service;

	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		return "add-user";
	}

	//@RequestMapping("/")
	//public String index() {
	//	return "Greetings from Heroku !";
	//}

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

	@RequestMapping("/jay")
	public String jay()
	{
		return "test";
	}

	@RequestMapping("/all")
	public String showSignUpForm1(User user) {
		return "users";
	}

	//public String showAll(Model model) {
		//model.addAttribute("User", service.findAll());
	//	model.addAttribute("User",service.listAll1());

		//return "users";
	//}

	@RequestMapping("/users")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
		List<User> listUsers = service.listAll(keyword);
		//	model.addAttribute("listUsers", listUsers);
		//	model.addAttribute("keyword", keyword);

		return "user";

		}
	}