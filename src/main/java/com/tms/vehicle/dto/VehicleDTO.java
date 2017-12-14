package com.tms.vehicle.dto;

import java.io.Serializable;

/**
 * Created by hp on 10/27/2017.
 */
public class VehicleDTO implements Serializable{

    private static final long serialVersionUID = 7526472295222276147L;

    private Integer id;
    private String vehcleRegNo;
    private String vehicleType;
    private long vehicleCapacity;
    private String vehicleFuelType;
    private String vehicleUser;
    private String vehicleChassisNo;
    private String vehicleEngineNo;
    private String vehicleModel;
    private long vehicleMilage;
    private String status;


    public Integer getId() {
        return id;
    }

    public String getVehcleRegNo() {
        return vehcleRegNo;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public long getVehicleCapacity() {
        return vehicleCapacity;
    }

    public String getVehicleFuelType() {
        return vehicleFuelType;
    }

    public String getVehicleUser() {
        return vehicleUser;
    }

    public String getVehicleChassisNo() {
        return vehicleChassisNo;
    }

    public String getVehicleEngineNo() {
        return vehicleEngineNo;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public long getVehicleMilage() {
        return vehicleMilage;
    }

    public String getStatus() { return status; }

    public void setVehcleRegNo(String vehcleRegNo) {
        this.vehcleRegNo = vehcleRegNo;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleCapacity(long vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public void setVehicleFuelType(String vehicleFuelType) {
        this.vehicleFuelType = vehicleFuelType;
    }

    public void setVehicleUser(String vehicleUser) {
        this.vehicleUser = vehicleUser;
    }

    public void setVehicleChassisNo(String vehicleChassisNo) {
        this.vehicleChassisNo = vehicleChassisNo;
    }

    public void setVehicleEngineNo(String vehicleEngineNo) {
        this.vehicleEngineNo = vehicleEngineNo;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setVehicleMilage(long vehicleMilage) {
        this.vehicleMilage = vehicleMilage;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
