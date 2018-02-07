package com.gyb.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gyb.ssm.domain.User;

public interface UserMapper {
    int insertUser(User user);
    User findUserById(Integer uid);
    User findUserByName(String userName);
    List<User> findAll();
    int countUser();
    List<User> findUsers(@Param("start")int start,@Param("count")int count);
}