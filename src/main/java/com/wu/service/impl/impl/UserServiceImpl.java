package com.wu.service.impl.impl;

import com.wu.mapper.UserMapper;
import com.wu.pojo.User;
import com.wu.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public String login(User loginform) {
        List<User> list= userMapper.listUser();
        if (list.size()!=0){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUsername().equals(loginform.getUsername())) {
                    if (list.get(i).getPassword().equals(loginform.getPassword())) {
                        return "success";
                    }
                }
            }
            return "error";
        }else return "error";
    }

    @Override
    public String register(User reUser) {

        List<User> list = userMapper.listUser();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(reUser.getUsername()))
                return "error";
        }
         userMapper.insertUser(reUser);
        return "success";
    }


}
