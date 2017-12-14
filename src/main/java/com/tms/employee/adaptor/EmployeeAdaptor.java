package com.tms.employee.adaptor;

import com.tms.common.adaptor.BasicAdaptor;
import com.tms.employee.dto.EmployeeDTO;
import com.tms.employee.model.Employee;

/**
 * Created by RAVI KALUARACHCHI on 11/30/2017.
 */
public class EmployeeAdaptor extends BasicAdaptor <Employee, EmployeeDTO> {

    @Override
    public Employee toModel (EmployeeDTO dto){

        Employee employee = new Employee();
        employee.setEmpId(dto.getId1());
        employee.setFirstName(dto.getEmployeeFirstName());
        employee.setEmployeeLastName(dto.getEmployeeLastName());
        employee.setEmployeeNIC(dto.getEmployeeNIC());
        employee.setEpfNo(dto.getEmployeeEpfNo());
        employee.setEmployeeAddress(dto.getEmployeeAddress1());
        employee.setEmployeeEmail(dto.getEmployeeEmail());
        employee.setEmployeeMobile(dto.getEmployeeMobileNumber());
        employee.setEmployeeBasicsalary(dto.getEmployeeBasicSalary());
        employee.setEmployeeAllowance(dto.getEmployeeAllowance());
        employee.setEmployeeDesignation(dto.getEmployeeDesignation());
        employee.setStatus(dto.getStatus());

        return employee;
    }



    public EmployeeDTO toDTO(Employee model){

        EmployeeDTO dto = new EmployeeDTO();

        dto.setId1(model.getEmpId());
        dto.setEmployeeFirstName(model.getFirstName());
        dto.setEmployeeLastName(model.getEmployeeLastName());
        dto.setEmployeeNIC(model.getEmployeeNIC());
        dto.setEmployeeEpfNo(model.getEpfNo());
        dto.setEmployeeAddress1(model.getEmployeeAddress());
        //dto.setEmployeeAddress2(model.getEmployeeAddress());
        //
        // dto.setEmployeeAddress3(model.getEmployeeAddress());
        dto.setEmployeeEmail(model.getEmployeeEmail());
        dto.setEmployeeMobileNumber(model.getEmployeeMobile());
        dto.setEmployeeBasicSalary(model.getEmployeeBasicsalary());
        dto.setEmployeeAllowance(model.getEmployeeAllowance());
        dto.setEmployeeDesignation(model.getEmployeeDesignation());
        dto.setStatus(model.getStatus());

        return dto;


    }
}
