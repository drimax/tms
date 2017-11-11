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

    @RequestMapping(value = "/getAllVehicles", method = RequestMethod.GET)
    @ResponseBody
    public Response getAllVehicle() {
        Response<VehicleDTO> response = new Response();
        List<VehicleDTO> vehicles = vehicleService.getAllVehicles();
        response.setTableData(vehicles);
        response.setSuccess(true);
        return response;

    }
}
