package com.tms.CFM.controller;

import com.tms.common.dto.Response;
import com.tms.vehicle.dto.VehicleDTO;
import com.tms.vehicle.model.Vehicle;
import com.tms.vehicle.services.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hp on 10/27/2017.
 */

@Controller
@RequestMapping("/vehicle")
public class vehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @RequestMapping(value = "/saveVehicle", method = RequestMethod.POST)
    @ResponseBody
    public Response saveVehicle(final VehicleDTO vehicleDTO) {
        Response response = new Response();
        boolean saveSuccess = vehicleService.saveVehicle(vehicleDTO);
        response.setSuccess(saveSuccess);
        return response;

    }

    @RequestMapping(value = "/getAllVehicles", method = RequestMethod.POST)
    @ResponseBody
    public Response getAllVehicle(String vehicleRegNo) {
        Response<VehicleDTO> response = new Response();
        List<VehicleDTO> vehicles = new ArrayList<>();
        if(vehicleRegNo !=  null && vehicleRegNo != ""){
            VehicleDTO vehicle = vehicleService.getVehicleByNum(vehicleRegNo);
            if(vehicle != null){
                vehicles.add(vehicle);
            }
        } else {
            vehicles = vehicleService.getAllVehicles();
        }

        response.setTableData(vehicles);
        response.setSuccess(true);
        return response;

    }

    @RequestMapping(value = "/updateVehicle", method = RequestMethod.POST)
    @ResponseBody
    public Response updateVehicle(final VehicleDTO vehicleDTO) {
        Response response = new Response();
        boolean saveSuccess = vehicleService.updateVehicle(vehicleDTO);
        response.setSuccess(saveSuccess);
        return response;
    }

    @RequestMapping(value = "/deleteVehicle", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteVehicle(final VehicleDTO vehicleDTO) {
        Response response = new Response();
        boolean saveSuccess = vehicleService.deleteVehicle(vehicleDTO);
        response.setSuccess(saveSuccess);
        return response;
    }
}
