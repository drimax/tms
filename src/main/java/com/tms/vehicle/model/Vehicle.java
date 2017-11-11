package com.tms.vehicle.model;

import com.tms.common.model.Track;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hp on 8/7/2017.
 */

@Entity
@Table(name="t_vehicle")
public class Vehicle extends Track{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="vehicle_id")
    private Integer vehicleId;
    @Column(name="vehicle_no")
    private String vehcleRegNo;
    @Column(name="vehicle_type")
    private String vehicleType;
    @Column(name="vehicle_capacity")
    private long vehicleCapacity;
    @Column(name="vehicle_fuel_type")
    private String vehicleFuelType;
    @Column(name="vehicle_user")
    private String vehicleUser;
    @Column(name="vehicle_chassis_no")
    private String vehicleChassNo;
    @Column(name="vehicle_engine_no")
    private String vehicleEngineNo;
    @Column(name="vehicle_model")
    private String vehicleModel;
    @Column(name="vehicle_mileage")
    private long vehicleMilage;
    @Column(name="vehicle_status")
    private String status;

    public void setVehicleMilage(long vehicleMilage) {
        this.vehicleMilage = vehicleMilage;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehcleRegNo(String vehcleRegNo) {
        this.vehcleRegNo = vehcleRegNo;
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

    public void setVehicleChassNo(String vehicleChassNo) {
        this.vehicleChassNo = vehicleChassNo;
    }

    public void setVehicleEngineNo(String vehicleEngineNo) {
        this.vehicleEngineNo = vehicleEngineNo;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehcleRegNo() {
        return vehcleRegNo;
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

    public String getVehicleChassNo() {
        return vehicleChassNo;
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

    public String getStatus() {
        return status;
    }
}
