package com.tms.route.dao;

import com.tms.route.model.Route;

import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/10/2017.
 */
public interface IRouteDAO {

    List<Route> getAllRoutes() ;

    Route getRouteByName(String routeNme);

    boolean saveRoute(Route route);

    Route getRouteById(Integer routeId);

    boolean updateRoute(Route route);

    boolean deleteRoute(Route route);



}
