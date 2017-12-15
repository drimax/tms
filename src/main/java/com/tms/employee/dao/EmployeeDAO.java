package com.tms.employee.dao;

import com.tms.employee.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by RAVI KALUARACHCHI on 11/30/2017.
 */

@Transactional
@Repository

public class EmployeeDAO implements IEmployeeDAO {

    @PersistenceContext
        private EntityManager entityManager ;

    @Override
    public List<Employee> getAllEmployees() {

        String ehq1 = "FROM Employee as e ORDER BY e.empId" ;
        return (List<Employee>) entityManager.createQuery(ehq1).getResultList();
    }


    @Override
    public Employee getEmployeeByNumber (String epfNo) {

        Employee employee = null ;
        String ehq1 = "FROM Employee e WHERE  e.epfNo = :epfNo" ;
        List <Employee> employees = entityManager.createQuery(ehq1).setParameter( "epfNo",epfNo).getResultList() ;
        if (employees != null && employees.size() > 0){

            employee = employees.get(0) ;
        }

        return employee ;

    }

    @Override

    public List <String> getAllEmployeeDesignation (){return null;}

    @Override
    public boolean saveEmployee (Employee employee) {

        Employee persistedEmployee = null ;
        entityManager.persist(employee) ;
        persistedEmployee = getEmployeeByNumber(employee.getEpfNo()) ;
        if (persistedEmployee != null){

            return true;
        }
            return false;

    }

    @Override
    public Employee getEmployeeById (Integer employeeId) {

        Employee employee = entityManager.find(Employee.class , employeeId ) ;
        return employee ;
    }


    @Override
    public boolean updateEmployee(Employee employee) {
        Employee persistedEmployee = null;
        entityManager.merge(employee);
        persistedEmployee = getEmployeeByNumber(employee.getEmployeeNIC());
        if(persistedEmployee != null){
            return  true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        try{
            entityManager.remove(employee);
        }catch (Exception e){
            return false;
        }

        return true;
    }
}


