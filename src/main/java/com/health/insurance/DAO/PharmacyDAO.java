package com.health.insurance.DAO;

import com.health.insurance.beans.Pharmacy;

import java.util.List;

public interface PharmacyDAO {
    boolean savePharmacy(Pharmacy pharmacy);
    void updatePharmacy(Pharmacy pharmacy);
    boolean removePharmacy(Pharmacy pharmacy);
    Pharmacy getPharmacy(int pharmacyId);
    List<Pharmacy> getPharmacies();
}
