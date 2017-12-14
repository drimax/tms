package com.tms.employee.dto;

import javax.naming.Name;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by RAVI KALUARACHCHI on 11/29/2017.
 */
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = 7526472295222276148L;

    private int id1 ;
    private String employeeFirstName ;
    private String employeeLastName ;
    private String employeeNIC ;



    private String employeeEpfNo;
    private String employeeAddress1 ;
    //private String employeeAddress2 ;
    //private String employeeAddress3 ;
    private int employeePhoneNumber ;
    private int employeeMobileNumber ;
    private String employeeEmail ;
    private BigDecimal employeeBasicSalary ;
    private BigDecimal employeeAllowance ;
    private String employeeDesignation ;
    private String status ;


    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
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

    public String getEmployeeEpfNo() { return employeeEpfNo; }

    public void setEmployeeEpfNo(String employeeEpfNo) { this.employeeEpfNo = employeeEpfNo; }

    public String getEmployeeAddress1() {
        return employeeAddress1;
    }

    public void setEmployeeAddress1(String employeeAddress1) {
        this.employeeAddress1 = employeeAddress1;
    }

    //public String getEmployeeAddress2() {
    //    return employeeAddress2;
    //}

    //public void setEmployeeAddress2(String employeeAddress2) {
    //    this.employeeAddress2 = employeeAddress2;
    //}

    //public String getEmployeeAddress3() {
     //   return employeeAddress3;
    //}

    //public void setEmployeeAddress3(String employeeAddress3) {
     //   this.employeeAddress3 = employeeAddress3;
    //}


    public int getEmployeeMobileNumber() {
        return employeeMobileNumber;
    }

    public void setEmployeeMobileNumber(int employeeMobileNumber) {
        this.employeeMobileNumber = employeeMobileNumber;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) { this.employeeEmail = employeeEmail;}

    public BigDecimal getEmployeeBasicSalary() {
        return employeeBasicSalary;
    }

    public void setEmployeeBasicSalary(BigDecimal employeeBasicSalary) { this.employeeBasicSalary = employeeBasicSalary; }

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
