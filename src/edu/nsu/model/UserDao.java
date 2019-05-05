package edu.nsu.model;


import edu.nsu.exceptions.UserAlreadyExistsException;

public interface UserDao {

    boolean insertUser(User user) throws UserAlreadyExistsException;
}
