package edu.nsu.exceptions;

public class UserAlreadyExistsException extends PhoneBookException {

    public UserAlreadyExistsException(String message, Exception ex){
        super(message, ex);
    }

    public UserAlreadyExistsException(){
        super();
    }
}
