package com.tms.route.dao;

import com.tms.route.model.Route;
import com.tms.route.model.Route;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 12/10/2017.
 */

@Transactional
@Repository
public class RouteDAO implements IRouteDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Route> getAllRoutes() {
        String hql = "FROM  Route as r ORDER BY r.routeId";
        return (List<Route>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Route getRouteByName(String routeNme) {
        Route route = null;
        String hql = "FROM Route as r WHERE r.routeName = :routeNe";
        List<Route> routes = entityManager.createQuery(hql).setParameter("routeNe", routeNme).getResultList();
        if(route != null && routes.size() > 0 ) {
            route = routes.get(0);
        }

        return route;
    }

   // @Override
   // public List<String> getAllRouteOrigins() {
      //  return null;
   // }

   // @Override
    //public List<String> getAllRouteDestinations() {
      //  return null;
    //
    // }


    @Override
    public boolean saveRoute(Route route) {
        Route persistedRoute = null;
        entityManager.persist(route);
        persistedRoute = getRouteByName(route.getRouteName());
        if(persistedRoute != null){
            return  true;
        }
        return false;
    }

    @Override
    public Route getRouteById(Integer routeId) {
        Route route = entityManager.find(Route.class, routeId);
        return route;
    }

    @Override
    public boolean updateRoute(Route route) {
        Route persistedRoute = null;
        entityManager.merge(route);
        persistedRoute = getRouteByName(route.getRouteName());
        if(persistedRoute != null){
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteRoute(Route route) {
        try{
            entityManager.remove(route);
        }catch (Exception e){
            return false;
        }

        return true;
    }


}
