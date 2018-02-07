package com.gyb.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyb.ssm.domain.Pagination;
import com.gyb.ssm.domain.User;
import com.gyb.ssm.mapper.UserMapper;
import com.gyb.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User findUserById(Integer uid) {
        return userMapper.findUserById(uid);
    }

    @Override
    public User findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int countUser() {
        return userMapper.countUser();
    }

    @Override
    public Pagination<User> findPage(int pageSize, int pageNumber) {
        Pagination<User> pagination = new Pagination<User>();
        pagination.setPageSize(pageSize);
        pagination.setCurrentPage(pageNumber);
        int countUser = userMapper.countUser();
        pagination.setTotalRows(countUser);
        pagination.setTotalPage((int)Math.ceil((float)countUser/pageSize));
        List<User> users = userMapper.findUsers((pageNumber-1)*pageSize, pageSize);
        pagination.setDatas(users);
        return pagination;
    }

   public UserMapper getUserMapper() {
        return userMapper;
    }
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
}
