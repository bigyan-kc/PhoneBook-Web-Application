package edu.nsu.model;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class LoginDaoImpl implements LoginDao {

    @Override
    public int authenticateUser(User user) {

        boolean status = false;
        int userId;
        Session session = null;
        try {
            List userList;
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM User WHERE email= :email and passwordHash= :password");
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getPasswordHash());
            userList = query.list();

            for(Iterator it = userList.iterator(); it.hasNext();){
                User checkUser = (User)it.next();
                return checkUser.getUserId();
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
        return -1;
    }
}