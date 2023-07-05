package com.wu.mapper;

import com.wu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    List<User> selectUser(String username);

    @Select("select count(*) from user where username=#{username}")
    Integer findUsername(String username);

    @Insert("INSERT into user values (null,#{username},#{password},#{depart},#{isAdministrator})")
    void insertUser(User reUser);
}
