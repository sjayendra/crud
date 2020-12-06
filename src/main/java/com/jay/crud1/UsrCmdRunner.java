package com.jay.crud1;


import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import com.jay.crud1.User;
import com.jay.crud1.UserRepository;

@Component
public class UsrCmdRunner implements  CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(UsrCmdRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... arg0) throws Exception {
        log.info("Started running");
        User user = new User("Jack","Admin","one@ron");
        //User. = new User("Jack","Admin","jack@gmail.com");
        userRepository.save(user);

        List<User> users = userRepository.findAll();
        log.info("All Users : " + users);
    }
}
