package com.tms.route.dto;

import java.io.Serializable;

/**
 * Created by RAVI KALUARACHCHI on 11/29/2017.
 */
public class RouteDTO implements Serializable {

    private static final long serialVersionUID = 7526472295222276149L;

    private Integer routeId;
    private String routeName;
    private String routeOrigin;
    private String routeDestination;
    private Integer routeDistance;

    public static long getSerialVersionUID() { return serialVersionUID; }

    public Integer getRouteId() { return routeId; }

    public void setRouteId(Integer routeId) { this.routeId = routeId; }

    public String getRouteName() { return routeName; }

    public void setRouteName(String routeName) { this.routeName = routeName; }

    public String getRouteOrigin() { return routeOrigin; }

    public void setRouteOrigin(String routeOrigin) { this.routeOrigin = routeOrigin; }

    public String getRouteDestination() { return routeDestination; }

    public void setRouteDestination(String routeDestination) { this.routeDestination = routeDestination; }

    public Integer getRouteDistance() { return routeDistance; }

    public void setRouteDistance(Integer routeDistance) { this.routeDistance = routeDistance; }

    public Integer getRouteDuration() { return routeDuration; }

    public void setRouteDuration(Integer routeDuration) { this.routeDuration = routeDuration; }

    public String getRouteStatus() { return status; }

    public void setRouteStatus(String status) { this.status = status; }

    private Integer routeDuration;
    private String status;

}
