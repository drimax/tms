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
    public Vehicle getVehicleByNum(String vehicleNum) {
        return vehicleDAO.getVehivleByNumber(vehicleNum);
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


}
