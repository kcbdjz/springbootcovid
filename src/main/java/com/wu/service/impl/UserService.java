package com.wu.service.impl;

import com.wu.pojo.User;

public interface UserService {
    String login(User loginform);

    String register(User reUser);
}
