package com.tms.employee.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by RAVI KALUARACHCHI on 11/30/2017.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    public Integer empId;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    public String employeeLastName;
    @Transient
    public String employeeNIC;
    @Column (name = "EPF_NO")
    public String epfNo;
    @Column (name = "address1")
    public String employeeAddress;
    @Column (name = "mobile")
    public Integer employeeMobile;
    @Transient
    public String employeeEmail;
    @Column (name = "basic_salary")
    public BigDecimal employeeBasicsalary;
    @Column (name = "allowance")
    public BigDecimal employeeAllowance;
    @Column (name = "designation")
    public String employeeDesignation;
    @Column (name = "status")
    public String status;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeNIC() {
        return employeeNIC;
    }

    public void setEmployeeNIC(String employeeNIC) {
        this.employeeNIC = employeeNIC;
    }

    public String getEpfNo() {
        return epfNo;
    }

    public void setEpfNo(String epfNo) {
        this.epfNo = epfNo;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Integer getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(Integer employeeMobile) {
        this.employeeMobile = employeeMobile;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public BigDecimal getEmployeeBasicsalary() {
        return employeeBasicsalary;
    }

    public void setEmployeeBasicsalary(BigDecimal employeeBasicsalary) {
        this.employeeBasicsalary = employeeBasicsalary;
    }

    public BigDecimal getEmployeeAllowance() {
        return employeeAllowance;
    }

    public void setEmployeeAllowance(BigDecimal employeeAllowance) {
        this.employeeAllowance = employeeAllowance;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



