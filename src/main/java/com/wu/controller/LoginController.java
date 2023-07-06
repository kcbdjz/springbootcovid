package com.wu.controller;

import com.wu.mapper.UserMapper;
import com.wu.pojo.User;
import com.wu.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wu.utils.MD5Util;

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

    @GetMapping("/selectById/{id}")
    public User findById(@PathVariable("id") Integer id){
        User user = userService.selectById(id);
//        user.setPassword(DigestUtils.digestAsHexString(user.getPassword()));
        user.setPassword(MD5Util.convertMD5(user.getPassword()));
        return user;
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")Long id){
        userService.deleteById(id);
    }

    @PostMapping("/update")
    public String update(@RequestBody User user){
        //密码加密存储
//        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setPassword(MD5Util.convertMD5(user.getPassword()));
        int result=userService.updateById(user);
        //密码加密
//        String password= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @PostMapping("/save")
    public String save(@RequestBody User user){
//        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        String result = userService.register(user);
            return result;
    }
}
