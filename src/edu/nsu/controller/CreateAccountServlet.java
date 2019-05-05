package edu.nsu.controller;

import edu.nsu.exceptions.UserAlreadyExistsException;
import edu.nsu.util.PasswordHash;
import edu.nsu.model.User;
import edu.nsu.model.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPasswordHash(PasswordHash.findHash(request.getParameter("pwd")));

        UserDaoImpl userDaoImpl = new UserDaoImpl();
        try {
            userDaoImpl.insertUser(user);
        }
        catch(UserAlreadyExistsException ex){
            response.getWriter().print("User Already Exists, Try Another username");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
