package com.health.insurance.DAO;

import com.health.insurance.beans.InsuredPerson;

import java.util.List;

public interface InsuredPersonDAO {
    boolean saveInsuredPerson(InsuredPerson insuredPerson);
    void updateInsuredPerson(InsuredPerson insuredPerson);
    InsuredPerson getInsuredPerson(int insuredPersonId);
    List<InsuredPerson> getInsuredPersons();
    boolean removeInsuredPerson(InsuredPerson person);
}
