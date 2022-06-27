package com.health.insurance.DAO;

import com.health.insurance.beans.InsuranceContract;

import java.util.List;

public interface InsuranceContractDAO {
    boolean saveInsuranceContract(InsuranceContract insuranceContract);
    void updateInsuranceContract(InsuranceContract insuranceContract);
    InsuranceContract getInsuranceContract(int insuranceContractId);
    List<InsuranceContract> getInsuranceContracts();
    boolean removeInsuranceContract(InsuranceContract insuranceContract);
}
