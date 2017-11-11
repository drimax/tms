package com.tms.vehicle.adaptor;

import com.tms.common.adaptor.BasicAdaptor;
import com.tms.vehicle.dto.VehicleDTO;
import com.tms.vehicle.model.Vehicle;

/**
 * Created by hp on 10/28/2017.
 */
public class VehicleAdaptor extends BasicAdaptor <Vehicle, VehicleDTO> {

    @Override
    public Vehicle toModel(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(dto.getId());
        vehicle.setVehicleUser(dto.getVehicleUser());
        vehicle.setVehicleType(dto.getVehicleType());
        vehicle.setVehicleEngineNo(dto.getVehicleEngineNo());
        vehicle.setVehicleModel(dto.getVehicleModel());
        vehicle.setVehcleRegNo(dto.getVehcleRegNo());
        vehicle.setVehicleCapacity(dto.getVehicleCapacity());
        vehicle.setVehicleChassNo(dto.getVehicleChassisNo());
        vehicle.setVehicleFuelType(getVehicleFuelType(dto.getVehicleFuelType()));
        vehicle.setVehicleMilage(dto.getVehicleMilage());
        vehicle.setStatus(dto.getStatus());

        return  vehicle;
    }

    @Override
    public VehicleDTO toDTO(Vehicle model) {
        VehicleDTO dto = new VehicleDTO();
        dto.setId(model.getVehicleId());
        dto.setVehcleRegNo(model.getVehcleRegNo());
        dto.setVehicleCapacity(model.getVehicleCapacity());
        dto.setVehicleChassisNo(model.getVehicleChassNo());
        dto.setVehicleFuelType(model.getVehicleFuelType());
        dto.setVehicleMilage(model.getVehicleMilage());
        dto.setVehicleModel(model.getVehicleModel());
        dto.setVehicleEngineNo(model.getVehicleEngineNo());
        dto.setVehicleType(model.getVehicleType());
        dto.setVehicleUser(model.getVehicleUser());
        dto.setStatus(model.getStatus());

        return  dto;
    }

    private String getVehicleFuelType(String fuelType){
        String fuelTypeDesc = "";
        switch (fuelType){
            case "P":
                fuelTypeDesc = "PETROL";
                break;
            case "H":
                fuelTypeDesc = "HYBRID";
                break;
            case "D":
                fuelTypeDesc = "DIESEL";
                break;
            case "E":
                fuelTypeDesc = "ELECTRICAL";
                break;
        }
        return fuelTypeDesc;
    }
}
