package com.example.security.app.controller;

import com.example.security.app.entity.User;
import com.example.security.app.service.UserService;
import com.example.security.role.UserRole;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final UserService userService;
    @NonNull
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/init")
    public String init() {
        String pw = passwordEncoder.encode("test");

        User user = new User("connie","connie.2@pv.kr",pw, UserRole.USER);
        userService.createUser(user);

        User admin = new User("admin","admin@pv.kr", pw, UserRole.ADMIN);
        userService.createUser(admin);

        return "redirect:/about";
    }

    @GetMapping ("/login/view")
    public String loginView() {
        return "login";
    }

}
