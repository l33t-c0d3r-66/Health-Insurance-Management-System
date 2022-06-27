package com.health.insurance.DAO;

import com.health.insurance.beans.Hospital;

import java.util.List;

public interface HospitalDAO {
    boolean saveHospital(Hospital hospital);
    void updateHospital(Hospital hospital);
    Hospital getHospital(int id);
    List<Hospital> getHospitals();
    boolean removeHospital(Hospital hospital);
}
