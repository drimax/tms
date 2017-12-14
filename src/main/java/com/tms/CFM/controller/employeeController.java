package com.tms.CFM.controller;
import com.tms.common.dto.Response;
import com.tms.employee.dto.EmployeeDTO;
import com.tms.employee.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 11/28/2017.
 */

@Controller
@RequestMapping("/employee")
public class employeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping(value = "/saveEmployees", method = RequestMethod.POST)
    @ResponseBody
    public Response saveEmployees(final EmployeeDTO employeeDTO) {
        Response response = new Response();
        boolean saveSuccess = employeeService.saveEmployee(employeeDTO);
        response.setSuccess(saveSuccess);
        return response;

    }

    @RequestMapping(value = "/getAllEmployees", method = RequestMethod.POST)
    @ResponseBody
    public Response getAllEmployees(String employeeNIC) {
        Response<EmployeeDTO> response = new Response();
        List<EmployeeDTO> employees = new ArrayList<>();
        if(employeeNIC !=  null && employeeNIC != ""){
           EmployeeDTO employee = employeeService.getEmployeeByNIC(employeeNIC);
            if(employee != null){
                employees.add(employee);
            }
        } else {
            employees = employeeService.getAllEmployees();
        }

        response.setTableData(employees);
        response.setSuccess(true);
        return response;

    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public Response updateEmployee(final EmployeeDTO employeeDTO) {
        Response response = new Response();
        boolean saveSuccess = employeeService.updateEmployee(employeeDTO);
        response.setSuccess(saveSuccess);
        return response;
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    @ResponseBody
    public Response deleteEmployee(final EmployeeDTO employeeDTO) {
        Response response = new Response();
       boolean saveSuccess = employeeService.deleteEmployee(employeeDTO);
        response.setSuccess(saveSuccess);
        return response;
    }
}



