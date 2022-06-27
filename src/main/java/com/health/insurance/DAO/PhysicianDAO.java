package com.health.insurance.DAO;

import com.health.insurance.beans.Physician;

import java.util.List;

public interface PhysicianDAO {
    boolean savePhysician(Physician physician);
    void updatePhysician(Physician physician);
    boolean removePhysician(Physician physician);
    Physician getPhysician(int physicianId);
    List<Physician> getPhysicians();
}
