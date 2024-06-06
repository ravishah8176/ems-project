package com.repurva.ems_backend.service;

import com.repurva.ems_backend.dao.EmployeeDAO;

import java.util.List;

public interface EmployeeService
{
    EmployeeDAO createEmployee(EmployeeDAO theEmployeeDAO);

    EmployeeDAO getEmployeeById(Long theEmployeeId);

    List<EmployeeDAO> getAllEmployee();

    EmployeeDAO updateEmployee(Long theEmployee, EmployeeDAO theUpdateEmployeeDAo);

    void deleteEmployeeById(Long theEmployeeId);
}
