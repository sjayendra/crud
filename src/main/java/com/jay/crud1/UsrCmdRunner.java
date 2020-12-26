package com.jay.crud1;


import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import com.jay.crud1.User;
import com.jay.crud1.UserRepository;

import com.jay.crud1.UserRepo;
import com.jay.crud1.User;

@Component
public class UsrCmdRunner implements  CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(UsrCmdRunner.class);

    @Autowired
    private UserRepository userRepository;

    private @Autowired UserRepo userRepo;

    @Override
    public void run(String... arg0) throws Exception {
        log.info("Started running");
        User user = new User("Jack","Admin","one@ron");
        //User. = new User("Jack","Admin","jack@gmail.com");
        userRepository.save(user);

        List<User> users = userRepository.findAll();
        log.info("All Users : " + users);

        String password = "titan123";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        //String h1 = passwordEncoder.ha
        System.out.print("Orginal : " + password);
        System.out.println("Encode Password : " + hashedPassword);


        boolean isPasswordMatch = passwordEncoder.matches(password, hashedPassword);
        System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);

        String hashedPassword1 = "$2a$10$saw2Oa9iqI8aAObfI0z7cuO9T8d29Fehtp2z3fidWGNzhRrTkrLsK";

        boolean isPasswordMatch1 = passwordEncoder.matches(password, hashedPassword1);
        System.out.println("Password : " + password + "   isPasswordMatch1    : " + isPasswordMatch1);

       // System.out.println(passwordEncoder.)

        Sort sort;
        Pageable pageable = PageRequest.of(0, 10);

        while (true) {
            Page<User> page = userRepo.findAll(pageable);
            int number = page.getNumber();

            List<User> userList = page.getContent();


            userList.forEach(System.out::println);
            System.out.println(userList.get(0).getId());
            System.out.println(userList.get(0).getName());

            if (!page.hasNext()) {
                break;
            }
            pageable = page.nextPageable();

            if (!page.hasNext()) {
                break;
            }
            pageable = page.nextPageable();
        }

    }
}
