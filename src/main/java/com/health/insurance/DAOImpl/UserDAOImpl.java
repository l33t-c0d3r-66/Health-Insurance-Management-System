package com.health.insurance.DAOImpl;

import com.health.insurance.DAO.UserDAO;
import com.health.insurance.beans.User;
import com.health.insurance.util.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class UserDAOImpl implements UserDAO {
    @Override
    public boolean saveUser(User user) {
        try {
            SessionFactory factory = FactoryProvider.getSessionFactory();
            Session hibernateSession = factory.openSession();
            Transaction hibernateTransaction = hibernateSession.beginTransaction();
            hibernateSession.save(user);
            hibernateTransaction.commit();
            hibernateSession.close();
            return true;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public User getUser(String userName, String password) {
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query<User> query = session.createQuery("from User where userName='"+userName+"' and password='"+password+"'");
        if(query.getFetchSize() !=null && query.getFetchSize() > 0){
            User user = query.getSingleResult();
            return user;
        }
        else {
            return null;
        }
    }


}
