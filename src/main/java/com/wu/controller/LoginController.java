package com.wu.controller;

import com.wu.pojo.User;
import com.wu.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userlogin")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public String login(@RequestBody User loginform){
        String  message = userService.login(loginform);
        return message;
    }
    @PostMapping("/register")
    public String register(@RequestBody User reUser){
        String message=userService.register(reUser);
        return message;
    }
}
