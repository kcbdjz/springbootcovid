package com.wu.controller;

import com.wu.mapper.UserMapper;
import com.wu.pojo.User;
import com.wu.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userlogin")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @PostMapping("/user")
    public User login(@RequestBody User loginform) {
//        System.err.println("-------------------------------------------------------------");
        String message = userService.login(loginform);
//        System.out.println(message);

        if ("success".equals(message)) {
//            Map<String,Object> map = new HashMap<>();
//            map.put("username",loginform.getUsername());
            List<User> users = userMapper.selectUser(loginform.getUsername());
            return users.get(0);
        } else {
            return new User();
        }
    }
    @PostMapping("/register")
    public String register(@RequestBody User reUser){
        String message=userService.register(reUser);
        return message;
    }
}
