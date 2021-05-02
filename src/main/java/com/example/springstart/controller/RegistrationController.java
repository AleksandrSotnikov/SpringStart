package com.example.springstart.controller;

import com.example.springstart.domain.Role;
import com.example.springstart.domain.User;
import com.example.springstart.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepositories userRepositories;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String AddUser(User user, Map<String, Object> model) {
        User userFromDb = userRepositories.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.put("message", "User exist!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepositories.save(user);
        return "redirect:/login";
    }
}
