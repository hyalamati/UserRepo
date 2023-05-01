package com.encodeURLApp.UserDataService.repository;

import com.encodeURLApp.UserDataService.exception.UserException;
import com.encodeURLApp.UserDataService.model.User;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public class UserDALImpl implements UserDAL{
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUserById(BigInteger userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, User.class);
    }
    @Override
    public User getUserByEmailId(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query, User.class);
    }
    @Override
    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }
    @Override
    public User addNewUser(User user) throws ConstraintViolationException, UserException {
        User newUser= null;
        User existingUser = getUserByEmailId(user.getEmail());
        if(existingUser == null){
            newUser = new User();
            newUser.setUserName(user.getUserName());
            newUser.setEmail(user.getEmail());
            newUser = mongoTemplate.save(user);
            return newUser;
        }else{
            throw new UserException(UserException.userAlreadyExistsException(user.getEmail()));
            }
    }
    public DeleteResult deleteUserByEmailId(String email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.remove(query,User.class);
    }
}