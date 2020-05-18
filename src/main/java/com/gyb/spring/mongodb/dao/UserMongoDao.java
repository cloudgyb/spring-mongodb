package com.gyb.spring.mongodb.dao;

import com.gyb.spring.mongodb.domain.MongoUser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author geng
 * 2020/5/15
 */

@Repository
public class UserMongoDao extends AbstractMongodbDao<MongoUser> {

    public UserMongoDao(MongoTemplate mongoTemplate) {
        super(mongoTemplate);
    }

}
