package com.encodeURLApp.UserDataService.repository;

import com.encodeURLApp.UserDataService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, BigInteger> {
}
