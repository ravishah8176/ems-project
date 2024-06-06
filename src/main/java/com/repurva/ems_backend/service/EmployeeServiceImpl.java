package com.repurva.ems_backend.service;

import com.repurva.ems_backend.dao.EmployeeDAO;
import com.repurva.ems_backend.entity.Employee;
import com.repurva.ems_backend.exception.ResourceNotFoundException;
import com.repurva.ems_backend.mapper.EmployeeMapper;
import com.repurva.ems_backend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService
{
    private EmployeeRepository theEmployeeRepository;
    @Override
    public EmployeeDAO createEmployee(EmployeeDAO theEmployeeDAO)
    {
        Employee theEmployee = EmployeeMapper.mapToEmployee(theEmployeeDAO);
        Employee savedEmployee =  theEmployeeRepository.save(theEmployee);
        return EmployeeMapper.mapToEmployeeDAO(savedEmployee);
    }

    @Override
    public EmployeeDAO getEmployeeById(Long theEmployeeId)
    {
        Employee theEmployee = theEmployeeRepository.findById(theEmployeeId)
                .orElseThrow( () ->
                        new ResourceNotFoundException("Employee not exist with employee Id: " + theEmployeeId)
                );
        return EmployeeMapper.mapToEmployeeDAO(theEmployee);
    }

    @Override
    public List<EmployeeDAO> getAllEmployee()
    {
        List<Employee> theEmployeeList = theEmployeeRepository.findAll();

        List<EmployeeDAO> allEmployeeList = new ArrayList<>();
        for (Employee theEmployee : theEmployeeList)
        {
            EmployeeDAO employeeDAO = EmployeeMapper.mapToEmployeeDAO(theEmployee);
            allEmployeeList.add(employeeDAO);
        }
        return allEmployeeList;
    }

    @Override
    public EmployeeDAO updateEmployee(Long theEmployeeId, EmployeeDAO theUpdateEmployeeDAO)
    {
        Employee theEmployee = theEmployeeRepository.findById(theEmployeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee doesn't exist with " +
                        "employee Id "+ theEmployeeId)
                );

        theEmployee.setFirstName(theUpdateEmployeeDAO.getFirstName());
        theEmployee.setLastName(theUpdateEmployeeDAO.getLastName());
        theEmployee.setEmail(theUpdateEmployeeDAO.getEmail());
        Employee theUpdateEmployee = theEmployeeRepository.save(theEmployee);
        return EmployeeMapper.mapToEmployeeDAO(theUpdateEmployee);
    }

    @Override
    public void deleteEmployeeById(Long theEmployeeId)
    {
        Employee theEmployee = theEmployeeRepository.findById(theEmployeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee doesn't exist with " +
                        "employee Id "+ theEmployeeId)
                );
        theEmployeeRepository.deleteById(theEmployeeId);
    }
}
