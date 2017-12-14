package com.tms.employee.dao;

import com.tms.employee.model.Employee;
import com.tms.vehicle.model.Vehicle;

import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 11/30/2017.
 */
public interface IEmployeeDAO {

    List <Employee> getAllEmployees();

    Employee getEmployeeByNumber (String employeeNumber) ;

    List <String> getAllEmployeeDesignation ();

    boolean saveEmployee (Employee employee) ;

    Employee getEmployeeById (Integer vehcleId) ;

    boolean updateEmployee (Employee employee) ;

    boolean deleteEmployee (Employee employee) ;

}
