package edu.nsu.controller;

import edu.nsu.model.Contact;
import edu.nsu.model.ContactDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Contact contact = new Contact();
        ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
        HttpSession session = request.getSession();

        contact.setUserId((Integer)session.getAttribute("userId"));
        contact.setFirstName(request.getParameter("firstName"));
        contact.setLastName(request.getParameter("lastName"));
        contact.setPhone(request.getParameter("phone"));
        contact.setEmail(request.getParameter("email"));

//        contactDaoImpl.addContact(contact);
        contactDaoImpl.addContact(contact);
        request.getRequestDispatcher("home").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/addcontact.jsp").forward(request, response);
    }
}
