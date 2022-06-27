package com.health.insurance.DAOImpl;

import com.health.insurance.DAO.HospitalDAO;
import com.health.insurance.DAO.InsuranceContractDAO;
import com.health.insurance.beans.Hospital;
import com.health.insurance.beans.InsuranceContract;
import com.health.insurance.beans.Physician;
import com.health.insurance.util.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class InsuranceContractDAOImpl implements InsuranceContractDAO {


    @Override
    public boolean saveInsuranceContract(InsuranceContract insuranceContract) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.save(insuranceContract);
        hibernateTransaction.commit();
        hibernateSession.close();
        return false;
    }

    @Override
    public void updateInsuranceContract(InsuranceContract insuranceContract) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        hibernateSession.update(insuranceContract);
        hibernateTransaction.commit();
        hibernateSession.close();
    }

    @Override
    public InsuranceContract getInsuranceContract(int insuranceContractId) {
        SessionFactory factory = FactoryProvider.getSessionFactory();
        Session hibernateSession = factory.openSession();
        Transaction hibernateTransaction = hibernateSession.beginTransaction();
        InsuranceContract insuranceContract = hibernateSession.get(InsuranceContract.class,insuranceContractId);
        hibernateTransaction.commit();
        hibernateSession.close();
        return insuranceContract;
    }

    @Override
    public List<InsuranceContract> getInsuranceContracts() {
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query<InsuranceContract> query = session.createQuery("from InsuranceContract");
        List<InsuranceContract> listOfInsuraceContracts = query.list();
        return listOfInsuraceContracts;
    }
}
