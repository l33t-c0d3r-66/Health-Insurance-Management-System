package com.health.insurance.DAOImpl;

import com.health.insurance.DAO.HospitalDAO;
import com.health.insurance.beans.Hospital;
import com.health.insurance.util.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HospitalDAOImpl implements HospitalDAO {

    @Override
    public boolean saveHospital(Hospital hospital) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        int id = (int) hibernateSession.save(hospital);
        hibernateTransaction.commit();
        hibernateSession.close();
        System.out.println(id>0);
        return id>0;
    }

    @Override
    public void updateHospital(Hospital hospital) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.update(hospital);
        hibernateTransaction.commit();
        hibernateSession.close();
    }

    @Override
    public Hospital getHospital(int id) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        Hospital hospital = hibernateSession.get(Hospital.class, id);
        hibernateTransaction.commit();
        hibernateSession.close();
        return hospital;
    }

    @Override
    public List<Hospital> getHospitals() {
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query<Hospital> query = session.createQuery("from Hospital");
        List<Hospital> listOfHospitals = query.list();
        return listOfHospitals;
    }

    @Override
    public boolean removeHospital(Hospital hospital) {
        try {
            SessionFactory factory = FactoryProvider.getSessionFactory();
            Session hibernateSession = factory.openSession();
            Transaction hibernateTransaction = hibernateSession.beginTransaction();
            hibernateSession.delete(hospital);
            hibernateTransaction.commit();
            hibernateSession.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;

    }
}
