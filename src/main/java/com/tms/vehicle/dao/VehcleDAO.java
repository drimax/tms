package com.tms.vehicle.dao;

import com.tms.vehicle.model.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hp on 8/7/2017.
 */

@Transactional
@Repository
public class VehcleDAO implements IVehicleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Vehicle> getAllVehicles() {
        String hql = "FROM  Vehicle as v ORDER BY v.vehicleId";
        return (List<Vehicle>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Vehicle getVehivleByNumber(String vehicleNum) {
        Vehicle vehicle = null;
        String hql = "FROM Vehicle as v WHERE v.vehcleRegNo = :vehicleNo";
        List<Vehicle> vehicles = entityManager.createQuery(hql).setParameter("vehicleNo", vehicleNum).getResultList();
        if(vehicles != null && vehicles.size() > 0){
            vehicle = vehicles.get(0);
        }

        return vehicle;
    }

    @Override
    public List<String> getAllVehicleTypes() {
        return null;
    }

    @Override
    public boolean saveVehicle(Vehicle vehicle) {
        Vehicle persistedVehicle = null;
        entityManager.persist(vehicle);
        persistedVehicle = getVehivleByNumber(vehicle.getVehcleRegNo());
        if(persistedVehicle != null){
            return  true;
        }
        return false;
    }
}
