package com.encodeURLApp.UserDataService.exception;

public class UserException extends Exception {
    private static final long serialVersionUID = 1L ;
    public UserException(String message) {
        super(message);
    }
    public static String userDataNotFoundException(){
            return "No User Data Found";
    }
    public static String userAlreadyExistsException(String email){
        return "User with "+email+" already exists";
    }
}
