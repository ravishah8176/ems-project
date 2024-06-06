package com.repurva.ems_backend.controller;

import com.repurva.ems_backend.dao.EmployeeDAO;
import com.repurva.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController
{
    private EmployeeService theEmployeeService;

    // Build Add Employee REST API
    @PostMapping("/create")
    public ResponseEntity<EmployeeDAO> createEmployee(@RequestBody EmployeeDAO theEmployeeDAO){
        EmployeeDAO savedEmployee = theEmployeeService.createEmployee(theEmployeeDAO);
        return new ResponseEntity<EmployeeDAO>(savedEmployee, HttpStatus.CREATED);
    }

    // build Get Employee REST API
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDAO> getEmployeeById(@PathVariable("id") Long theEmployeeId){
        EmployeeDAO theEmployeeDAO = theEmployeeService.getEmployeeById(theEmployeeId);
        return new ResponseEntity<EmployeeDAO>(theEmployeeDAO, HttpStatus.OK);
    }

    // Build Get All Employee REST API
    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDAO>> getAllEmployee(){
        List<EmployeeDAO> theAllEmployee = theEmployeeService.getAllEmployee();
        return new ResponseEntity<>(theAllEmployee, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDAO> updateEmployee(@PathVariable("id") Long theEmployeeId,
                                                      @RequestBody EmployeeDAO theUpdateEmployeeDAO) {
        EmployeeDAO theEmployeeDAO = theEmployeeService.updateEmployee(theEmployeeId,
                theUpdateEmployeeDAO);

        return new ResponseEntity<>(theEmployeeDAO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long theEmployeeId){
        theEmployeeService.deleteEmployeeById(theEmployeeId);
        return new ResponseEntity<>("The employee with employee_id " + theEmployeeId + " is " +
                "successfully deleted", HttpStatus.OK);
    }
}
