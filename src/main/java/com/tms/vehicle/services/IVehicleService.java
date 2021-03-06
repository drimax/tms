package com.tms.vehicle.services;

import com.tms.vehicle.dto.VehicleDTO;
import com.tms.vehicle.model.Vehicle;

import java.util.List;

/**
 * Created by hp on 8/7/2017.
 */
public interface IVehicleService {

    List<VehicleDTO> getAllVehicles();

    VehicleDTO getVehicleByNum(String vehicleNum);

    boolean saveVehicle(VehicleDTO vehicleDTO);

    boolean updateVehicle(VehicleDTO vehicleDTO);

    boolean deleteVehicle(VehicleDTO vehicleDTO);
}
