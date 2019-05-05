package edu.nsu.model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ContactDaoImpl implements ContactDao {



    @Override
    public boolean addContact(Contact contact){
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction= session.beginTransaction();

            session.save(contact);
            transaction.commit();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean deleteContact(int contactId){
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Contact contact = (Contact)session.get(Contact.class, contactId);
            session.delete(contact);
            transaction.commit();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return true;
    }


    @Override
    public List<Contact> findContacts(int pageNumber, int recordsPerPage, int userId){
        int start = pageNumber * recordsPerPage - recordsPerPage;
        List<Contact> contacts = new ArrayList<>();
        Session session = null;
        Transaction transaction = null;
        try{
            List results;
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Contact c where userId = :userId ORDER BY c.firstName");
            query.setParameter("userId", userId);
            query.setFirstResult(start);
            query.setMaxResults(recordsPerPage);

            results = query.list();


            for(Iterator it = results.iterator(); it.hasNext();){
                Contact contact = (Contact)it.next();
                contacts.add(contact);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return contacts;
    }

    @Override
    public int getNumberOfRows(int userId){
        Session session = null;
        int noRows = 0;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Contact WHERE userId= :userId");
            query.setParameter("userId", userId);
            noRows = query.list().size();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return noRows;
    }

    @Override
    public Contact getContact(int contactId){
        Session session = null;
        Contact contact = new Contact();

        try{
            List results;
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Contact WHERE contactId= :contactId");
            results = query.setParameter("contactId", contactId).list();

            for(Iterator it = results.iterator(); it.hasNext();){
                contact = (Contact)it.next();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return contact;
    }

    @Override
    public boolean editContact(Contact contact){
        Session session = null;
        Transaction transaction = null;


        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(contact);
            transaction.commit();
        }
        catch(Exception ex){
            transaction.rollback();
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
        }
        return true;
    }
}
