package com.gyb.spring.mongodb.dao;

import com.gyb.spring.mongodb.domain.Pagination;
import com.mongodb.client.result.DeleteResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * @author geng
 * 2020/5/15
 */
public abstract class AbstractMongodbDao<T> {
    protected final MongoTemplate mongoTemplate;
    private Class<T> entityClass;

    public AbstractMongodbDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType paraType = (ParameterizedType) genericSuperclass;
            Type[] params = paraType.getActualTypeArguments();
            if(params[0] instanceof Class) {
                entityClass = (Class<T>) params[0];
            }
        }
    }

    public void add(T entity){
        mongoTemplate.insert(entity);
    }

    public void add(Collection<T> coll){
        mongoTemplate.insertAll(coll);
    }

    public List<T> find(Query query){
        if(query == null)
            return findAll();
        return mongoTemplate.find(query, entityClass);
    }

    /**
     * 按照field字段进行查找
     * @param field 对应数据库中的字段名
     * @param value 属性值
     */
    public List<T> find(String field,String value){
        Criteria criteria = new Criteria();
        criteria.and(field).is(value);
        Query query = new Query(criteria);
        return find(query);
    }

    public Pagination<T> findPage(Query query, int pageNum, int pageSize){
        if(query == null)
            query = new Query();
        long total = count(query);
        query.skip((pageNum-1)*pageSize).limit(pageSize);
        List<T> data = find(query);
        return Pagination.of(pageNum,pageSize,total,data);
    }

    public List<T> findAll(){
        return mongoTemplate.findAll(entityClass);
    }

    public long count(Query query){
        if(query == null){
            query = new Query();
        }
        return mongoTemplate.count(query,entityClass);
    }

    public long remove(Query query){
        DeleteResult result = mongoTemplate.remove(query, entityClass);
        return result.getDeletedCount();
    }

}
