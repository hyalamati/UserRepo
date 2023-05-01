package com.encodeURLApp.UserDataService.repository;

import com.encodeURLApp.UserDataService.exception.UserException;
import com.encodeURLApp.UserDataService.model.User;
import com.mongodb.client.result.DeleteResult;

import java.math.BigInteger;
import java.util.List;

public interface UserDAL {
    List<User> getAllUsers();
    User getUserById(BigInteger userId);
    User getUserByEmailId(String email);
    User addNewUser(User user) throws UserException;
    DeleteResult deleteUserByEmailId(String email);
}
