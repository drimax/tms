package com.tms.route.services;

import com.tms.route.dto.RouteDTO;

import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/10/2017.
 */
public interface IRouteService {

    RouteDTO getRouteByName(String routeNme);

    List<RouteDTO> getAllRoutes();

    boolean saveRoute(RouteDTO vehicleDTO);

    boolean updateRoute(RouteDTO routeDTO);

    boolean deleteRoute(RouteDTO routeDTO);


}
