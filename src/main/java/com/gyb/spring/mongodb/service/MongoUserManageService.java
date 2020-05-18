package com.gyb.spring.mongodb.service;

import com.gyb.spring.mongodb.dao.UserMongoDao;
import com.gyb.spring.mongodb.domain.MongoUser;
import com.gyb.spring.mongodb.domain.Pagination;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author geng
 * 2020/5/18
 */
@Service
public class MongoUserManageService {
    private final UserMongoDao userMongoDao;

    public MongoUserManageService(UserMongoDao userMongoDao) {
        this.userMongoDao = userMongoDao;
    }

    public List<MongoUser> getAll(){
        return userMongoDao.findAll();
    }

    public List<MongoUser> getByUserName(String userName){
        return userMongoDao.find("name",userName);
    }

    public Pagination<MongoUser> page(int pageNum,int pageSize){
        return userMongoDao.findPage(null,pageNum,pageSize);
    }

    public void addUser(MongoUser user){
        userMongoDao.add(user);
    }

    public long deleteUser(String id){
        Criteria id1 = Criteria.where("id").is(id);
        Query query = new Query(id1);
        return userMongoDao.remove(query);
    }
}
