package com.tms.vehicle.services;

import com.tms.common.model.Track;
import com.tms.vehicle.adaptor.VehicleAdaptor;
import com.tms.vehicle.dao.IVehicleDAO;
import com.tms.vehicle.dto.VehicleDTO;
import com.tms.vehicle.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hp on 8/7/2017.
 */

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleDAO vehicleDAO;

    @Override
    public List<VehicleDTO> getAllVehicles() {
        VehicleAdaptor adaptor = new VehicleAdaptor();
        List<VehicleDTO> dtoList = new ArrayList<>();
        List<Vehicle> vehicleList = vehicleDAO.getAllVehicles();
        if(vehicleList != null & !vehicleList.isEmpty()){
            for(Vehicle vehicle : vehicleList){
                dtoList.add(adaptor.toDTO(vehicle));
            }
        }
        return dtoList;
    }

    @Override
    public VehicleDTO getVehicleByNum(String vehicleNum) {
        VehicleAdaptor adaptor = new VehicleAdaptor();
        Vehicle vehicle = vehicleDAO.getVehivleByNumber(vehicleNum);
        if(vehicle != null){
            return adaptor.toDTO(vehicle);
        } else {
            return null;
        }
    }

    @Override
    public boolean saveVehicle(VehicleDTO vehicleDTO) {
        VehicleAdaptor adaptor = new VehicleAdaptor();
        Vehicle vehicle = adaptor.toModel(vehicleDTO);
        vehicle.setCreatedTime(new Date());
        vehicle.setModifiedTime(new Date());
        vehicle.setVersion(0);
        return vehicleDAO.saveVehicle(vehicle);
    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) {
        VehicleAdaptor adaptor = new VehicleAdaptor();
        Vehicle vehicle = adaptor.toModel(vehicleDTO);
        Vehicle existingVehicle = vehicleDAO.getVehivleById(vehicle.getVehicleId());
        if(existingVehicle != null){
            existingVehicle.setModifiedTime(new Date());
            existingVehicle.setVersion(existingVehicle.getVersion()+1);
            existingVehicle.setVehicleUser(vehicle.getVehicleUser());
            existingVehicle.setVehicleMilage(vehicle.getVehicleMilage());
            existingVehicle.setStatus(vehicle.getStatus());
            return vehicleDAO.updateVehicle(existingVehicle);
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteVehicle(VehicleDTO vehicleDTO) {
        VehicleAdaptor adaptor = new VehicleAdaptor();
        Vehicle vehicle = adaptor.toModel(vehicleDTO);
        Vehicle existingVehicle = vehicleDAO.getVehivleById(vehicle.getVehicleId());
        if(existingVehicle != null){
            return vehicleDAO.deleteVehicle(existingVehicle);
        } else {
            return false;
        }
    }


}
