package com.gyb.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gyb.ssm.domain.Pagination;
import com.gyb.ssm.domain.User;
import com.gyb.ssm.service.UserService;

@RestController
@RequestMapping("usermanage")
public class UserManage {
	@Autowired
	private UserService userService;

	@RequestMapping("userlist")
	public List<User> userList() {
		List<User> findAll = userService.findAll();
		return findAll;
	}
	
	@RequestMapping("userlist/{pageNumber}/{pageSize}")
	public Pagination<User> userListByPage(@PathVariable("pageNumber")int pageNumber,@PathVariable("pageSize")int pageSize) {
		
		Pagination<User> findPage = userService.findPage(pageSize, pageNumber);
		return findPage;
	}
}
