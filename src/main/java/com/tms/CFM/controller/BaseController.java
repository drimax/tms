package com.tms.CFM.controller;

import javax.validation.Valid;

import com.tms.employee.services.IEmployeeService;
import com.tms.route.services.IRouteService;
import com.tms.vehicle.model.Vehicle;
import com.tms.vehicle.services.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BaseController {

    @Autowired
    private IVehicleService vehicleService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IRouteService routeService;

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }

    //Spring Security see this :
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashBoardPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("dashboard");

        return model;

    }

    @RequestMapping(value = "/manageVehicle", method = RequestMethod.GET)
    public ModelAndView manageVehiclePage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("vehicle");

        return model;

    }


    @RequestMapping(value = "/manageEmployee", method = RequestMethod.GET)
    public ModelAndView manageEmployeePage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("employee");

        return model;

    }

    @RequestMapping(value = "/manageRoute", method = RequestMethod.GET)
    public ModelAndView manageRoutePage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("route");

        return model;

    }

    @RequestMapping(value = "/manageProduct", method = RequestMethod.GET)
    public ModelAndView manageProductPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("product");

        return model;

    }

    @RequestMapping(value = "/manageFleet", method = RequestMethod.GET)
    public ModelAndView manageFleetPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("fleet");

        return model;

    }
}