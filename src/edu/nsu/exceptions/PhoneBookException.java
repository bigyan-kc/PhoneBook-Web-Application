package edu.nsu.exceptions;

import java.sql.SQLException;

public class PhoneBookException extends Exception {

    public PhoneBookException(String message, Throwable cause){
        super(message, cause);
    }

    public PhoneBookException(String message){
        super(message);
    }

    public PhoneBookException(){
        super();
    }
}
