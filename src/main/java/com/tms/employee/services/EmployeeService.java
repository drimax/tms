package com.tms.employee.services;

import com.tms.employee.adaptor.EmployeeAdaptor;
import com.tms.employee.dao.IEmployeeDAO;
import com.tms.employee.dto.EmployeeDTO;
import com.tms.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 11/30/2017.
 */
@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeDAO employeeDAO;

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        EmployeeAdaptor employeeAdaptor = new EmployeeAdaptor();
        List<EmployeeDTO> dtoList = new ArrayList<>();
        List<Employee> employeesList = employeeDAO.getAllEmployees();
        if (employeesList != null & !employeesList.isEmpty()) {

            for (Employee employee : employeesList) {
                dtoList.add(employeeAdaptor.toDTO(employee));

            }
        }

        return dtoList;

    }

    @Override
    public EmployeeDTO getEmployeeByNIC (String EmployeeNic) {

        EmployeeAdaptor adaptor = new EmployeeAdaptor();
        Employee employee = employeeDAO.getEmployeeByNumber(EmployeeNic);
        if(employee != null){
            return adaptor.toDTO(employee);

        }
        else{
            return null;

        }


    }


    public boolean saveEmployee(EmployeeDTO employeeDTO){

        EmployeeAdaptor adaptor = new EmployeeAdaptor();
        Employee employee = adaptor.toModel(employeeDTO);
//        employee.setCreatedTime(new Date());
//        employee.setModifiedTime(new Date());
//        employee.setVersion(0);
        return employeeDAO.saveEmployee(employee);


    }


    @Override
    public boolean updateEmployee (EmployeeDTO employeeDTO){
        EmployeeAdaptor adaptor = new EmployeeAdaptor();
        Employee employee = adaptor.toModel(employeeDTO);
            Employee existingEmployee = employeeDAO.getEmployeeById(employee.getEmpId());
            if (existingEmployee != null){
//                existingEmployee.setModifiedTime(new Date());
//                existingEmployee.setVersion(existingEmployee.getVersion()+1);
                existingEmployee.setEmployeeDesignation(existingEmployee.getEmployeeDesignation());
                existingEmployee.setStatus(existingEmployee.getStatus());
                return employeeDAO.updateEmployee(existingEmployee);

            } else {
                return false;
            }



    }

    @Override
    public boolean deleteEmployee (EmployeeDTO employeeDTO){
        EmployeeAdaptor adaptor = new EmployeeAdaptor();
        Employee employee = adaptor.toModel(employeeDTO);
        Employee existingEmployee = employeeDAO.getEmployeeById(employee.getEmpId());
        if (existingEmployee !=null){
            return employeeDAO.deleteEmployee(existingEmployee);
        }else{
            return false;
        }

    }

}