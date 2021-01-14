package com.kicinger.exploration.gradle.application.users;

import com.kicinger.exploration.gradle.contract.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Collections.emptyList;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @GetMapping
    public User getGradleMessage() {
        return new User("test", emptyList());
    }

}
