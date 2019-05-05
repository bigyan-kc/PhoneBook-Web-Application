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
import java.util.List;

public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage, noOfPages, noOfRows;
        int recordsPerPage=5;
        ContactDao contactDao = new ContactDaoImpl();

        if(request.getParameter("currentpage")==null){
            currentPage=1;
        }
        else {
            currentPage = Integer.parseInt(request.getParameter("currentpage"));
        }
        HttpSession session = request.getSession();

//        List<Contact> contacts = contactDao.findContacts(currentPage, recordsPerPage, (Integer)session.getAttribute("userId"));
        List<Contact> contacts = contactDao.findContacts(currentPage, recordsPerPage, (Integer)session.getAttribute("userId"));
        request.setAttribute("contacts", contacts);

        noOfRows = contactDao.getNumberOfRows((Integer)session.getAttribute("userId"));
        noOfPages = noOfRows/recordsPerPage;
        if(noOfRows%recordsPerPage>0)noOfPages++;

        request.setAttribute("noofpages", noOfPages);
        request.setAttribute("currentpage", currentPage);
        request.setAttribute("recordsperpage", recordsPerPage);
        request.getRequestDispatcher("WEB-INF/homepage.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);


    }
}
