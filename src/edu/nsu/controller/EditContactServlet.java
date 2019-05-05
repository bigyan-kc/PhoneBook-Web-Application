package edu.nsu.controller;

import edu.nsu.model.Contact;
import edu.nsu.model.ContactDao;
import edu.nsu.model.ContactDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class EditContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Contact contact = new Contact();
        ContactDao contactDao = new ContactDaoImpl();

        HttpSession session  = request.getSession();

        contact.setUserId((Integer)session.getAttribute("userId"));
        contact.setContactId(Integer.parseInt(request.getParameter("contactid")));
        contact.setFirstName(request.getParameter("firstname"));
        contact.setLastName(request.getParameter("lastname"));
        contact.setPhone(request.getParameter("phone"));
        contact.setEmail(request.getParameter("email"));
        contactDao.editContact(contact);


        request.getRequestDispatcher("home").forward(request, response);





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get contactId from URL
        int contact_id = Integer.parseInt(request.getParameter("contact_id"));

        ContactDao contactDao = new ContactDaoImpl();
        Contact contact = contactDao.getContact(contact_id);

        request.setAttribute("contact", contact);
        request.getRequestDispatcher("WEB-INF/editcontact.jsp").forward(request, response);
    }
}
