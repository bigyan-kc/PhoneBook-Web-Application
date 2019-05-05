package edu.nsu.model;

import java.util.List;

public interface ContactDao {
    List<Contact> findContacts(int pageNumber, int recordsPerPage, int userId);
    boolean addContact(Contact contact);
    boolean deleteContact(int contactId);
    int getNumberOfRows(int userId);
    Contact getContact(int contactId);
    boolean editContact(Contact contact);
}
