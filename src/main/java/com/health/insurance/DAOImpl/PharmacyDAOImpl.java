package com.health.insurance.DAOImpl;

import com.health.insurance.DAO.PharmacyDAO;
import com.health.insurance.beans.Pharmacy;
import com.health.insurance.util.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PharmacyDAOImpl implements PharmacyDAO {
    @Override
    public boolean savePharmacy(Pharmacy pharmacy) {
        try {
            SessionFactory factory = FactoryProvider.getSessionFactory();
            Session hibernateSession = factory.openSession();
            Transaction hibernateTransaction = hibernateSession.beginTransaction();
            hibernateSession.save(pharmacy);
            hibernateTransaction.commit();
            hibernateSession.close();
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void updatePharmacy(Pharmacy pharmacy) {
        try {
            SessionFactory factory = FactoryProvider.getSessionFactory();
            Session hibernateSession = factory.openSession();
            Transaction hibernateTransaction = hibernateSession.beginTransaction();
            hibernateSession.update(pharmacy);
            hibernateTransaction.commit();
            hibernateSession.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean removePharmacy(Pharmacy pharmacy) {
        try {
            SessionFactory factory = FactoryProvider.getSessionFactory();
            Session hibernateSession = factory.openSession();
            Transaction hibernateTransaction = hibernateSession.beginTransaction();
            hibernateSession.delete(pharmacy);
            hibernateTransaction.commit();
            hibernateSession.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Pharmacy getPharmacy(int pharmacyId) {
        try {
            SessionFactory factory = FactoryProvider.getSessionFactory();
            Session hibernateSession = factory.openSession();
            Transaction hibernateTransaction = hibernateSession.beginTransaction();
            Pharmacy pharmacy = hibernateSession.get(Pharmacy.class, pharmacyId);
            hibernateTransaction.commit();
            hibernateSession.close();
            return pharmacy;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pharmacy> getPharmacies() {
        try {
            Session session = FactoryProvider.getSessionFactory().openSession();
            Query<Pharmacy> query = session.createQuery("from Pharmacy");
            List<Pharmacy> listOfPharmacies = query.list();
            return listOfPharmacies;
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
