package com.tms.route.adaptor;

import com.tms.common.adaptor.BasicAdaptor;
import com.tms.route.dto.RouteDTO;
import com.tms.route.model.Route;

/**
 * Created by RAVI KALUARACHCHI on 12/10/2017.
 */
public class RouteAdaptor extends BasicAdaptor <Route, RouteDTO> {

    @Override
    public Route toModel(RouteDTO dto) {
        Route route = new Route();
        route.setRouteId(dto.getRouteId());
        route.setRouteName(dto.getRouteName());
        route.setRouteOrigin(dto.getRouteOrigin());
        route.setRouteDestination(dto.getRouteDestination());
        route.setRouteDistance(dto.getRouteDistance());
        route.setRouteDuration(dto.getRouteDuration());
        route.setRouteStatus(dto.getRouteStatus());
        return  route;
    }



    @Override
    public RouteDTO toDTO (Route model) {
        RouteDTO dto = new RouteDTO();

        dto.setRouteId(model.getRouteId());
        dto.setRouteName(model.getRouteName());
        dto.setRouteOrigin(model.getRouteOrigin());
        dto.setRouteDestination(model.getRouteDestination());
        dto.setRouteDistance(model.getRouteDistance());
        dto.setRouteDuration(model.getRouteDuration());
        dto.setRouteStatus(model.getRouteStatus());
        return  dto;

    }
}
