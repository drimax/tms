package com.tms.vehicle.dao;

import com.tms.vehicle.model.Vehicle;

import java.util.List;

/**
 * Created by hp on 8/7/2017.
 */
public interface IVehicleDAO {

    List<Vehicle> getAllVehicles();

    Vehicle getVehivleByNumber(String vehicleNum);

    List<String> getAllVehicleTypes();

    boolean saveVehicle(Vehicle vehicle);
}
