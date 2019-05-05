package edu.nsu.controller;

import edu.nsu.model.ContactDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
        int contactId= Integer.parseInt(request.getParameter("contact_id"));

//        contactDaoImpl.deleteContact(contactId);
        contactDaoImpl.deleteContact(contactId);
        request.getRequestDispatcher("home").forward(request, response);

    }
}
