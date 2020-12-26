package com.jay.crud1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService service1;

    @Autowired
    private UserService service;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

    @GetMapping("/adduser")
    public String userForm(Model model) {
        model.addAttribute("adduser", new User());
        return "adduser";
    }

    @PostMapping("/adduser")
    public String adduserSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("User", user);
        userRepository.save(user);
        return "success";
    }

    @RequestMapping("/user01")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<User> listUsers = service.listAll(keyword);
        model.addAttribute("listUsers", listUsers);
        model.addAttribute("keyword", keyword);

        return "user01";
    }

    @RequestMapping("/product")
    public String viewHomePage1(Model model, @Param("keyword") String keyword) {
        List<Product> listProducts = service1.listAll(keyword);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("keyword", keyword);

        return "product";
    }
}