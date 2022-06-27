package com.health.insurance.DAOImpl;

import com.health.insurance.DAO.UserDAO;
import com.health.insurance.beans.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean saveUser(User user) {
        try {
            Session hibernateSession = sessionFactory.openSession();
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
        try {
            Session session = sessionFactory.openSession();
            Query<User> query = session.createQuery("from User where userName='"+userName+"' and password='"+password+"'");
            User user = query.getSingleResult();
            return user;
        }catch(Exception e) {
            return null;
        }
    }


}
