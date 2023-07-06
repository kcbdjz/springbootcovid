package com.wu.service.impl;

import com.wu.pojo.HealthCheckIn;
import com.wu.pojo.User;

public interface UserService {
    String login(User loginform);

    String register(User reUser);

    User selectById(Integer id);

    int updateById(User emp);

    void deleteById(long id);
}
