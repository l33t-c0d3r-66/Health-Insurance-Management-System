package com.health.insurance.DAOImpl;

import com.health.insurance.DAO.PhysicianDAO;
import com.health.insurance.beans.Pharmacy;
import com.health.insurance.beans.Physician;
import com.health.insurance.util.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PhysicianDAOImpl implements PhysicianDAO {
    @Override
    public boolean savePhysician(Physician physician) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.save(physician);
        hibernateTransaction.commit();
        hibernateSession.close();
        return false;
    }

    @Override
    public void updatePhysician(Physician physician) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.update(physician);
        hibernateTransaction.commit();
        hibernateSession.close();
    }

    @Override
    public boolean removePhysician(Physician physician) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.delete(physician);
        hibernateTransaction.commit();
        hibernateSession.close();
        return false;
    }

    @Override
    public Physician getPhysician(int physicianId) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        Physician physician = hibernateSession.get(Physician.class, physicianId);
        hibernateTransaction.commit();
        hibernateSession.close();
        return physician;
    }

    @Override
    public List<Physician> getPhysicians() {
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query<Physician> query = session.createQuery("from Physician");
        List<Physician> listOfPhysicians = query.list();
        return listOfPhysicians;
    }
}
