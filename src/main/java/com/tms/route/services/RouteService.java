package com.tms.route.services;

import com.tms.route.dao.IRouteDAO;
import com.tms.route.model.Route;
import com.tms.route.adaptor.RouteAdaptor;
import com.tms.route.dto.RouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/10/2017.
 */

@Service
public class RouteService implements IRouteService {

    @Autowired
    private IRouteDAO routeDAO;

    @Override
    public List<RouteDTO> getAllRoutes() {
        RouteAdaptor adaptor = new RouteAdaptor();
        List<RouteDTO> dtoList = new ArrayList<>();
        List<Route> routeList = routeDAO.getAllRoutes();
        if(routeList != null & !routeList.isEmpty()){
            for(Route route : routeList){
                dtoList.add(adaptor.toDTO(route));
            }
        }
        return dtoList;
    }

    @Override
    public RouteDTO getRouteByName(String routeNme) {
        RouteAdaptor adaptor = new RouteAdaptor();
        Route route = routeDAO.getRouteByName(routeNme);
        if(route != null){
            return adaptor.toDTO(route);
        } else {
            return null;
        }
    }



    @Override
    public boolean saveRoute(RouteDTO routeDTO) {
        RouteAdaptor adaptor = new RouteAdaptor();
        Route route = adaptor.toModel(routeDTO);
        return routeDAO.saveRoute(route);
    }


    @Override
    public boolean updateRoute(RouteDTO routeDTO) {
        RouteAdaptor adaptor = new RouteAdaptor();
        Route route = adaptor.toModel(routeDTO);
        Route existingRoute = routeDAO.getRouteById(route.getRouteId());
        if(existingRoute != null){
            existingRoute.setRouteOrigin(route.getRouteOrigin());
            existingRoute.setRouteDestination(route.getRouteDestination());
            existingRoute.setRouteStatus(route.getRouteStatus());
            return routeDAO.updateRoute(existingRoute);
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteRoute(RouteDTO routeDTO) {
        RouteAdaptor adaptor = new RouteAdaptor();
        Route route = adaptor.toModel(routeDTO);
        Route existingRoute = routeDAO.getRouteById(route.getRouteId());
        if(existingRoute != null){
            return routeDAO.deleteRoute(existingRoute);
        } else {
            return false;
        }
    }

}
