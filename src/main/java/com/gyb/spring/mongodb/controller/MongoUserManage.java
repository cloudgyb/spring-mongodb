package com.gyb.spring.mongodb.controller;

import com.gyb.spring.mongodb.dao.UserMongoDao;
import com.gyb.spring.mongodb.domain.MongoUser;
import com.gyb.spring.mongodb.domain.Pagination;
import com.gyb.spring.mongodb.service.MongoUserManageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongoUser")
public class MongoUserManage {
	private final MongoUserManageService mongoUserManageService;

	public MongoUserManage(MongoUserManageService mongoUserManageService) {
		this.mongoUserManageService = mongoUserManageService;
	}

	@RequestMapping("/list")
	public List<MongoUser> userList() {
		return mongoUserManageService.getAll();
	}
	@RequestMapping("/query")
	public List<MongoUser> userList(@RequestParam String userName) {
		return mongoUserManageService.getByUserName(userName);
	}

	@RequestMapping("/page")
	public Pagination<MongoUser> userList(@RequestParam(defaultValue = "1") int pageNum,
										  @RequestParam(defaultValue = "10") int pageSize){
		return mongoUserManageService.page(pageNum,pageSize);
	}

	@PostMapping("/add")
	public void add(@RequestBody MongoUser user){
		mongoUserManageService.addUser(user);
	}

	@DeleteMapping("/delete")
	public void delete(String id){
		long l = mongoUserManageService.deleteUser(id);
		System.out.println(l);
	}

}
