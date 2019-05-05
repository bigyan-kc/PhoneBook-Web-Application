package edu.nsu.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import edu.nsu.exceptions.PhoneBookException;
import edu.nsu.exceptions.UserAlreadyExistsException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
public class UserDaoImpl implements UserDao{




    @Override
    public boolean insertUser(User user) throws UserAlreadyExistsException{
        Session session = null;
        Transaction transaction = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();


            session.save(user);
            transaction.commit();
        }

        catch(Exception ex){
            transaction.rollback();
            ex.printStackTrace();
        }

        finally {
            session.close();
        }
        return true;
    }
}
