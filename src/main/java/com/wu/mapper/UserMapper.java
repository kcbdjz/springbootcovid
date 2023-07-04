package com.wu.mapper;

import com.wu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> listUser();

    @Insert("INSERT into user(username , password , depart) values (#{username},#{password},#{depart})")
    void insertUser(User reUser);
}
