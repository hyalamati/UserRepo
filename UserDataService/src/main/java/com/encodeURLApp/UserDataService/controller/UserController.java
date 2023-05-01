package com.encodeURLApp.UserDataService.controller;

import com.encodeURLApp.UserDataService.exception.UserException;
import com.encodeURLApp.UserDataService.model.User;
import com.encodeURLApp.UserDataService.repository.UserDAL;
import com.encodeURLApp.UserDataService.repository.UserRepository;
import com.mongodb.client.result.DeleteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDAL userDAL;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> addNewUsers(@RequestBody User user) throws UserException {
        LOG.info("Saving user..");
        try{
            userDAL.addNewUser(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch(ConstraintViolationException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (UserException userException){
            return new ResponseEntity<>(userException.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        List<User> usersList = userRepository.findAll();
        if(usersList.size() > 0){
            LOG.info("Getting all users..");
            return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No Users Found", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value ="/findone", method = RequestMethod.POST)
    public ResponseEntity<?>  findUserByEmail( @RequestBody User user){
        User foundUser = userDAL.getUserByEmailId(user.getEmail());
        if(foundUser!=null){
           return new ResponseEntity<User>(foundUser, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No Users Found", HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public DeleteResult deleteUserByEmail(@RequestBody User user){
        LOG.info("Deleting the user..");
        return userDAL.deleteUserByEmailId(user.getEmail());
    }
}

