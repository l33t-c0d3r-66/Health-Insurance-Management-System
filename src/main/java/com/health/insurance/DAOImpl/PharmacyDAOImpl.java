package com.health.insurance.DAOImpl;

import com.health.insurance.DAO.PharmacyDAO;
import com.health.insurance.beans.Pharmacy;
import com.health.insurance.beans.Physician;
import com.health.insurance.util.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.query.Query;

import java.util.List;

public class PharmacyDAOImpl implements PharmacyDAO {
    @Override
    public boolean savePharmacy(Pharmacy pharmacy) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.save(pharmacy);
        hibernateTransaction.commit();
        hibernateSession.close();
        return false;
    }

    @Override
    public void updatePharmacy(Pharmacy pharmacy) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.update(pharmacy);
        hibernateTransaction.commit();
        hibernateSession.close();
    }

    @Override
    public boolean removePharmacy(Pharmacy pharmacy) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.delete(pharmacy);
        hibernateTransaction.commit();
        hibernateSession.close();
        return false;
    }

    @Override
    public Pharmacy getPharmacy(int pharmacyId) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        Pharmacy pharmacy = hibernateSession.get(Pharmacy.class, pharmacyId);
        hibernateTransaction.commit();
        hibernateSession.close();
        return pharmacy;
    }

    @Override
    public List<Pharmacy> getPharmacies() {
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query<Pharmacy> query = session.createQuery("from Pharmacy");
        List<Pharmacy> listOfPharmacies = query.list();
        return listOfPharmacies;
    }
}
