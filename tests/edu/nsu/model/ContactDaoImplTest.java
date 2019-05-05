package edu.nsu.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactDaoImplTest {
    ContactDao contactDao;

    @Before
    public void setUp(){

        contactDao = new ContactDaoImpl();

    }
    @Test
    public void addContact() {
        Contact contact = new Contact();
        contact.setUserId(6);
        contact.setFirstName("test");
        contact.setLastName("test");
        contact.setEmail("test@nsu.edu");
        contact.setPhone("999999");
        assertEquals(true, contactDao.addContact(contact));

    }

    @Test
    public void deleteContact() {
        int contactId = 43;
        assertEquals(true, contactDao.deleteContact(contactId));
    }

    @Test
    public void findContacts() {

    }

    @Test
    public void getNumberOfRows() {
    }

    @Test
    public void getContact() {
    }

    @Test
    public void editContact() {
    }
}