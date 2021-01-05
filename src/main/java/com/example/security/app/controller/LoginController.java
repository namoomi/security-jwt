package com.example.security.app.controller;

import com.example.security.app.entity.User;
import com.example.security.app.service.UserService;
import com.example.security.role.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/init")
    public String init() {
        User user = new User("connie","connie.2@projectvanilla.kr","test1234", UserRole.USER);
        userService.createUser(user);
        return "redirect:/index";
    }

    @GetMapping ("/login/view")
    public String loginView() {
        return "login";
    }

}
