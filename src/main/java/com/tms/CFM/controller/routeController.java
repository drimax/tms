package com.tms.CFM.controller;

import com.tms.common.dto.Response;
import com.tms.route.dto.RouteDTO;
import com.tms.route.services.IRouteService;
import com.tms.route.dto.RouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/11/2017.
 */

@Controller
@RequestMapping("/route")
public class routeController {

    @Autowired
    private IRouteService routeService;

    @RequestMapping(value = "/saveRoute", method = RequestMethod.POST)
    @ResponseBody
    public Response saveRoute(final RouteDTO routeDTO) {
        Response response = new Response();
        boolean saveSuccess = routeService.saveRoute(routeDTO);
        response.setSuccess(saveSuccess);
        return response;

    }

    @RequestMapping(value = "/getAllRoutes", method = RequestMethod.POST)
    @ResponseBody
    public Response getAllRoute(String routeName) {
        Response<RouteDTO> response = new Response();
        List<RouteDTO> routes = new ArrayList<>();
        if(routeName !=  null && routeName != ""){
            RouteDTO route = routeService.getRouteByName(routeName);
            if(route != null){
                routes.add(route);
            }
        } else {
            routes = routeService.getAllRoutes();
        }

        response.setTableData(routes);
        response.setSuccess(true);
        return response;

    }

    @RequestMapping(value = "/updateRoute", method = RequestMethod.POST)
    @ResponseBody
    public Response updateRoute(final RouteDTO routeDTO) {
        Response response = new Response();
        boolean saveSuccess = routeService.updateRoute(routeDTO);
        response.setSuccess(saveSuccess);
        return response;
    }

    @RequestMapping(value = "/deleteRoute", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteRoute(final RouteDTO routeDTO) {
        Response response = new Response();
        boolean saveSuccess = routeService.deleteRoute(routeDTO);
        response.setSuccess(saveSuccess);
        return response;
    }


}
