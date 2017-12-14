package com.tms.route.model;
import com.tms.common.model.Track;

import javax.persistence.*;

/**
 * Created by RAVI KALUARACHCHI on 12/10/2017.
 */

@Entity
@Table (name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="route_id")
    private Integer routeId;
    @Column(name="route_name")
    private String routeName;
    @Column(name="origin")
    private String routeOrigin;
    @Column(name="destination")
    private String routeDestination;
    @Column(name="distance")
    private Integer routeDistance;
    @Column(name="duration")
    private Integer routeDuration;
    @Column (name="route_status")
    private String routeStatus;

    public Integer getRouteId() { return routeId; }

    public void setRouteId(Integer routeId) { this.routeId = routeId;}

    public String getRouteName() { return routeName; }

    public void setRouteName(String routeName) { this.routeName = routeName; }

    public String getRouteOrigin() { return routeOrigin; }

    public String getRouteStatus() { return routeStatus; }

    public void setRouteOrigin(String routeOrigin) { this.routeOrigin = routeOrigin; }

    public String getRouteDestination() { return routeDestination; }

    public void setRouteDestination(String routeDestination) { this.routeDestination = routeDestination; }

    public Integer getRouteDistance() { return routeDistance; }

    public void setRouteDistance(Integer routeDistance) { this.routeDistance = routeDistance; }

    public Integer getRouteDuration() { return routeDuration; }

    public void setRouteDuration(Integer routeDuration) { this.routeDuration = routeDuration; }

    public void setRouteStatus(String routeStatus) { this.routeStatus = routeStatus; }





}
