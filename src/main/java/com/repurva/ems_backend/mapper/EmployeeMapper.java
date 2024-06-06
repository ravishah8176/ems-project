package com.repurva.ems_backend.mapper;

import com.repurva.ems_backend.dao.EmployeeDAO;
import com.repurva.ems_backend.entity.Employee;

public class EmployeeMapper
{
    // map employee table to employeeDAO
    public static EmployeeDAO mapToEmployeeDAO (Employee theEmployee){
        return new EmployeeDAO(
                theEmployee.getId(),
                theEmployee.getFirstName(),
                theEmployee.getLastName(),
                theEmployee.getEmail()
        );
    }

    // map employeeDAO to employee table
    public static Employee mapToEmployee(EmployeeDAO theEmployeeDAO){
        return new Employee(
                theEmployeeDAO.getId(),
                theEmployeeDAO.getFirstName(),
                theEmployeeDAO.getLastName(),
                theEmployeeDAO.getEmail()
        );

    }
}
