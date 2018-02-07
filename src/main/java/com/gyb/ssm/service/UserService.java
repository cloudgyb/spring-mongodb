package com.gyb.ssm.service;

import java.util.List;

import com.gyb.ssm.domain.Pagination;
import com.gyb.ssm.domain.User;

public interface UserService {
    int addUser(User user);
    User findUserById(Integer uid);
    User findUserByName(String userName);
    List<User> findAll();
    int countUser();
    Pagination<User> findPage(int pageSize,int pageNumber);
}
