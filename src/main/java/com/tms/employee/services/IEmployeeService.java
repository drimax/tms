package com.tms.employee.services;

import com.tms.employee.dto.EmployeeDTO;
import com.tms.employee.model.Employee;

import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 11/30/2017.
 */
public interface IEmployeeService {

    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeByNIC(String EmployeeNic);
    boolean saveEmployee(EmployeeDTO employeeDTO);
    boolean updateEmployee(EmployeeDTO employeeDTO);
    boolean deleteEmployee(EmployeeDTO employeeDTO);


}
