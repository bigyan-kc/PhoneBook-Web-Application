package edu.nsu.controller;

import edu.nsu.model.LoginDao;
import edu.nsu.model.LoginDaoImpl;
import edu.nsu.util.PasswordHash;
import edu.nsu.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    String email;
    String passwordHash;
    User user = new User();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession();

        email=request.getParameter("email");
        passwordHash = PasswordHash.findHash(request.getParameter("pwd"));

        user.setEmail(email);
        user.setPasswordHash(passwordHash);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        LoginDao loginDao = new LoginDaoImpl();

        int userId = loginDao.authenticateUser(user);

        if(userId > 0) {
            session.setAttribute("userId", userId);
            RequestDispatcher rd = request.getRequestDispatcher("home");
            rd.forward(request, response);
        }

        else{
            out.print("<html><h1>"+ "Not Authenticated" + "</h1></html>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
