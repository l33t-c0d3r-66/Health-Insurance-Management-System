package com.health.insurance.DAOImpl;

import com.health.insurance.DAO.InsuredPersonDAO;
import com.health.insurance.beans.InsuranceContract;
import com.health.insurance.beans.InsuredPerson;
import com.health.insurance.beans.Physician;
import com.health.insurance.util.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class InsuredPersonDAOImpl implements InsuredPersonDAO {
    @Override
    public boolean saveInsuredPerson(InsuredPerson insuredPerson) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.save(insuredPerson);
        hibernateTransaction.commit();
        hibernateSession.close();
        return false;
    }

    @Override
    public void updateInsuredPerson(InsuredPerson insuredPerson) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.update(insuredPerson);
        hibernateTransaction.commit();
        hibernateSession.close();
    }

    @Override
    public InsuredPerson getInsuredPerson(int insuredPersonId) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        InsuredPerson insuredPerson = hibernateSession.get(InsuredPerson.class,insuredPersonId);
        hibernateTransaction.commit();
        hibernateSession.close();
        return insuredPerson;
    }

    @Override
    public List<InsuredPerson> getInsuredPersons() {
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query<InsuredPerson> query = session.createQuery("from InsuredPerson");
        List<InsuredPerson> listOfInsuredPersons = query.list();
        return listOfInsuredPersons;
    }
}
